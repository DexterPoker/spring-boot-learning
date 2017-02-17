package spring_boot.learning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import spring_boot.learning.domain.Users;
import spring_boot.learning.repository.UsersRepo;

/**
* @author DexterPoker
* @date 2017年2月17日-上午11:24:59
**/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {

	@Autowired
	private UsersRepo userRepo;

	public void add(@Validated Users user){
		userRepo.add(user);
	}
	
	@Test
	@Transactional()
	public void transcationTest(){
		Users user = new Users();
		user.setAge(18);
		user.setName("Alice");
		user.setPassword("123123");
		user.setRoles("USER");
		add(user);
		
		user  = new Users();
		user.setAge(19);
		user.setName("Bob");
		user.setPassword("123");
		user.setRoles("USER");
		add(user);
	}
	
}
