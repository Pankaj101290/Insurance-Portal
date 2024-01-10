package com.ip.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.DTO.UserDto;
import com.ip.Entity.Policy;
import com.ip.Entity.User;
import com.ip.Exception.IPException;
import com.ip.Service.PolicyServiceImpl;
import com.ip.Service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private PolicyServiceImpl policyService;

	@PostMapping(value = "/register")
	public ResponseEntity<UserDto> regiserUser(@Valid @ModelAttribute UserDto dto) throws IPException, IOException {
		UserDto userDto = userService.addUser(dto);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get/{Id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer Id) throws IPException {
		UserDto dto = userService.getUser(Id);
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/delete/{Id}")
	public String deleteUserById(@PathVariable Integer Id) throws IPException {
		userService.deleteUserById(Id);
		return "User with id " + Id + " deleted successfully...";
	}

	@DeleteMapping(value = "/deleteAll")
	public String deleteAllUsers() throws IPException {
		userService.deleteAllUsers();
		return "All users deleted successfully...";

	}

	@PutMapping(value = "/update")
	public ResponseEntity<UserDto> updateUser(@Valid @ModelAttribute UserDto dto) throws IPException, IOException {
		UserDto userDto = userService.updateUser(dto);
		return ResponseEntity.ok().body(userDto);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<UserDto>> getAllUsers() throws IPException {
		List<UserDto> list = userService.getUserList();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping(value = "{userId}/policy/{policyId}/add")
	public ResponseEntity<Policy> addPolicyToUser(@PathVariable Integer userId, @PathVariable Integer policyId)
			throws IPException {
		Policy addPolicy = userService.addPolicyToUser(userId, policyId);
		return new ResponseEntity<>(addPolicy, HttpStatus.OK);
	}

	@DeleteMapping(value = "{userId}/policy/{policyId}/remove")
	public ResponseEntity<User> removeItemFromCart(@PathVariable Integer userId, @PathVariable Integer policyId)
			throws IPException {
		User removePolicy = userService.removePolicyFromUser(userId, policyId);
		return new ResponseEntity<>(removePolicy, HttpStatus.OK);
	}

}
