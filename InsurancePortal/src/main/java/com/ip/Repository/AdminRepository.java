package com.ip.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ip.DTO.AdminDto;
import com.ip.Entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

	public Admin findByAdminName(String name);
	
	public Admin findByAdminUserName(String name);
}
