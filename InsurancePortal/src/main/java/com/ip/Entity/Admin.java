package com.ip.Entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	private String adminName;
	@Column(unique = true)
	private String adminMobileNumber;
	private String adminEmailAddress;
	private String adminAddress;
	private String adminGender;
	private LocalDate adminDateOfBirth;
	private LocalDate adminJoiningDate;
	@Lob
	private byte[] adminPhoto;
	private String path;
	@Column(unique = true)
	private String adminUserName;
	@Column(unique = true)
	private String adminPassword;

	
//	public Admin dtoToAdmin(AdminDto dto) throws IOException {
//		Admin admin = new Admin();
//		admin.setAdminId(dto.getAdminId());
//		admin.setAdminName(dto.getAdminName());
//		admin.setAdminAddress(dto.getAdminAddress());
//		admin.setAdminDateOfBirth(dto.getAdminDateOfBirth());
//		admin.setAdminEmailAddress(dto.getAdminEmailAddress());
//		admin.setAdminJoiningDate(dto.getAdminJoiningDate());
//		admin.setAdminGender(dto.getAdminGender());
//		admin.setAdminMobileNumber(dto.getAdminMobileNumber());
//		admin.setAdminPassword(dto.getAdminPassword());
//		admin.setAdminUserName(dto.getAdminUserName());
//
//		MultipartFile file = dto.getAdminPhoto();
//		byte[] bytes = file.getBytes();
//		admin.setAdminPhoto(bytes);
//		String originalFilename = file.getOriginalFilename();
//		admin.setPath(originalFilename);
//		System.out.println("1 "+admin);
//		return admin;
//	}
}
