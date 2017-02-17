package spring_boot.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import spring_boot.learning.domain.Users;
import spring_boot.learning.repository.UsersRepo;

/**
* @author DexterPoker
* @date 2017年1月16日-下午2:04:41
**/
@RestController
@RequestMapping("/users")
//@Cacheable(value="user-key")
@Api(value="用户" , description = "用户管理")
public class UsersController {

	@Autowired
	private UsersRepo usersRepo;
	
	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String" ,paramType = "path")
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Users selectById(@PathVariable String id){
		return usersRepo.selectById(id);
	}
	
	@ApiOperation(value = "获取所有用户", notes = "查询全部的用户信息")
	@RequestMapping(method = RequestMethod.GET)
	public List<Users> findAll(){
		return usersRepo.findAll();
	}
	
	@ApiOperation(value = "添加用户", notes= "上传用户对象")
	@ApiImplicitParam(name = "user" , value = "用户对象", required = true, dataType = "Users")
	@RequestMapping(method = RequestMethod.POST)
	public Map<String,String> add(@RequestBody @Validated Users user){
		Map<String,String> result = new HashMap<>();
		result.put("result", usersRepo.add(user)+"");
		return result;
	}
	
	@ApiOperation(value = "用户更新", notes = "根据用户id更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id" , value = "用户id", required = true, dataType = "String", paramType = "path"),
		@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "Users")
	})
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public Map<String,String> update(@PathVariable String id,@RequestBody Users user){
		Users users = usersRepo.selectById(id);
		if(user.getAge()>0)
			users.setAge(user.getAge());
		if(!StringUtils.isEmpty(user.getName()))
			users.setName(user.getName());
		if(!StringUtils.isEmpty(user.getPassword()))
			users.setPassword(user.getPassword());
		if(!StringUtils.isEmpty(users.getRoles()))
			users.setRoles(user.getRoles());
		Map<String, String> result = new HashMap<>();
		result.put("result", usersRepo.update(users)+"");
		return result;
	}
	
	@ApiOperation(value = "用户删除", notes = "根据用户id删除")
	@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String", paramType = "path")
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public Map<String,String> delete(@PathVariable String id){
		Map<String, String> result = new HashMap<>();
		result.put("result", usersRepo.deleteById(id)+"");
		return result;
	}
	
}
