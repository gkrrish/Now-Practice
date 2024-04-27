package com.now.entity;

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
@Table(name = "MASTER_TELANGANA_DISTRICTS")
public class MasterTelanganaDistricts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_id")
	private Integer districtId;

	@Column(name = "district_name")
	private String districtName;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private MasterStates state;
}
