package guru.springframework.msscbberservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.msscbberservice.domain.Beer;
import guru.springframework.msscbberservice.repositories.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner{

	private final BeerRepository beerReporistory;
	
	public BeerLoader(BeerRepository beerReporistory) {
		this.beerReporistory = beerReporistory;
	}
	
	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
	}
	
	private void loadBeerObjects() {
		if(beerReporistory.count() == 0) {
			beerReporistory.save(Beer.builder()
					.beerName("Lagunitas")
					.beerStyle("IPA")
					.quantityToBrew(200)
					.minOnHand(12)
					.upc(3370100001l)
					.price(new BigDecimal("10.99"))
					.build());
			
			beerReporistory.save(Beer.builder()
					.beerName("Shark Beer")
					.beerStyle("IPA")
					.quantityToBrew(200)
					.minOnHand(12)
					.upc(3370100002l)
					.price(new BigDecimal("10.99"))
					.build());
		}
	}

}
