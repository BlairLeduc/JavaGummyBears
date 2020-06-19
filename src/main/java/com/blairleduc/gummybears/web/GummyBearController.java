package com.blairleduc.gummybears.web;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.blairleduc.gummybears.domain.GummyBearEntity;
import com.blairleduc.gummybears.domain.GummyBearRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gummybears")
public class GummyBearController {
    private final GummyBearRepository gummyBearRepository;

    public GummyBearController(GummyBearRepository GummyBearRepository) {
        this.gummyBearRepository = GummyBearRepository;
    }

    @PutMapping
    Mono<GummyBearEntity> createOrUpdateGummyBear(@RequestBody GummyBearEntity newGummyBear) {
        return gummyBearRepository.save(newGummyBear);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<GummyBearEntity> getGummyBears() {
        Flux<GummyBearEntity> results = gummyBearRepository.findAll();
        return results;
    }

    @GetMapping("/by-name")
    Mono<GummyBearEntity> byName(@RequestParam String name) {
        Mono<GummyBearEntity> result = gummyBearRepository.findOneByName(name);
        return result;
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable String id) {
        return gummyBearRepository.deleteById(id);
    }

}