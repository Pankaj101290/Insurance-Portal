package com.ip.DTO;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AdminDto {

	@Range(min = 1, max = 10, message = "{AdminDto.adminId}")
	private Integer adminId;
	@NotNull
	@Pattern(regexp = "^[A-Z][a-z]+([ ][A-Z][a-z]+){2}$", message = "{AdminDto.adminName}")
	private String adminName;
	@NotNull
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "{AdminDto.adminMobileNumber}")
	private String adminMobileNumber;
	@Email(message = "{AdminDto.adminEmailAddress}")
	private String adminEmailAddress;
	private String adminAddress;
	private String adminGender;
	@Past(message = "{AdminDto.adminDateOfBirth}")
	private LocalDate adminDateOfBirth;
	@Past(message = "{AdminDto.adminJoiningDate}")
	private LocalDate adminJoiningDate;
	@NotNull(message = "{AdminDto.adminPhoto}")
	private MultipartFile adminPhoto;
	private String path;
	@Pattern(regexp = "^[a-zA-Z0-9]+{8,15}$",message = "{AdminDto.adminUserName}")
	private String adminUserName;
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*-_?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "{AdminDto.adminPassword}")
	private String adminPassword;

//	public AdminDto adminToDto(Admin admin) {
//		AdminDto dto = new AdminDto();
//		dto.setAdminId(admin.getAdminId());
//		dto.setAdminName(admin.getAdminName());
//		dto.setAdminAddress(admin.getAdminAddress());
//		dto.setAdminDateOfBirth(admin.getAdminDateOfBirth());
//		dto.setAdminEmailAddress(admin.getAdminEmailAddress());
//		dto.setAdminJoiningDate(admin.getAdminJoiningDate());
//		dto.setAdminGender(admin.getAdminGender());
//		dto.setAdminMobileNumber(admin.getAdminMobileNumber());
//		dto.setPath(admin.getPath());
//		dto.setAdminPassword(admin.getAdminPassword());
//		dto.setAdminUserName(admin.getAdminUserName());
//		
//		return dto;
//
//	}
}
