package com.ip.Service;

import java.util.List;

import com.ip.DTO.PolicyDto;
import com.ip.Exception.IPException;

public interface PolicyService {

	public PolicyDto addPolicy(PolicyDto dto) throws IPException;

//	//1.
//	public PolicyDto savePolicy(PolicyDto policyDto, Integer userId);

	public PolicyDto getPolicyById(Integer id) throws IPException;

	public void deleteById(Integer Id) throws IPException;

	public void deleteAll();

	public PolicyDto updatePolicy(PolicyDto dto) throws IPException;

	public List<PolicyDto> findAllPolicy() throws IPException;

	public List<PolicyDto> findAllPolicyByType(String type) throws IPException;
}
