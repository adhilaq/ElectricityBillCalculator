package com.example.demo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Consumer;

public interface ConsumerRepository extends CrudRepository<Consumer, Long>
{

	Consumer findByEmail(String email);


}
