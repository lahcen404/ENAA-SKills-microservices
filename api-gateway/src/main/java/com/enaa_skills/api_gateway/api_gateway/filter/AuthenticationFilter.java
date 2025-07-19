package com.enaa_skills.api_gateway.api_gateway.filter;

import com.enaa_skills.api_gateway.api_gateway.util.JwtUtil;
import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

@Autowired
    private RouteValidator validator; //know which routes public
@Autowired
    private JwtUtil jwtUtil; // token validate

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return ((exchange, chain) -> {

            // check if the route is a private one
            if (validator.isSecured.test(exchange.getRequest())) {

                // check if the request has the Authorization header
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Missing authorization header");
                }

                // get full header
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                // get token without "Bearer "
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }

                try {
                    // check token if valid
                    jwtUtil.validateToken(authHeader);
                } catch (Exception e) {
                    // if fake , stop it
                    throw new RuntimeException("Unauthorized access to application");
                }
            }

            // if area public or valid gateway continue
            return chain.filter(exchange);
        });
    }

    public static class Config {
        // configuration, but we don't need it for this filter.
    }
}
