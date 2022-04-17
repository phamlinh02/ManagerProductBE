package com.example.managerproduct.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends  WebSecurityConfigurerAdapter{

    private  final PasswordEncoder passwordEncoder;
    @Autowired
    public ApplicationSecurity(PasswordEncoder passwordEncoder) {

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable().httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

      UserDetails linh = User.builder()
        .username("linh")
        .password(passwordEncoder.encode("1234"))
              .roles("ADMIN")
        .build();

      return new InMemoryUserDetailsManager(
        linh
      );
    }
}
