package com.drgvt.msscbeerservice.respositories;

/*
 Created by KonstantinAndrievski on 10/18/2026.
 */

import com.drgvt.msscbeerservice.domain.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends
        PagingAndSortingRepository<Beer, UUID>,
        CrudRepository<Beer, UUID> {
}

