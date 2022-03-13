package com.example.airticketsorderservice.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "air_tickets_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "flight_no")
    private String flightNo;
    @Column(name = "flight_date")
    private Date flightDate;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "pay_type")
    private String payType;
    @Column(name = "amount")
    private double amount;
    @Column(name = "ticket_id")
    private int ticketId;
    @Column(name = "invoice_id")
    private int invoiceId;
    @Column(name = "luggage_id")
    private int luggageId;
    @Column(name = "original_order_id")
    private int originalOrderId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
}
