package com.blairleduc.gummybears.web;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.blairleduc.gummybears.domain.PackageEntity;
import com.blairleduc.gummybears.domain.PackageRepository;
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
@RequestMapping("/packages")
public class PackageController {
    private final PackageRepository packageRepository;

    public PackageController(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @PutMapping
    Mono<PackageEntity> createOrUpdatePackage(@RequestBody PackageEntity newPackage) {
        return packageRepository.save(newPackage);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<PackageEntity> getPackages() {
        return packageRepository.findAll();
    }

    @GetMapping("/by-name")
    Mono<PackageEntity> byName(@RequestParam String name) {
        return packageRepository.findOneByName(name);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable String id) {
        return packageRepository.deleteById(id);
    }

}