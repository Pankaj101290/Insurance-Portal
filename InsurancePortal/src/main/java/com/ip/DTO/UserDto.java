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
public class UserDto {
	@Range(min = 1, max = 10000, message = "{UserDto.userId}")
	private Integer userId;
	@NotNull
	@Pattern(regexp = "^[A-Z][a-z]+([ ][A-Z][a-z]+){2}$", message = "{UserDto.userName}")
	private String userName;
	private String userAddress;
	private String userGender;
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "{UserDto.userMobileNumber}")
	private String userMobileNumber;
	@Email(message = "{UserDto.userEmailAddress}")
	private String userEmail;
	private Integer userAge;
	@NotNull(message="{UserDto.userPhoto}")
	private MultipartFile userPhoto;
	private String userPhotoPath;
	@Past(message = "{UserDto.userDateOfBirth}")
	private LocalDate userDateOfBirth;
	@Pattern(regexp = "^[a-zA-Z0-9]+{8,15}$",message = "{UserDto.userUserName}")
	private String userUserName;
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*-_?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "{UserDto.userPassword}")
	private String userPassword;
}
