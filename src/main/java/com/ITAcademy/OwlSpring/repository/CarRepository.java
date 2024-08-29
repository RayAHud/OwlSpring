package com.ITAcademy.OwlSpring.repository;

import com.ITAcademy.OwlSpring.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
