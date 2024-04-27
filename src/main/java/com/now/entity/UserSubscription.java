package com.now.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "UX_USER_SUBSCRIPTION")
@AllArgsConstructor
@NoArgsConstructor
public class UserSubscription {

	@EmbeddedId
	private UserSubscriptionId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private UserDetails user;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("newspaperId")
	@JoinColumn(name = "newspaper_id")
	private VendorDynamicGeneric newspaper;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private MasterStatewiseTelanganaLocation location;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "batch_id")
	private MasterBatchJob batch;

	@Column(name = "user_eligible")
	private Integer userEligible;

}
