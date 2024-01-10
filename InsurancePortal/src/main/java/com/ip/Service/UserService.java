package com.ip.Service;

import java.io.IOException;
import java.util.List;

import com.ip.DTO.PolicyDto;
import com.ip.DTO.UserDto;
import com.ip.Entity.Policy;
import com.ip.Entity.User;
import com.ip.Exception.IPException;

public interface UserService {

	public UserDto addUser(UserDto dto) throws IPException, IOException;

	// 1.
//	public PolicyDto createPolicyForUser(Integer userId, PolicyDto policyDto);
//
//	//2.
//	public List<PolicyDto> getPoliciesByUserId(Long userId);

	public UserDto getUser(Integer id) throws IPException;

	public void deleteUserById(Integer id) throws IPException;

	public void deleteAllUsers() throws IPException;

	public UserDto updateUser(UserDto dto) throws IPException, IOException;

	public List<UserDto> getUserList() throws IPException;

	// 3
	public Policy addPolicyToUser(Integer userId, Integer policyId) throws IPException;

	//4
	public User removePolicyFromUser(Integer userId, Integer policyId) throws IPException;
}
