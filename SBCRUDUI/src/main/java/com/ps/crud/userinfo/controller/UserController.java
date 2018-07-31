package com.ps.crud.userinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.crud.userinfo.entity.Result;
import com.ps.crud.userinfo.entity.User;

@RestController
public class UserController {

	/*@Autowired
	private RestTemplate restTemp;*/
	
/*	@RequestMapping("/query/{userid}")
	public List<User> getUserById(@PathVariable String userid){
		return userMapper.queryUserById(userid);
	}*/
	
	//private static final String url="http://crudservice:8080";
	
	@Autowired
	private UserFeign userFeign;
	
	@GetMapping("/queryUser")
	public Result queryUser(Integer page,Integer limit,String username){
		/*if (username==null) {
			username="";
		}
		ResponseEntity<Result> responseEntity=restTemp.getForEntity(url+"/queryUser?page="+page+"&limit="+limit+"&username="+username, Result.class);
		return responseEntity.getBody();*/
		return userFeign.queryUser(page, limit, username);
	}
	
	
	@PostMapping("/addUser")
	public Result addUser(User user){
		
		/*ResponseEntity<Result> responseEntity=restTemp.postForEntity(url+"/addUser",user , Result.class);
		return responseEntity.getBody();*/
		
		return userFeign.addUser(user);
	}
	
	/*String userDeleteUrl=url+"/deluser/{dID}";*/
	@DeleteMapping("/deluser/{dID}")
	public Result deleteUser(@PathVariable String dID) {
		/*HttpEntity httpRequest = new HttpEntity("", new HttpHeaders());
		Map map = new HashMap();
		map.put("dID", dID);
		Result result = (Result) restTemp.exchange(userDeleteUrl, HttpMethod.DELETE,httpRequest,Result.class,map).getBody();
		return result;*/
		return userFeign.deleteUser(dID);
	}
	
	/*String userDeletesUrl=url+"/delusers/{deleteIds}";*/
	@DeleteMapping("/delusers")
	public Result deleteUsers(String deleteIds) {
		/*HttpEntity httpRequest = new HttpEntity("", new HttpHeaders());
		Map map = new HashMap();
		map.put("deleteIds", deleteIds);
		Result result = (Result) restTemp.exchange(userDeletesUrl, HttpMethod.DELETE,httpRequest,Result.class,map).getBody();
		return result;*/
		return userFeign.deleteUsers(deleteIds);
	}
	
	@PutMapping("/updateuser")
	public Result updateUsers(User user) {
	/*	HttpEntity httpRequest = new HttpEntity(user, new HttpHeaders());
		Result result = (Result) restTemp.exchange(url+"updateuser", HttpMethod.PUT,httpRequest,Result.class).getBody();
		return result;*/
		return userFeign.updateUsers(user);
	}
}
