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
@Table(name = "MASTER_STATEWISE_TELANGANA_LOCATIONS")
public class MasterStatewiseTelanganaLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "location_name")
    private String locationName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private MasterCountries country;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private MasterStates state;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private MasterTelanganaDistricts district;

    @ManyToOne
    @JoinColumn(name = "mandal_id")
    private MasterTelanganaMandals mandal;
}
