package org.com.yp.mapper;

import org.com.yp.annotation.Mapper;
import org.com.yp.annotation.Select;

/**
 * 模拟mybatis通过接口查询数据库
 * @Author by yuanpeng
 * @Date 2020/12/12
 */
@Mapper
public interface UserMapper {
    /**
     * 模拟查询数据库
     * @param id
     * @return
     */
    @Select(value = "select userName from user where id = #{id}")
    String findNameById(Long id);

}
