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
@Table(name = "MASTER_TELANGANA_MANDALS")
public class MasterTelanganaMandals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mandal_id")
	private Integer mandalId;

	@Column(name = "mandal_name")
	private String mandalName;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private MasterTelanganaDistricts district;
}
