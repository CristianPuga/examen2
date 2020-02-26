package com.hackathongestamp2020.Backend.Controllers;

import com.hackathongestamp2020.Backend.Domain.Ventas;
import com.hackathongestamp2020.Backend.Repositories.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequestMapping("/ventas")
public class RestVentasController {

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

   /* @GetMapping("/{id}")
    Mono<Ventas> oneVenta(@PathVariable String id) {
        Mono<Ventas> prueba = ventasRepository.findById(id);
        System.out.println(prueba);
        return prueba;
    }*/


    @GetMapping("/{id}")
    public Mono<ResponseEntity<Ventas>> getById(@PathVariable("id") String id){
        Mono<ResponseEntity<Ventas>> prueba = this.ventasRepository.findById(id)
                .map(venta ->
                {
                    System.out.println(venta);
                    return new ResponseEntity<>(venta, HttpStatus.OK);
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
        System.out.println(prueba);
        return prueba;
    }


    @PutMapping("/{id}")
    public Mono<Ventas> updateVenta(@Valid @RequestBody Ventas ventas, @PathVariable String id){

        return ventasRepository.findById(id)
                .flatMap(ventas1 -> {
                    ventas1.id=ventas.id;
                    ventas1.order_id=ventas.order_id;
                    ventas1.region=ventas.region;
                    ventas1.country=ventas.country;
                    ventas1.item_type=ventas.item_type;
                    ventas1.sales_channel=ventas.order_priority;
                    ventas1.order_date=ventas.order_date;
                    ventas1.ship_date=ventas.ship_date;
                    ventas1.units_sold=ventas.units_sold;
                    ventas1.unit_price=ventas.unit_price;
                    ventas1.unit_cost=ventas.unit_cost;
                    ventas1.total_revenue=ventas.total_revenue;
                    ventas1.total_cost=ventas.total_cost;
                    ventas1.total_profit=ventas.total_profit;
                    System.out.println(ventas);
                    return ventasRepository.save(ventas);
                });
    }


  @DeleteMapping("/{id}")
       public Mono<ResponseEntity<Ventas>> deleteVenta (@PathVariable(value = "id") String id){

            return ventasRepository.findById(id)
                    .flatMap(ventas ->
                            ventasRepository.delete(ventas).then(Mono.just(new ResponseEntity<Ventas>(ventas, HttpStatus.OK)))
                                .defaultIfEmpty(new ResponseEntity<Ventas>(HttpStatus.NOT_FOUND)));
        }


}
