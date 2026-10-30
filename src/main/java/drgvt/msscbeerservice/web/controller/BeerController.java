package drgvt.msscbeerservice.web.controller;/*
 Created by KonstantinAndrievski on 9/28/2026.
 */

import drgvt.msscbeerservice.services.BeerService;
import drgvt.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer/")
public class BeerController {

    private final BeerService beerService;
    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) throws ChangeSetPersister.NotFoundException {
        // todo impl
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Validated @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerID, @Validated @RequestBody BeerDto beerDto) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity<>(beerService.updateBeer(beerID, beerDto), HttpStatus.NO_CONTENT); // должно по идее быть только второе
    }
}
