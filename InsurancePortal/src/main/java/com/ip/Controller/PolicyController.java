package com.ip.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.DTO.PolicyDto;
import com.ip.Exception.IPException;
import com.ip.Service.PolicyServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/policy")
public class PolicyController {

	@Autowired
	private PolicyServiceImpl policyService;

	@PostMapping(value = "/add")
	public ResponseEntity<PolicyDto> addPolicy(@Valid @RequestBody PolicyDto dto) throws IPException {
		PolicyDto dto2 = policyService.addPolicy(dto);
		return new ResponseEntity<PolicyDto>(dto2, HttpStatus.OK);

	}

	@GetMapping(value = "/get/{Id}")
	public ResponseEntity<PolicyDto> getById(@PathVariable Integer Id) throws IPException {
		PolicyDto dto = policyService.getPolicyById(Id);
		return new ResponseEntity<PolicyDto>(dto, HttpStatus.OK);

	}

	@DeleteMapping(value = "/delete/{Id}")
	public String deletePolicyById(@PathVariable Integer Id) throws IPException {
		policyService.deleteById(Id);
		return " Policy deleted Successfully...";
	}

	@DeleteMapping(value = "/deleteAll")
	public String deleteAllPolicies() {
		policyService.deleteAll();
		return " Policy deleted Successfully...";
	}

	@PutMapping(value = "/update")
	public ResponseEntity<PolicyDto> updatePolicy(@Valid @RequestBody PolicyDto dto) throws IPException {
		PolicyDto dto1 = policyService.updatePolicy(dto);
		return ResponseEntity.ok().body(dto1);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<PolicyDto>> getAllPolicy() throws IPException {
		List<PolicyDto> list = policyService.findAllPolicy();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/getbyType/{type}")
	public ResponseEntity<List<PolicyDto>> getAllPolicyByType(@PathVariable String type) throws IPException {
		List<PolicyDto> list = policyService.findAllPolicyByType(type);
		return ResponseEntity.ok().body(list);
	}
}
