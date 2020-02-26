package com.hackathongestamp2020.Backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentasRepository extends ReactiveMongoRepository<Ventas, String> {
/*
    @Query("{'ventas.region': ?0}")
    public List<Ventas> findByregion(String region);

    public List<Ventas> findBycountry(String country);

 */
}
