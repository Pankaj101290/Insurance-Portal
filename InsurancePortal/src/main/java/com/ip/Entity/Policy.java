package com.ip.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "policyId")
	private Integer policyId;
	private String policyName;
	private String policyType;
	private String policyDuration;
	private Double policyPremium;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

}
