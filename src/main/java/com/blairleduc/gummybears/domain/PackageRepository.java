package com.blairleduc.gummybears.domain;

import reactor.core.publisher.Mono;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;

public interface PackageRepository extends ReactiveNeo4jRepository<PackageEntity, String> {
    Mono<PackageEntity> findOneByName(String name);
}