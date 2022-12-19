package com.project.electricityBillCalculator.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.electricityBillCalculator.entity.Bill;
import com.project.electricityBillCalculator.entity.Consumer;

public interface ConsumerRepository extends CrudRepository<Consumer, Long>
{

	Consumer findByEmail(String email);


}
