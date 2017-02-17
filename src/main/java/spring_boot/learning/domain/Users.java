package spring_boot.learning.domain;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
* @author DexterPoker
* @date 2017年1月16日-下午1:55:29
**/
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	@NotEmpty(message="name不能为空")
	private String name;
	
	@Min(value=1,message="age不能小于1")
	@Max(value=150,message="age不能大于150")
	private int age;
	
	@NotEmpty(message="password不能为空")
	@Size(min=6,max=20,message="password长度6-20")
	private String password;
	
	@NotEmpty(message="roles不能为空")
	private String roles;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + ", roles=" + roles
				+ "]";
	}

}
