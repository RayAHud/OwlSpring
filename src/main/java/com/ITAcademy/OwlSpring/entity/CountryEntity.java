package com.ITAcademy.OwlSpring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryId;
    private String countryName;
//    @JsonIgnore
//    @OneToMany(mappedBy = "countryEntity")
//    private Set<CatalogModelEntity> catalogModels = new HashSet<>();

    public CountryEntity(String countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }
}
