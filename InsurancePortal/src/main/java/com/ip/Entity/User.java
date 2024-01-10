package com.ip.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;
	private String userName;
	private String userAddress;
	private String userGender;
	@Column(unique = true)
	private String userMobileNumber;
	@Column(unique = true)
	private String userEmail;
	private Integer userAge;
	private byte[] userPhoto;
	private String userPhotoPath;
	private LocalDate userDateOfBirth;
	@Column(unique = true)
	private String userUserName;
	@Column(unique = true)
	private String userPassword;

	@JsonBackReference
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Policy> policies = new ArrayList<>();

	public void addPolicies(Policy policy) {
		policies.add(policy);
	}

	public void removePolicy(Policy policy) {
		policies.remove(policy);
	}

}
