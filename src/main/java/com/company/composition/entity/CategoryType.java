package com.company.composition.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "CATEGORY_TYPE")
@Entity
public class CategoryType
{
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @InstanceName
    @Column(name = "TYPE_NAME", nullable = false)
    @NotNull
    private String typeName;
    @Column(name = "VALID_FROM", nullable = false)
    @NotNull
    private LocalDate validFrom;
    @Column(name = "VALID_TO")
    private LocalDate validTo;

    public LocalDate getValidTo() {return validTo;}

    public void setValidTo(LocalDate validTo) {this.validTo = validTo;}

    public LocalDate getValidFrom() {return validFrom;}

    public void setValidFrom(LocalDate validFrom) {this.validFrom = validFrom;}

    public String getTypeName() {return typeName;}

    public void setTypeName(String typeName) {this.typeName = typeName;}

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    @DependsOnProperties({"typeName"})
    public String getInstanceName(MetadataTools metadataTools)
    {
        return metadataTools.format(typeName);
    }
}