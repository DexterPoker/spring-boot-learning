package spring_boot.learning.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import spring_boot.learning.domain.Users;

/**
* @author DexterPoker
* @date 2017年1月16日-下午1:57:19
**/
@Mapper
public interface UsersMapper {
	
	@Insert("insert into users (name,age,password,roles) values(#{name},#{age},#{password},#{roles})")
	int add(Users user);
	
	@Delete("delete from users where id = #{id}")
	int deleteById(String id);
	
	@Update("update users set name = #{name},age = #{age},password = #{password},roles = #{roles} where id = #{id}")
	int update(Users user);
	
	@Select("select * from users where id = #{id}")
	Users selectById(@Param("id") String id );
	
	@Select("select * from users")
	List<Users> findAll();
}
