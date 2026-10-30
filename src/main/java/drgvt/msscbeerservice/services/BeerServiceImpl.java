package drgvt.msscbeerservice.services;

import drgvt.msscbeerservice.domain.Beer;
import drgvt.msscbeerservice.respositories.BeerRepository;
import drgvt.msscbeerservice.web.mappers.BeerMapper;
import drgvt.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/*
 Created by KonstantinAndrievski on 10/30/2026.
 */

@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    BeerMapper beerMapper;
    BeerRepository beerRepository;
    @Override
    public BeerDto getById(UUID beerId) throws ChangeSetPersister.NotFoundException {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));

    }

    @Override
    public BeerDto updateBeer(UUID beerID, BeerDto beerDto) throws ChangeSetPersister.NotFoundException {
        Beer beer = beerRepository.findById(beerID).orElseThrow(ChangeSetPersister.NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name()); // т.к. в Dto Enum для стилей
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
