package com.company.composition.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CUSTOMER")
@Entity
public class Customer
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @Composition
    @OrderBy("validFrom DESC")
    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> orders;
    @InstanceName
    @Column(name = "NAME")
    private String name;
    @NotNull
    @Column(name = "VALID_FROM", nullable = false)
    private LocalDate validFrom;
    @Column(name = "VALID_TO")
    private LocalDate validTo;

    public List<CustomerOrder> getOrders() {return orders;}

    public void setOrders(List<CustomerOrder> orders) {this.orders = orders;}

    public LocalDate getValidTo() {return validTo;}

    public void setValidTo(LocalDate validTo) {this.validTo = validTo;}

    public LocalDate getValidFrom() {return validFrom;}

    public void setValidFrom(LocalDate validFrom) {this.validFrom = validFrom;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}
}