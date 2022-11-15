package com.comdata.auto.Repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.comdata.auto.model.Automobile;

@Repository
public interface AutoRepository extends PagingAndSortingRepository<Automobile, UUID> {

}
