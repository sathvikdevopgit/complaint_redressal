package com.abctelecom.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.abctelecom.dto.CustomerDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table

public class Customer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "customer_service",joinColumns = @JoinColumn(name="customer_id"))
//	@Enumerated(EnumType.STRING)
	private Set<String> serviceType;
	
	
//	@OneToMany(mappedBy = "customer")
//	private Set<Ticket> tickets;
	
	@Column
	private String address;
	
	@Column
	private String zipcode;
	
	
	
	public Customer(CustomerDto customerDto) {
		
		this.user = customerDto.getUser();
		this.serviceType = customerDto.getServiceType();
		this.address = customerDto.getAddress();
		this.zipcode = customerDto.getZipcode();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



}
