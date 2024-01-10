package com.ip.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ip.DTO.PolicyDto;
import com.ip.DTO.UserDto;
import com.ip.Entity.Policy;
import com.ip.Entity.User;
import com.ip.Exception.IPException;
import com.ip.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PolicyServiceImpl policyService;

	@Override
	public UserDto addUser(UserDto dto) throws IPException, IOException {
		User user = userRepository.findByUserName(dto.getUserName());
		if (user != null) {
			throw new IPException("User already registered with username: " + dto.getUserUserName());
		} else {
			User user1 = new User();
			user1.setUserAddress(dto.getUserAddress());
			user1.setUserAge(dto.getUserAge());
			user1.setUserDateOfBirth(dto.getUserDateOfBirth());
			user1.setUserEmail(dto.getUserEmail());
			user1.setUserGender(dto.getUserGender());
			user1.setUserMobileNumber(dto.getUserMobileNumber());
			user1.setUserName(dto.getUserName());
			user1.setUserUserName(dto.getUserUserName());
			user1.setUserPassword(dto.getUserPassword());

			MultipartFile file = dto.getUserPhoto();
			byte[] bytes = file.getBytes();
			user1.setUserPhoto(bytes);
			String string = file.getOriginalFilename();
			user1.setUserPhotoPath(string);

			User user2 = userRepository.save(user1);

			UserDto dto1 = new UserDto();
			dto1.setUserId(user2.getUserId());
			dto1.setUserAddress(user2.getUserAddress());
			dto1.setUserAge(user2.getUserAge());
			dto1.setUserDateOfBirth(user2.getUserDateOfBirth());
			dto1.setUserEmail(user2.getUserEmail());
			dto1.setUserGender(user2.getUserGender());
			dto1.setUserMobileNumber(user2.getUserMobileNumber());
			dto1.setUserName(user2.getUserName());
			dto1.setUserUserName(user2.getUserUserName());
			dto1.setUserPassword(user2.getUserPassword());
			dto1.setUserPhotoPath(user2.getUserPhotoPath());
			return dto1;
		}

	}

	@Override
	public UserDto getUser(Integer id) throws IPException {
		Optional<User> user = userRepository.findById(id);
		User user2 = user.orElseThrow(() -> new IPException("User not found with id: " + id));

		UserDto dto1 = new UserDto();
		dto1.setUserId(user2.getUserId());
		dto1.setUserAddress(user2.getUserAddress());
		dto1.setUserAge(user2.getUserAge());
		dto1.setUserDateOfBirth(user2.getUserDateOfBirth());
		dto1.setUserEmail(user2.getUserEmail());
		dto1.setUserGender(user2.getUserGender());
		dto1.setUserMobileNumber(user2.getUserMobileNumber());
		dto1.setUserName(user2.getUserName());
		dto1.setUserUserName(user2.getUserUserName());
		dto1.setUserPassword(user2.getUserPassword());
		dto1.setUserPhotoPath(user2.getUserPhotoPath());

		return dto1;
	}

	@Override
	@Transactional
	public void deleteUserById(Integer id) throws IPException {
		Optional<User> findById = userRepository.findById(id);
		User user = findById.orElseThrow(() -> new IPException("User not found with id: " + id));
		userRepository.delete(user);
	}

	@Override
	public void deleteAllUsers() throws IPException {
		userRepository.deleteAll();

	}

	@Override
	@Transactional
	public UserDto updateUser(UserDto dto) throws IPException, IOException {
		User user = userRepository.findByUserName(dto.getUserName());
		if (user != null) {
			throw new IPException("Admin not found with name: " + dto.getUserName());
		} else {
			User user1 = new User();
			user1.setUserAddress(dto.getUserAddress());
			user1.setUserAge(dto.getUserAge());
			user1.setUserDateOfBirth(dto.getUserDateOfBirth());
			user1.setUserEmail(dto.getUserEmail());
			user1.setUserGender(dto.getUserGender());
			user1.setUserMobileNumber(dto.getUserMobileNumber());
			user1.setUserName(dto.getUserName());
			user1.setUserUserName(dto.getUserUserName());
			user1.setUserPassword(dto.getUserPassword());
			MultipartFile file = dto.getUserPhoto();
			byte[] bytes = file.getBytes();
			user1.setUserPhoto(bytes);
			String string = file.getOriginalFilename();
			user1.setUserPhotoPath(string);
			User user2 = userRepository.save(user1);

			UserDto dto1 = new UserDto();
			dto1.setUserId(user2.getUserId());
			dto1.setUserAddress(user2.getUserAddress());
			dto1.setUserAge(user2.getUserAge());
			dto1.setUserDateOfBirth(user2.getUserDateOfBirth());
			dto1.setUserEmail(user2.getUserEmail());
			dto1.setUserGender(user2.getUserGender());
			dto1.setUserMobileNumber(user2.getUserMobileNumber());
			dto1.setUserName(user2.getUserName());
			dto1.setUserUserName(user2.getUserUserName());
			dto1.setUserPassword(user2.getUserPassword());
			dto1.setUserPhotoPath(user2.getUserPhotoPath());
			return dto1;
		}

	}

	@Override
	@Transactional
	public List<UserDto> getUserList() throws IPException {
		Iterable<User> list = userRepository.findAll();
		List<User> userList = new ArrayList<User>();
		for (User u : list)
			userList.add(u);

		List<UserDto> dtoList = userList.stream().map((User user) -> {
			UserDto dto = new UserDto();
			dto.setUserId(user.getUserId());
			dto.setUserAddress(user.getUserAddress());
			dto.setUserAge(user.getUserAge());
			dto.setUserDateOfBirth(user.getUserDateOfBirth());
			dto.setUserEmail(user.getUserEmail());
			dto.setUserGender(user.getUserGender());
			dto.setUserMobileNumber(user.getUserMobileNumber());
			dto.setUserName(user.getUserName());
			dto.setUserUserName(user.getUserUserName());
			dto.setUserPassword(user.getUserPassword());
			dto.setUserPhotoPath(user.getUserPhotoPath());
			return dto;
		}).collect(Collectors.toList());
		return null;
	}

//	@Transactional
//	public Cart addItemToCart(Long cartId, Long itemId) {
//		Cart cart = getCart(cartId);
//		Item item = itemService.getItem(itemId);
//		if (Objects.nonNull(item.getCart())) {
//			throw new ItemIsAlreadyAssignedException(itemId, item.getCart().getId());
//		}
//		cart.addItem(item);
//		item.setCart(cart);
//		return cart;
//	}

	@Override
	@Transactional
	public Policy addPolicyToUser(Integer userId, Integer policyId) throws IPException {
		Optional<User> user = userRepository.findById(userId);
		User user1=user.orElseThrow(()->new IPException("User is not available with this id: "+userId));
		
		PolicyDto policyDto = policyService.getPolicyById(policyId);
		

		Policy policy = new Policy();
		policy.setPolicyName(policyDto.getPolicyName());
		policy.setPolicyType(policyDto.getPolicyType());
		policy.setPolicyDuration(policyDto.getPolicyDuration());
		policy.setPolicyPremium(policyDto.getPolicyPremium());
		user1.addPolicies(policy);
		policy.setUser(user1);
		return policy;
	}

	@Override
	public User removePolicyFromUser(Integer userId, Integer policyId) throws IPException {
		User user = userRepository.findById(userId).get();
		PolicyDto policyDto = policyService.getPolicyById(policyId);
		
		Policy policy = new Policy();
		policy.setPolicyName(policyDto.getPolicyName());
		policy.setPolicyType(policyDto.getPolicyType());
		policy.setPolicyDuration(policyDto.getPolicyDuration());
		policy.setPolicyPremium(policyDto.getPolicyPremium());
		user.removePolicy(policy);

		return user;
	}
}
