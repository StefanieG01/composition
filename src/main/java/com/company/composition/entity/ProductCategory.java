package com.company.composition.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "PRODUCT_CATEGORY", indexes = {@Index(name = "IDX_PRODUCT_CATEGORY_CATEGORY_TYPE", columnList = "CATEGORY_TYPE_ID")})
@Entity
public class ProductCategory
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @NotNull
    @JoinColumn(name = "CATEGORY_TYPE_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CategoryType categoryType;
    @NotNull
    @InstanceName
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "VALID_FROM", nullable = false)
    @NotNull
    private LocalDate validFrom;
    @Column(name = "VALID_TO")
    private LocalDate validTo;

    public CategoryType getCategoryType() {return categoryType;}

    public void setCategoryType(CategoryType categoryType) {this.categoryType = categoryType;}

    public LocalDate getValidTo() {return validTo;}

    public void setValidTo(LocalDate validTo) {this.validTo = validTo;}

    public LocalDate getValidFrom() {return validFrom;}

    public void setValidFrom(LocalDate validFrom) {this.validFrom = validFrom;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}
}