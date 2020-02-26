package com.hackathongestamp2020.Backend.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "ventas2")
public class Ventas {

    @Id
    @Field("_id")
    public String id;

    @Field("Region")
    public String region;

    @Field("Country")
    public String country;

    @Field("Item Type")
    public String item_type;

    @Field("Sales Channel")
    public String sales_channel;

    @Field("Order Priority")
    public String order_priority;

    @Field("Order Date")
    public String order_date;

    @Field("Order ID")
    public String order_id;

    @Field("Ship Date")
    public String ship_date;

    @Field("Units Sold")
    public String units_sold;

    @Field("Unit Price")
    public String unit_price;

    @Field("Unit Cost")
    public String unit_cost;

    @Field("Total Revenue")
    public String total_revenue;

    @Field("Total Cost")
    public String total_cost;

    @Field("Total Profit")
    public String total_profit;

}
