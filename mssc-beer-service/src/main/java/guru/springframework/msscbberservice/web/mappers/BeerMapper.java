package guru.springframework.msscbberservice.web.mappers;

import org.mapstruct.Mapper;

import guru.springframework.msscbberservice.domain.Beer;
import guru.springframework.msscbberservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	BeerDto BeerToBeerDto(Beer beer);
	
	Beer BeerDtoToBeer(BeerDto beerDto);
}
