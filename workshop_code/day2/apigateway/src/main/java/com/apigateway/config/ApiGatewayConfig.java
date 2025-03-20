package com.apigateway.config;

import java.time.LocalDateTime;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	@Bean
    public RouteLocator busycoderRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/productstore/productsms/**")
                        .filters( f -> f.rewritePath("/productstore/productsms/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://PRODUCTS"))
                .route(p -> p
                        .path("/productstore/couponsms/**")
                        .filters( f -> f.rewritePath("/productstore/couponsms/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://COUPONS"))
               .build();
    }
}
/*
 * 		http://localhost:8082/products
 * 		http://localhost:8082/productstore/productsms/products
 * 		http://localhost:8084/coupons/SUP10
 * 		http://localhost:8072/productstore/couponsms/coupons/SUP10
 */

