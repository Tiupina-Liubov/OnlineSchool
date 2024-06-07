package com.example.online_school.configuration;


import com.example.online_school.handler.CustomAccessDeniedHandler;
import com.example.online_school.security.UserDetailsServiceImpl;
import io.swagger.v3.oas.models.PathItem;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    private final AuthTokenFilter authTokenFilter;

    private final UserDetailsServiceImpl userDetailsService;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()
                                .requestMatchers("/swagger-resources/**").permitAll()
                                .requestMatchers("/swagger-ui.html").permitAll()
                                .requestMatchers("/webjars/**").permitAll()
                                .requestMatchers("/favicon.ico").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                                // Ограничиваем доступ к защищенным ресурсам
//                                .requestMatchers("/authority/**").hasRole("ADMIN")
//                                .requestMatchers("/users/**").hasRole("USER")
//                                .requestMatchers("/roles/**").hasRole("TEACHER")
//                                .requestMatchers("/read_secret").hasAuthority("READ_PRIVILEGE")
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.accessDeniedHandler(customAccessDeniedHandler)
                )
                .logout(logoutPage -> logoutPage.logoutSuccessUrl("/"))
                .build();
    }

   // Если создавать юзеров прям в памяти
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user = User.builder()
//                .passwordEncoder(new BCryptPasswordEncoder()::encode)
//                .username("user")
//                .password("User1234!")//{bcrypt}
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .passwordEncoder(new BCryptPasswordEncoder()::encode)
//                .username("admin")
//                .password("Admin1234!")//{bcrypt}
//                .roles("ADMIN", "USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
