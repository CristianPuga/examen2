package com.hackathongestamp2020.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class RestVentas {

    @Autowired
    private VentasRepository ventasRepository;

    @GetMapping
    public Flux<Ventas> getAll(){
        return this.ventasRepository.findAll();
    }

    @PostMapping
    public Mono<ResponseEntity<Ventas>> postOne(@Valid @RequestBody Ventas ventas){
        return this.ventasRepository.save(ventas)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    Mono<Ventas> oneVenta(@PathVariable String id) {
        return ventasRepository.findById(id);
    }

/*
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Ventas>> getById(@PathVariable("id") String id){
        return this.ventasRepository.findById(id)
                .map(ventas -> new ResponseEntity<Ventas>(ventas, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
 */

/*
    @PutMapping("/{id}")
    Ventas replacePokemon(@Valid @RequestBody Ventas ventas, @PathVariable String id) {


        return repository.findById(id);
                .map(ventas1 -> {
                    ventas1.name=pokemon.name;
                    ventas1.type=pokemon.type;
                    return repository.save(ventas);
                })
                .orElseGet(() -> {
                    pokemon.id=id;
                    return repository.save(pokemon);
                });


    }

 */
  @DeleteMapping("/{id}")
       public Mono<ResponseEntity<Ventas>> deletePokemon (@PathVariable(value = "id") String id){

            return ventasRepository.findById(id)
                    .flatMap(ventas ->
                            ventasRepository.delete(ventas).then(Mono.just(new ResponseEntity<Ventas>(ventas, HttpStatus.OK)))
                                .defaultIfEmpty(new ResponseEntity<Ventas>(HttpStatus.NOT_FOUND)));
        }
}
