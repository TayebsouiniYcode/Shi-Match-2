package com.youcode.shimatch.security;

import com.youcode.shimatch.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAutFilter;
    private final UserService userService;

    public SecurityConfig(JwtAuthFilter jwtAutFilter, UserService userService) {
        this.jwtAutFilter = jwtAutFilter;
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
        http
                .csrf ().disable ()
                .cors().disable()
                .authorizeRequests()
                .anyRequest ()
                .permitAll ()
                .and ()
                .sessionManagement (  )
                .sessionCreationPolicy ( SessionCreationPolicy.STATELESS )
                .and ()
                .authenticationProvider ( authenticationProvider() )
                .addFilterBefore ( jwtAutFilter, UsernamePasswordAuthenticationFilter.class );
        return http.build ();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config ) throws Exception {
        return config.getAuthenticationManager ();
    }

    @Bean
    public PasswordEncoder passwordEncoder ( ) {
        return NoOpPasswordEncoder.getInstance ();
        //return new BCryptPasswordEncoder (  );
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService( ) {
            @Override
            public UserDetails loadUserByUsername (String email ) throws UsernameNotFoundException {
                return userService.loadUserByUsername(email);
            }
        };
    }
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
    */
    /*
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration (  );
        configuration.setAllowedOrigins ( Arrays.asList ( "http://localhost:4200" ) );
        configuration.setAllowedMethods ( Arrays.asList ( "GET", "POST", "DELETE", "PUT" ) );
        configuration.setAllowedHeaders ( List.of ("Authorization") );
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource (  );
        source.registerCorsConfiguration ( "/**", configuration );
        return source;
    }

     */



    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider ();
        authenticationProvider.setUserDetailsService ( userDetailsService () );
        authenticationProvider.setPasswordEncoder ( passwordEncoder() );
        return authenticationProvider;
    }
}

