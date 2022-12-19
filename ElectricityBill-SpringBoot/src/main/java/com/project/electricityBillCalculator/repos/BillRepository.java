package com.project.electricityBillCalculator.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.electricityBillCalculator.entity.Bill;
import com.project.electricityBillCalculator.entity.Consumer;

public interface BillRepository extends CrudRepository<Bill, Long>
{

	@Query(value = "select * from consumer c inner join bill b on c.consumer_id=b.consumer_id where city=:city", nativeQuery = true)
	Iterable<Bill> findBillsByCity(String city);

	@Query(value = "select * from consumer c inner join bill b on c.consumer_id=b.consumer_id where area=:area", nativeQuery = true)
	Iterable<Bill> findBillsByArea(String area);

	@Query(value = "select * from consumer c inner join bill b on c.consumer_id=b.consumer_id where year=:year and month=:month",
			nativeQuery = true)
	Iterable<Bill> findBillsByYearAndMonth(int year, int month);

	@Query(value = "select * from consumer c inner join bill b on c.consumer_id=b.consumer_id where email=:email", nativeQuery = true)
	Iterable<Bill> findByConsumerEmail(String email);
	

}
