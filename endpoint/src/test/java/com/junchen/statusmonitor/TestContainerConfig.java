package com.junchen.statusmonitor;

import org.junit.jupiter.api.AfterAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

public abstract  class TestContainerConfig {

    private static final DockerImageName postgresImageName = DockerImageName.parse("postgres:16-bullseye");

    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(postgresImageName);

    @AfterAll
    static void afterAllBase() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        Startables.deepStart(postgres).join();
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
}
