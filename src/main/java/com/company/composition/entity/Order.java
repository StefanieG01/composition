package com.company.composition.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "ORDER_", indexes = {@Index(name = "IDX_ORDER__ORDER_PRODUCT", columnList = "ORDER_PRODUCT_ID")})
@Entity(name = "Order_")
public class Order
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @NotNull
    @InstanceName
    @Column(name = "NUMBER_", nullable = false)
    private String number;
    @NotNull
    @JoinColumn(name = "ORDER_PRODUCT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OrderProduct orderProduct;
    @NotNull
    @Column(name = "VALID_FROM", nullable = false)
    private LocalDate validFrom;
    @Column(name = "VALID_TO")
    private LocalDate validTo;

    public OrderProduct getOrderProduct() {return orderProduct;}

    public void setOrderProduct(OrderProduct orderProduct) {this.orderProduct = orderProduct;}

    public void setValidTo(LocalDate validTo) {this.validTo = validTo;}

    public LocalDate getValidTo() {return validTo;}

    public void setValidFrom(LocalDate validFrom) {this.validFrom = validFrom;}

    public LocalDate getValidFrom() {return validFrom;}

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}
}