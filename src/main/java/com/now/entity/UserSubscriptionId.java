package com.now.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserSubscriptionId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "newspaper_id")
	private Integer newspaperId;

	@Column(name = "location_id")
	private Integer locationId;

}
