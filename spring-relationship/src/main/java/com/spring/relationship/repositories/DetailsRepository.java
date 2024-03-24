package com.spring.relationship.repositories;

import com.spring.relationship.entities.Details;
import org.springframework.data.repository.CrudRepository;

public interface DetailsRepository extends CrudRepository<Details, Long> {
}
