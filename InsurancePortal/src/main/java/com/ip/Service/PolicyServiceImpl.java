package com.ip.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.DTO.PolicyDto;
import com.ip.Entity.Policy;
import com.ip.Exception.IPException;
import com.ip.Repository.PolicyRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	public PolicyDto addPolicy(PolicyDto dto) throws IPException {
		Policy name = policyRepository.findByPolicyName(dto.getPolicyName());
		if (name != null)
			throw new IPException("Policy details already entered with policy name: " + dto.getPolicyName());
		else {
			Policy p = new Policy();
			p.setPolicyName(dto.getPolicyName());
			p.setPolicyType(dto.getPolicyType());
			p.setPolicyDuration(dto.getPolicyDuration());
			p.setPolicyPremium(dto.getPolicyPremium());
			Policy p1 = policyRepository.save(p);

			PolicyDto dto2 = new PolicyDto();
			dto2.setPolicyId(p1.getPolicyId());
			dto2.setPolicyName(p1.getPolicyName());
			dto2.setPolicyType(p1.getPolicyType());
			dto2.setPolicyDuration(p1.getPolicyDuration());
			dto2.setPolicyPremium(p1.getPolicyPremium());
			return dto2;
		}

	}

	public PolicyDto getPolicyById(Integer id) throws IPException {
		Optional<Policy> findById = policyRepository.findById(id);
		Policy p = findById.orElseThrow(() -> new IPException("Policy not found for Id: " + id));

		PolicyDto dto2 = new PolicyDto();
		dto2.setPolicyId(p.getPolicyId());
		dto2.setPolicyName(p.getPolicyName());
		dto2.setPolicyType(p.getPolicyType());
		dto2.setPolicyDuration(p.getPolicyDuration());
		dto2.setPolicyPremium(p.getPolicyPremium());
		return dto2;

	}

	public void deleteById(Integer Id) throws IPException {
		Optional<Policy> findById = policyRepository.findById(Id);
		Policy p = findById.orElseThrow(() -> new IPException("Policy not found for Id: " + Id));
		policyRepository.delete(p);
	}

	@Override
	public void deleteAll() {
		policyRepository.deleteAll();
	}

	@Override
	public PolicyDto updatePolicy(PolicyDto dto) throws IPException {
		Policy policy = policyRepository.findByPolicyName(dto.getPolicyName());
		if (policy != null)
			throw new IPException("Policy doesnot exist with policy name: " + dto.getPolicyName());
		else {
			Policy p = new Policy();
			p.setPolicyName(dto.getPolicyName());
			p.setPolicyType(dto.getPolicyType());
			p.setPolicyDuration(dto.getPolicyDuration());
			p.setPolicyPremium(dto.getPolicyPremium());
			Policy p1 = policyRepository.save(p);

			PolicyDto dto2 = new PolicyDto();
			dto2.setPolicyId(p1.getPolicyId());
			dto2.setPolicyName(p1.getPolicyName());
			dto2.setPolicyType(p1.getPolicyType());
			dto2.setPolicyDuration(p1.getPolicyDuration());
			dto2.setPolicyPremium(p1.getPolicyPremium());
			return dto2;
		}
	}

	@Override
	public List<PolicyDto> findAllPolicy() throws IPException {
		Iterable<Policy> policy = policyRepository.findAll();
		List<Policy> list = new ArrayList<Policy>();
		for (Policy p : policy) {
			list.add(p);
		}

		List<PolicyDto> dto = list.stream().map((Policy p1) -> {
			PolicyDto dto2 = new PolicyDto();
			dto2.setPolicyId(p1.getPolicyId());
			dto2.setPolicyName(p1.getPolicyName());
			dto2.setPolicyType(p1.getPolicyType());
			dto2.setPolicyDuration(p1.getPolicyDuration());
			dto2.setPolicyPremium(p1.getPolicyPremium());
			return dto2;

		}).collect(Collectors.toList());
		return dto;
	}

	@Override
	public List<PolicyDto> findAllPolicyByType(String type) throws IPException {
		List<Policy> list = policyRepository.findByPolicyType(type);

		List<PolicyDto> dto = list.stream().map((Policy p1) -> {
			PolicyDto dto2 = new PolicyDto();
			dto2.setPolicyId(p1.getPolicyId());
			dto2.setPolicyName(p1.getPolicyName());
			dto2.setPolicyType(p1.getPolicyType());
			dto2.setPolicyDuration(p1.getPolicyDuration());
			dto2.setPolicyPremium(p1.getPolicyPremium());
			return dto2;

		}).collect(Collectors.toList());
		return dto;
	}

}
