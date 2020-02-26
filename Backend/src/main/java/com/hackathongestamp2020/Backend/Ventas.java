package com.hackathongestamp2020.Backend;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "ventas")
public class Ventas {

    /*
    public String id;
    public String nombre;
    public String edad;
    public String email;
*/
    @Id
    public String order_id;

    public String region;
    public String country;
    public String item_type;
    public String sales_channel;
    public String order_priority;
    public String order_date;


    public String ship_date;
    public String units_sold;
    public String unit_price;
    public String unit_cost;
    public String total_revenue;
    public String total_cost;
    public String total_profit;

/*
    public Ventas(
            final String region,
            final String country,
            final String item_type,
            final String sales_channel,
            final String order_priority,
            final Date order_date,
            final Integer order_id,
            final String ship_date,
            final Integer units_sold,
            final String unit_price,
            final String unit_cost,
            final String total_revenue,
            final String total_cost,
            final String total_profit ){
        this.region = region;
        this.country = country;
        this.item_type = item_type;
        this.sales_channel = sales_channel;
        this.order_priority = order_priority;
        this.order_date = order_date;
        this.order_id = order_id;
        this.ship_date = ship_date;
        this.units_sold = units_sold;
        this.unit_price = unit_price;
        this.unit_cost = unit_cost;
        this.total_revenue = total_revenue;
        this.total_cost = total_cost;
        this.total_profit = total_profit;
    }*/
}
