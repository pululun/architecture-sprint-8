package org.example.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return httpSecurity
                .authorizeHttpRequests(custom -> custom.requestMatchers("/error").permitAll()
                        .requestMatchers("/reports").hasRole("prothetic_user")
                        .anyRequest().authenticated())
                .build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        converter.setPrincipalClaimName("preferred_username");
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Collection<GrantedAuthority> grantedAuthorities = jwtGrantedAuthoritiesConverter.convert(jwt);
            List<String> roles = (List<String>) jwt.getClaimAsMap("realm_access").get("roles");
            return Stream.concat(grantedAuthorities.stream(), roles.stream()
                            .filter(role -> role.startsWith("prothetic_"))
                            .map(SimpleGrantedAuthority::new)
                            .map(GrantedAuthority.class::cast))
                    .toList();
        });
        return converter;
    }

}
