package com.company.composition.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;

@JmixEntity
@Embeddable
public class CustomerOrderCompKey
{
    @Column(name = "CUSTOMER", nullable = false)
    @NotNull
    private UUID customer;

    @Column(name = "ORDER", nullable = false)
    @NotNull
    private UUID order;

    public UUID getOrder()
    {
        return order;
    }

    public void setOrder(UUID order)
    {
        this.order = order;
    }

    public UUID getCustomer() {return customer;}

    public void setCustomer(UUID customer) {this.customer = customer;}

    @Override
    public int hashCode()
    {
        return Objects.hash(customer, order);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        CustomerOrderCompKey entity = (CustomerOrderCompKey) o;
        return Objects.equals(this.customer, entity.customer) && Objects.equals(this.order, entity.order);
    }
}