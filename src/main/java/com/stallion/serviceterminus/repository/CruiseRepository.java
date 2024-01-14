package com.stallion.serviceterminus.repository;

import com.stallion.serviceterminus.model.entity.Cruise;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseRepository extends ReactiveMongoRepository<Cruise, String> {
}