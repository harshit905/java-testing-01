package com.example;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/** spring-web (transitive of spring-boot-starter-web): stable RestTemplate / UriComponentsBuilder use. */
public final class Web {
    private static final RestTemplate REST = new RestTemplate();

    public static URI build(String base, String path) {
        return UriComponentsBuilder.fromHttpUrl(base).path(path).build().toUri();
    }

    public static String fetch(String base, String path) {
        return REST.getForObject(build(base, path), String.class);
    }
}
