package com.company.composition.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "PRODUCT", indexes = {@Index(name = "IDX_PRODUCT_PRODUCT_CATEGORY", columnList = "PRODUCT_CATEGORY_ID")})
@Entity
public class Product
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "PRODUCT_CATEGORY_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ProductCategory productCategory;
    @Column(name = "VALID_FROM", nullable = false)
    @NotNull
    private LocalDate validFrom;
    @Column(name = "VALID_TO")
    private LocalDate validTo;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public LocalDate getValidTo() {return validTo;}

    public void setValidTo(LocalDate validTo) {this.validTo = validTo;}

    public LocalDate getValidFrom() {return validFrom;}

    public void setValidFrom(LocalDate validFrom) {this.validFrom = validFrom;}

    public ProductCategory getProductCategory() {return productCategory;}

    public void setProductCategory(ProductCategory productCategory) {this.productCategory = productCategory;}

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}
}