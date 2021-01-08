package com.invdu.nlp.mapper;

import com.invdu.nlp.bean.Greeting;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by InvincibleDudu on 01/08/2021 at 13:39
 */

@Mapper
@Repository
public interface GreetingMapper {
    @Select("select * from greeting where id = #{id}")
    Greeting getGreetingById (long id);

    @Insert("insert into greeting values(#{id}, #{name})")
    int saveGreeting(long id, String name);

    @Delete("delete from greeting where id = #{id}")
    int deleteGreeting(long id);    //how many rows are deleted
}
