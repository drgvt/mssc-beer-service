package guru.springframework.msscbeerservice.web.mappers;

import guru.sfg.brewery.model.BeerDto;
import guru.springframework.msscbeerservice.domain.Beer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * Created by jt on 2019-05-25.
 */
@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    /**
     * преобразует сущность Beer из базы данных в DTO-объект BeerDto и
     * дополнительно запрашивает у внешнего сервиса инвентаризации
     * (BeerInventoryService) актуальное количество данного пива на складе,
     * записывая его в поле quantityOnHand
     */
    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
