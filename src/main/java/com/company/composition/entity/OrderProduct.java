package com.company.composition.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "ORDER_PRODUCT", indexes = {@Index(name = "IDX_ORDER_PRODUCT_ORDER", columnList = "ORDER_ID"), @Index(name = "IDX_ORDER_PRODUCT_PRODUCT", columnList = "PRODUCT_ID")})
@Entity
public class OrderProduct
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @JoinColumn(name = "ORDER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @Column(name = "VALID_FROM", nullable = false)
    @NotNull
    private LocalDate validFrom;
    @Column(name = "VALID_TO")
    private LocalDate validTo;

    public LocalDate getValidTo() {return validTo;}

    public void setValidTo(LocalDate validTo) {this.validTo = validTo;}

    public LocalDate getValidFrom() {return validFrom;}

    public void setValidFrom(LocalDate validFrom) {this.validFrom = validFrom;}

    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}

    public Order getOrder() {return order;}

    public void setOrder(Order order) {this.order = order;}

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    @InstanceName
    @DependsOnProperties({"product", "order"})
    public String getInstanceName(MetadataTools metadataTools)
    {
        return String.format("%s - %s", metadataTools.format(product), metadataTools.format(order));
    }
}