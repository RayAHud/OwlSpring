//package com.ITAcademy.OwlSpring;
//
//
//import com.ITAcademy.OwlSpring.UserDetailsService.JpaUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//    private final JpaUserDetailsService myUserDetailsService;
//    public SecurityConfig(JpaUserDetailsService myUserDetailsService) {
//        this.myUserDetailsService = myUserDetailsService;
//    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
////                .csrf(csrf -> csrf.ignoringAntMatchers("/h2-ui/**"))
//                .csrf().disable()
//                .authorizeRequests(auth -> auth
//                        .antMatchers("/h2-ui/**").permitAll()
////                        .mvcMatchers("/api/**").permitAll()
////                        .antMatchers(HttpMethod.POST, "/api/manufacturers/**").hasAnyRole("USER", "ADMIN")
////                        .antMatchers("/api/manufacturers/**").hasAnyRole("ADMIN")
//                        .anyRequest().authenticated()
//                                .anyRequest().permitAll()
//                )
//                .userDetailsService(myUserDetailsService)
//                .headers(headers -> headers.frameOptions().sameOrigin())
//                .httpBasic(withDefaults())
//                .build();
//    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
