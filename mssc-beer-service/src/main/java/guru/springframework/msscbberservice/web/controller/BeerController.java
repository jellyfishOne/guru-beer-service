package guru.springframework.msscbberservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbberservice.repositories.BeerRepository;
import guru.springframework.msscbberservice.web.mappers.BeerMapper;
import guru.springframework.msscbberservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	private final BeerMapper beerMapper;
    private final BeerRepository beerRepository;

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
		
		 return new ResponseEntity<>(beerMapper.BeerToBeerDto(beerRepository.findById(beerId).get()), HttpStatus.OK);
		
	}
	
	@PostMapping()
	public ResponseEntity saveNewBeer(@Validated @RequestBody BeerDto beerDto) {
		beerRepository.save(beerMapper.BeerDtoToBeer(beerDto));

        return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDto beerDto) {
		  beerRepository.findById(beerId).ifPresent(beer -> {
	            beer.setBeerName(beerDto.getBeerName());
	            beer.setBeerStyle(beerDto.getBeerStyle().name());
	            beer.setPrice(beerDto.getPrice());
	            beer.setUpc(beerDto.getUpc());

	            beerRepository.save(beer);
	        });

	        return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
