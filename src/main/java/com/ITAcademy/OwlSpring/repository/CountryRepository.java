package com.ITAcademy.OwlSpring.repository;

import com.ITAcademy.OwlSpring.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, String> {

}
