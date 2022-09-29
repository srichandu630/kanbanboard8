package com.kanabanboard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kanbanboard.entity.User;
import com.kanbanboard.entity.UserDTO;
import com.kanbanboard.entity.UserSignInDTO;
import com.kanbanboard.exceptions.UserNotFoundException;
import com.kanbanboard.repo.UserRepository;
import com.kanbanboard.service.UserServiceImpl;


@RestController
@RequestMapping(value = "UserAPI")
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.POST })
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private UserRepository userRepo;

	@PostMapping("/userSignIn")	
	public Optional<User> userSignIn(@RequestBody UserSignInDTO LoginInfo) {
		Optional<User> singleUser= this.userServiceImpl.showAllUsers().stream().filter(t -> (LoginInfo.getEmail().equals(t.getEmail()) && LoginInfo.getPwd().equals(t.getPwd()))).findFirst();
		return singleUser;
	}
	

	@PostMapping("/addUser")
	public User createUser(@RequestBody UserDTO userDTO) {
		System.out.println("User controller  --- addUser");
		return this.userServiceImpl.createRegister(userDTO);
	}

	@GetMapping("/getUser")
	public List<User> updateUser() {
		List<User> data = userRepo.findAll();
		return data;
	}

	@GetMapping("/getSingleUser/{userId}")
	public  Optional<User> getUserById(@PathVariable("userId") Integer userId) {
		 Optional<User> data = this.userServiceImpl.getUserById(userId);
		return data;	
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody UserDTO userDTO) throws UserNotFoundException {
		return this.userServiceImpl.updateUser(userDTO);

	}

	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) throws UserNotFoundException {
		Optional<User> userOpt = this.userRepo.findById(userId);
		if (userOpt.isEmpty())
			throw new UserNotFoundException("User id does not exist to delete.");
		this.userRepo.deleteById(userId);
		return "User deleted successfully";

	}
}