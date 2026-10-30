package drgvt.msscbeerservice.services;
/*
 Created by KonstantinAndrievski on 10/30/2026.
 */

import drgvt.msscbeerservice.web.model.BeerDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId) throws ChangeSetPersister.NotFoundException;

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerID, BeerDto beerDto) throws ChangeSetPersister.NotFoundException;
}
