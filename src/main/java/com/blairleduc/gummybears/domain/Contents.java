package com.blairleduc.gummybears.domain;

import java.util.List;

import org.neo4j.springframework.data.core.schema.RelationshipProperties;

@RelationshipProperties
public class Contents {
    private final List<String> contents;

    public Contents(List<String> contents) {
        this.contents = contents;
    }

    public List<String> getContents() {
        return contents;
    }
}