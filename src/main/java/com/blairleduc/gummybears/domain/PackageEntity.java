package com.blairleduc.gummybears.domain;


import static org.neo4j.springframework.data.core.schema.Relationship.Direction.*;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;

@Node("Package")
public class PackageEntity {
    @Id
    private final String name;

    private final Integer mass;

    @Relationship(type = "PACKAGED_IN", direction = INCOMING)
    private Map<GummyBearEntity, Contents> bearsAndContents = new HashMap<>();

    public PackageEntity(String name, Integer mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public Integer getMass() {
        return mass;
    }

    public Map<GummyBearEntity, Contents> getBearsAndContents() {
        return bearsAndContents;
    }
}