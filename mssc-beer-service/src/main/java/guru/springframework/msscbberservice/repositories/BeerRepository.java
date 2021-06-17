package guru.springframework.msscbberservice.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import guru.springframework.msscbberservice.domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
