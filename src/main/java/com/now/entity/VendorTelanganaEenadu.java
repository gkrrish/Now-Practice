package com.now.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "VENDOR_TELANGANA_EENADU")
public class VendorTelanganaEenadu {

    @Id
    @Column(name = "newspaper_id")
    private Integer newspaperId;

    @ManyToOne
    @JoinColumn(name = "mandal_id", referencedColumnName = "location_id")
    private MasterStatewiseTelanganaLocation mandal;

    @Column(name = "newspaper_name")
    private String newspaperName;

    @ManyToOne
    @JoinColumn(name = "newspaper_language")
    private MasterIndianNewspaperLanguage newspaperLanguage;

    @Column(name = "SubscriptionType")
    private String subscriptionType;

    @Column(name = "SubscriptionFee")
    private Double subscriptionFee;
}
