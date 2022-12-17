package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.Rate;

public interface RateRepository extends CrudRepository<Rate, Long>
{

}
