package com.cognizant.api_gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class LogFilterConfig {
    private final Logger logger = LoggerFactory.getLogger(LogFilterConfig.class);

    @Bean
    public GlobalFilter logFilter() {
        return (exchange, chain) -> {
            logger.info("Incoming request: " + exchange.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("Outgoing response status: " + exchange.getResponse().getStatusCode());
            }));
        };
    }
}
