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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.DTO.AdminDto;
import com.ip.Exception.IPException;
import com.ip.Service.AdminServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {


	@Autowired
	private AdminServiceImpl adminService;

	@PostMapping(value = "/save")
	public ResponseEntity<AdminDto> registerAdmin(@Valid @ModelAttribute AdminDto dto) throws IPException, IOException {
		AdminDto add = adminService.saveAdmin(dto);
		return ResponseEntity.ok().body(add);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<String> adminLogin(@RequestBody AdminDto dto) throws IPException {
		String message = adminService.adminLogin(dto);
		return ResponseEntity.ok().body(message);
	}

	@GetMapping(value = "/get/{Id}")
	public ResponseEntity<AdminDto> getAdminById(@Valid @PathVariable Integer Id) throws IPException {
		AdminDto dto = adminService.getAdminById(Id);
		System.out.println("5 "+dto);
		return new ResponseEntity<AdminDto>(dto, HttpStatus.OK);
	}

	@DeleteMapping(value = "/del/{Id}")
	public ResponseEntity<String> deleteAdmin(@Valid @PathVariable Integer Id) throws IPException {
		String message = adminService.deleteById(Id);
		return ResponseEntity.ok().body(message);

	}

	@DeleteMapping(value = "/Alldel")
	public ResponseEntity<String> deleteAllAdmins() throws IPException {
		String message = adminService.deleteAll();
		return ResponseEntity.ok().body(message);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<AdminDto> updateAdmin(@ModelAttribute AdminDto dto) throws IPException, IOException {
		AdminDto updatedAdmin = adminService.update(dto);
		return new ResponseEntity<AdminDto>(updatedAdmin, HttpStatus.OK);

	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<AdminDto>> getAll() throws IPException {
		List<AdminDto> dto = adminService.getAllAdmins();
		return ResponseEntity.ok().body(dto);

	}
}
