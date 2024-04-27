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
@Table(name = "VENDOR_DYNAMIC_GENERIC")
public class VendorDynamicGeneric {

    @Id
    @Column(name = "dynamic_id")
    private Integer dynamicId;

    @Column(name = "telangana_eenadu_id", nullable = false)
    private Integer telanganaEenaduId;

    @ManyToOne
    @JoinColumn(name = "telangana_eenadu_id", referencedColumnName = "newspaper_id", insertable = false, updatable = false)
    private VendorTelanganaEenadu telanganaEenadu;
}
