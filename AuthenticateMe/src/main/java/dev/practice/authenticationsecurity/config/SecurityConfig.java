
package dev.practice.authenticationsecurity.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;







@Configuration
@EnableWebSecurity
public class SecurityConfig {
    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
                .csrf(csrf -> csrf.disable())  //disable for testing purposes
                .authorizeHttpRequests(auth -> auth 
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                
                )
                
                .formLogin(form -> form
                .defaultSuccessUrl("/hi", true) //redirect here after login
                .permitAll())  
                
                .logout(Customizer.withDefaults());
                        
                        
               
        return http.build();
    }
    
    
    
}
