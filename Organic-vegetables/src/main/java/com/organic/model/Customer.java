package com.organic.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String customerName;
	
	private String mobileNumber;
	
	private String emailId;
	
	private String password;
	
	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	private BillingDetails billingDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Order order;

}
