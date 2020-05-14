package com.example.sampleprocessor;

import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SampleProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleProcessorApplication.class, args);
    }

    @Bean
    public Function<Flux<String>, Flux<String>> process() {
        return stringFlux -> stringFlux.map(s -> s.toUpperCase())
            .log();
    }

}
