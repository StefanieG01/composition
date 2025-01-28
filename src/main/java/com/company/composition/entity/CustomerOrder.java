package com.company.composition.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@JmixEntity
@Table(name = "CUSTOMER_ORDER", indexes = {@Index(name = "IDX_CUSTOMER_ORDER_ORDER", columnList = "ORDER_ID"), @Index(name = "IDX_CUSTOMER_ORDER_CUSTOMER", columnList = "CUSTOMER_ID")})
@Entity
public class CustomerOrder
{
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "order", column = @Column(name = "ORDER_ID")),
            @AttributeOverride(name = "customer", column = @Column(name = "CUSTOMER_ID"))})
    private CustomerOrderCompKey id;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "ORDER_ID")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    private Order order;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    private Customer customer;

    @NotNull
    @Column(name = "VALID_FROM", nullable = false)
    private LocalDate validFrom;
    @Column(name = "VALID_TO")
    private LocalDate validTo;

    @InstanceName
    @DependsOnProperties({"customer", "order"})
    public String getDisplayName()
    {
        return String.format("%s - %s", customer.getName(),
                order.getNumber());
    }

    public LocalDate getValidTo() {return validTo;}

    public void setValidTo(LocalDate validTo) {this.validTo = validTo;}

    public LocalDate getValidFrom() {return validFrom;}

    public void setValidFrom(LocalDate validFrom) {this.validFrom = validFrom;}

    public Customer getCustomer() {return customer;}

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
        this.id.setCustomer(customer == null ? null : customer.getId());
    }

    public Order getOrder() {return order;}

    public void setOrder(Order order)
    {
        this.order = order;
        this.id.setOrder(order == null ? null : order.getId());
    }

    public CustomerOrderCompKey getId() {return id;}

    public void setId(CustomerOrderCompKey id) {this.id = id;}
}