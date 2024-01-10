package com.ip.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ip.Entity.Policy;

public interface PolicyRepository extends CrudRepository<Policy, Integer> {

	public Policy findByPolicyName(String name);

	public List<Policy> findByPolicyType(String type);
}
