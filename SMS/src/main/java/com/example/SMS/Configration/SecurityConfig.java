
package com.example.SMS.Configration;

import com.example.SMS.Service.CustemUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless JWT
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/dept/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/user/createUser")
                        .permitAll()// Allow all
                        .requestMatchers("/user/**").authenticated()  // Require auth
                        .anyRequest().permitAll()
                );
        http.formLogin(form->form.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){


//        UserDetails user= User
//                .withUsername("Santhosh")
//                .password(passwordEncoder.encode("Sandy123"))
//                .roles("USER")
//                .build();
//        UserDetails admin= User
//                .withUsername("Prakash")
//                .password(passwordEncoder.encode("prakash123"))
//                .roles("ADMIN")
//                .build();
        return new CustemUserDetailService();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService,
                                                               PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider daoAuthenticate= new DaoAuthenticationProvider();
        daoAuthenticate.setUserDetailsService(userDetailsService);
        daoAuthenticate.setPasswordEncoder(passwordEncoder);

        return daoAuthenticate;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

