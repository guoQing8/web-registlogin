package com.superli.loginRegist.regist.controller;


import com.superli.loginRegist.regist.mapper.RegistUserMapper;
import com.superli.loginRegist.regist.pojo.RegistUser;
import com.superli.loginRegist.utils.jwt.JwtUtil;
import com.superli.loginRegist.utils.md5.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author superli
 * @since 2022-04-15
 */

@RestController
@RequestMapping("/user")
//@CrossOrigin
public class RegistUserController {
    /**
     * http://127.0.0.1/localhost:8963/user/test
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)


    public String getData() {
        return "String";
    }

    @Autowired
    private RegistUserMapper registUserMapper;


    /**
     *
     http://127.0.0.1/localhost:8963/user/register
     * @param userName
     * @param passwd
     * @param email
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public Map<String, Object> register(@RequestParam String userName,
                                        @RequestParam String passwd,
                                        @RequestParam String email,
                                        @RequestParam String name,
                                        @RequestParam int sex) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passwd)) {
            map.put("msg", "用户名或密码不能为空");
            return map;
        }
        // 验证用户名是否已经注册
        map.put("userName",userName);
        List<RegistUser> registUsers = registUserMapper.selectByMap(map);
        boolean flag=false;
        for(RegistUser aa:registUsers){
            System.out.println(aa);
            flag=true;
        }
        if (flag) {
            map.put("msg", "该用户名已存在!");
            return map;
        }
        RegistUser registUser = new RegistUser();
        registUser.setName(name);
        registUser.setSex(sex);
        registUser.setUsername(userName);
        registUser.setPassword(Md5Util.MD5(passwd) + userName);
        registUser.setEmail(email);
        int count = registUserMapper.insert(registUser);
        System.out.println(count);
        if (count != 1) {
            map.put("msg", "注册失败");
            return map;
        }
        map.put("msg", "注册成功");
        return map;
    }

    /**
     * @param userName
     * @param passwd
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)


    public Map<String, Object> login(@RequestParam String userName,
                                     @RequestParam String passwd
    ) {

        Map<String, Object> map = new HashMap<String, Object>();
        // 验证用户名是否已经注册
        map.put("userName", userName);
        List<RegistUser> registUsers = registUserMapper.selectByMap(map);
        boolean flag = false;
        String password = "";
        for (RegistUser aa : registUsers) {
            System.out.println(aa);
            flag = true;
            password = aa.getPassword();
        }
        if (!flag) {
            map.put("msg", "该用户名不存在!");
            return map;
        }
        if (!password.equals(Md5Util.MD5(passwd) + userName)) {
            map.put("msg", "密码错误");
            return map;
        }
        String token = JwtUtil.creatToken(userName);

        map.put("token", token);
        String msg1 = "登录成功";
//        HttpSession session=request.getSession();
//        session.setAttribute("userName",userName);
//        Cookie cookie = new Cookie("userName", userName);
//        cookie.setMaxAge(60*5);
//        response.addCookie(cookie);
//        System.out.println(session);

        map.put("msg1", msg1);
        return map;
    }

    @RequestMapping(value = "/succeed", method = RequestMethod.POST)

    public Map<String, Object> d(String token, String username) {
        Map<String, Object> map = new HashMap<String, Object>();
        boolean b = JwtUtil.checkToken(token);
        if (!b) {
            map.put("msg", "登录过期");
            return map;
        }

        map.put("userName", username);

        List<RegistUser> registUsers = registUserMapper.selectByMap(map);


        for (RegistUser aa : registUsers) {
            map.put("id", aa.getId());
            map.put("email", aa.getEmail());
            map.put("name", aa.getName());
            map.put("sex", aa.getSex());


        }
        return map;


    }
}

