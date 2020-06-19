package com.blairleduc.gummybears.domain;

import reactor.core.publisher.Mono;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;

public interface GummyBearRepository extends ReactiveNeo4jRepository<GummyBearEntity, String> {
    Mono<GummyBearEntity> findOneByName(String name);
}