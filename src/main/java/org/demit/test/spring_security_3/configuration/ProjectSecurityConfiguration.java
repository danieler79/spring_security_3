package org.demit.test.spring_security_3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//        // security filter permitting all.
//        http.authorizeHttpRequests((request)-> request.anyRequest().permitAll());
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();

//        // security filter denying all.
//        http.authorizeHttpRequests((request) -> request.anyRequest().denyAll());
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();

        // custom security filter config.
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/myAccount","myBalance","myLoans","myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
