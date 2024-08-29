package com.ITAcademy.OwlSpring.repository;

import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Long> {
    //todo findByName method
    //todo findById method

}
