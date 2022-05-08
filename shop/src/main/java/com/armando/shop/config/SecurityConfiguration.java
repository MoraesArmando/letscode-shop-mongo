package com.armando.shop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@RequiredArgsConstructor
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
public class SecurityConfiguration {
//    private final MongoUserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests().anyRequest().authenticated()
//                .and().httpBasic()
//                .and().sessionManagement().disable();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(userDetailsService);
//    }
}
