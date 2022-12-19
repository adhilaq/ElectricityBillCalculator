package com.project.electricityBillCalculator.repos;

import org.springframework.data.repository.CrudRepository;

import com.project.electricityBillCalculator.entity.Rate;

public interface RateRepository extends CrudRepository<Rate, Long>
{

}
