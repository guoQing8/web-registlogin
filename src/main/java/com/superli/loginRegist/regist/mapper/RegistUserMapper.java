package com.superli.loginRegist.regist.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.superli.loginRegist.regist.pojo.RegistUser;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author superli
 * @since 2022-04-18
 */


@Repository
public interface RegistUserMapper extends BaseMapper<RegistUser> {
    //里面mybatisplus已经悄咪咪的帮我写了很多sql语句,感谢感谢

}
