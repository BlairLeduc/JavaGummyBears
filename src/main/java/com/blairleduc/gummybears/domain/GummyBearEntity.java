package com.blairleduc.gummybears.domain;

import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;

@Node("GummyBear")
public class GummyBearEntity {
    @Id
    private final String name;

    private final String colour;
    
    private final String flavour;

    public GummyBearEntity(String name, String colour, String flavour) {
        this.name = name;
        this.colour = colour;
        this.flavour = flavour;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public String getFlavour() {
        return flavour;
    }
}