package com.ip.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ip.DTO.AdminDto;
import com.ip.Entity.Admin;
import com.ip.Exception.IPException;
import com.ip.Repository.AdminRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminDto saveAdmin(AdminDto dto) throws IPException, IOException {
		Admin dto1 = adminRepository.findByAdminName(dto.getAdminName());
		if (dto1 != null) {
			throw new IPException("Admin already present with name: " + dto.getAdminName());
		} else {
			Admin admin = new Admin();
			admin.setAdminId(dto.getAdminId());
			admin.setAdminName(dto.getAdminName());
			admin.setAdminAddress(dto.getAdminAddress());
			admin.setAdminDateOfBirth(dto.getAdminDateOfBirth());
			admin.setAdminEmailAddress(dto.getAdminEmailAddress());
			admin.setAdminJoiningDate(dto.getAdminJoiningDate());
			admin.setAdminGender(dto.getAdminGender());
			admin.setAdminMobileNumber(dto.getAdminMobileNumber());
			admin.setAdminPassword(dto.getAdminPassword());
			admin.setAdminUserName(dto.getAdminUserName());

			MultipartFile file = dto.getAdminPhoto();
			byte[] bytes = file.getBytes();
			admin.setAdminPhoto(bytes);
			String originalFilename = file.getOriginalFilename();
			admin.setPath(originalFilename);
			
			Admin admin1 = adminRepository.save(admin);
			
			
			AdminDto dto2 = new AdminDto();
			dto2.setAdminId(admin1.getAdminId());
			dto2.setAdminName(admin1.getAdminName());
			dto2.setAdminAddress(admin1.getAdminAddress());
			dto2.setAdminDateOfBirth(admin1.getAdminDateOfBirth());
			dto2.setAdminEmailAddress(admin1.getAdminEmailAddress());
			dto2.setAdminJoiningDate(admin1.getAdminJoiningDate());
			dto2.setAdminGender(admin1.getAdminGender());
			dto2.setAdminMobileNumber(admin1.getAdminMobileNumber());
			dto2.setPath(admin1.getPath());
			dto2.setAdminPassword(admin1.getAdminPassword());
			dto2.setAdminUserName(admin1.getAdminUserName());
			return dto2;
		}

	}

	@Override
	public AdminDto getAdminById(Integer id) throws IPException {
		Optional<Admin> findById = adminRepository.findById(id);
		Admin admin = findById.orElseThrow(() -> new IPException("Admin not found with Id: " + id));
		System.out.println("1 " +admin);
		AdminDto dto = new AdminDto();
		dto.setAdminId(admin.getAdminId());
		dto.setAdminName(admin.getAdminName());
		dto.setAdminAddress(admin.getAdminAddress());
		dto.setAdminDateOfBirth(admin.getAdminDateOfBirth());
		dto.setAdminEmailAddress(admin.getAdminEmailAddress());
		dto.setAdminJoiningDate(admin.getAdminJoiningDate());
		dto.setAdminGender(admin.getAdminGender());
		dto.setAdminMobileNumber(admin.getAdminMobileNumber());
		dto.setPath(admin.getPath());
		dto.setAdminPassword(admin.getAdminPassword());
		dto.setAdminUserName(admin.getAdminUserName());
		return dto;
	}

	@Override
	public String deleteById(Integer id) throws IPException {
		Optional<Admin> findById = adminRepository.findById(id);
		Admin admin = findById.orElseThrow(() -> new IPException("Admin not found with Id: " + id));
		adminRepository.delete(admin);
		return "Admin deleted Successfully...";
	}

	@Override
	public String deleteAll() throws IPException {
		adminRepository.deleteAll();
		return "All admins deleted Successfully...";
	}

	@Override
	public AdminDto update(AdminDto dto) throws IPException, IOException {
		Admin admin1 = adminRepository.findByAdminName(dto.getAdminName());
		if (admin1 != null) {
			throw new IPException("Admin not found with name: " + dto.getAdminName());
		} else {
			Admin admin = new Admin();
			admin.setAdminId(dto.getAdminId());
			admin.setAdminName(dto.getAdminName());
			admin.setAdminAddress(dto.getAdminAddress());
			admin.setAdminDateOfBirth(dto.getAdminDateOfBirth());
			admin.setAdminEmailAddress(dto.getAdminEmailAddress());
			admin.setAdminJoiningDate(dto.getAdminJoiningDate());
			admin.setAdminGender(dto.getAdminGender());
			admin.setAdminMobileNumber(dto.getAdminMobileNumber());
			admin.setAdminPassword(dto.getAdminPassword());
			admin.setAdminUserName(dto.getAdminUserName());

			MultipartFile file = dto.getAdminPhoto();
			byte[] bytes = file.getBytes();
			admin.setAdminPhoto(bytes);
			String originalFilename = file.getOriginalFilename();
			admin.setPath(originalFilename);
			System.out.println("1 "+admin);
			Admin admin2 = adminRepository.save(admin);

			AdminDto dto2 = new AdminDto();
			dto2.setAdminId(admin2.getAdminId());
			dto2.setAdminName(admin2.getAdminName());
			dto2.setAdminAddress(admin2.getAdminAddress());
			dto2.setAdminDateOfBirth(admin2.getAdminDateOfBirth());
			dto2.setAdminEmailAddress(admin2.getAdminEmailAddress());
			dto2.setAdminJoiningDate(admin2.getAdminJoiningDate());
			dto2.setAdminGender(admin2.getAdminGender());
			dto2.setAdminMobileNumber(admin2.getAdminMobileNumber());
			dto2.setPath(admin2.getPath());
			dto2.setAdminPassword(admin2.getAdminPassword());
			dto2.setAdminUserName(admin2.getAdminUserName());
			return dto2;
		}
	}

	public List<AdminDto> getAllAdmins() throws IPException {
		Iterable<Admin> findAll = adminRepository.findAll();
		List<AdminDto> dtoList = null;
		if (findAll != null) {
			List<Admin> list = new ArrayList<Admin>();
			for (Admin l : findAll) {
				list.add(l);
			}
			dtoList = list.stream().map((Admin admin) -> {
				AdminDto dto = new AdminDto();
				dto.setAdminId(admin.getAdminId());
				dto.setAdminName(admin.getAdminName());
				dto.setAdminAddress(admin.getAdminAddress());
				dto.setAdminDateOfBirth(admin.getAdminDateOfBirth());
				dto.setAdminEmailAddress(admin.getAdminEmailAddress());
				dto.setAdminJoiningDate(admin.getAdminJoiningDate());
				dto.setAdminGender(admin.getAdminGender());
				dto.setAdminMobileNumber(admin.getAdminMobileNumber());
				dto.setPath(admin.getPath());
				dto.setAdminPassword(admin.getAdminPassword());
				dto.setAdminUserName(admin.getAdminUserName());
				return dto;
			}).collect(Collectors.toList());

			return dtoList;
		} else {
			throw new IPException(" Policies not available...");
		}
	}

	public String adminLogin(AdminDto dto) throws IPException {
		Admin admin = adminRepository.findByAdminUserName(dto.getAdminUserName());
		if (admin == null)
			throw new IPException("Admin username " + dto.getAdminUserName() + " is invalid");
		else if (dto.getAdminPassword().trim().equals(admin.getAdminPassword().trim())) {
			return "Admin logged in successfully...";
		} else {
			throw new IPException("Invalid password");
		}

	}
}
