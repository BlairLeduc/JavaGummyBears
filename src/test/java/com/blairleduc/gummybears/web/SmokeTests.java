package com.blairleduc.gummybears.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTests {
    
    @Autowired
    private PackageController packageController;

    @Autowired
    private GummyBearController gummyBearController;

    @Test
    public void packageController_contentLoads() throws Exception {
        assertThat(packageController)
            .isNotNull();
    }

    @Test
    public void gummyBearController_contentLoads() throws Exception {
        assertThat(gummyBearController)
            .isNotNull();
    }
}