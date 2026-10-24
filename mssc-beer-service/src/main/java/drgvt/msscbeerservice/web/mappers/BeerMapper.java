package drgvt.msscbeerservice.web.mappers;/*
 Created by KonstantinAndrievski on 10/24/2026.
 */

import drgvt.msscbeerservice.domain.Beer;
import drgvt.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDto (Beer beer);
}

