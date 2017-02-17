package spring_boot.learning.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_boot.learning.domain.Users;
import spring_boot.learning.mapper.UsersMapper;

/**
* @author DexterPoker
* @date 2017年1月16日-下午2:01:37
**/
@Repository
public class UsersRepo implements UsersMapper{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Users selectById(String id) {
		return this.sqlSessionTemplate.selectOne("selectById",id);
	}

	public List<Users> findAll() {
		return this.sqlSessionTemplate.selectList("findAll");
	}

	public int add(Users user) {
		return this.sqlSessionTemplate.insert("add", user);
	}

	public int deleteById(String id) {
		return this.sqlSessionTemplate.delete("deleteById", id);
	}

	public int update(Users user) {
		return this.sqlSessionTemplate.update("update", user);
	}

	
}
