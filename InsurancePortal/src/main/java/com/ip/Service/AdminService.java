package com.ip.Service;

import java.io.IOException;
import java.util.List;

import com.ip.DTO.AdminDto;
import com.ip.Exception.IPException;

public interface AdminService {

	public AdminDto saveAdmin(AdminDto dto) throws IPException, IOException;

	public AdminDto getAdminById(Integer id) throws IPException;
	
	public String adminLogin(AdminDto dto) throws IPException;

	public String deleteById(Integer id) throws IPException;

	public String deleteAll() throws IPException;

	public AdminDto update(AdminDto dto) throws IPException, IOException;

	public List<AdminDto> getAllAdmins() throws IPException;
}
