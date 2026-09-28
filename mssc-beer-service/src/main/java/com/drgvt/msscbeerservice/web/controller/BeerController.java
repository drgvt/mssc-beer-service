package com.drgvt.msscbeerservice.web.controller;/*
 Created by KonstantinAndrievski on 9/28/2026.
 */

import com.drgvt.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) {
        // todo impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(BeerDto beerDto) {
        // todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerID) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
