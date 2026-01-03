package az.edu.itbrains.Aptekk.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler customFailureHandler() {
        return (request, response, exception) -> {
            String redirectUrl = "/login?error";
            if (exception instanceof DisabledException) {
                redirectUrl = "/login?blocked";
            }
            response.sendRedirect(request.getContextPath() + redirectUrl);
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // JDBC session zamanı bəzən deaktiv edilir, amma ehtiyaca görə aktiv saxla
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**", "/dashboard/**").hasRole("ADMIN")
                        .requestMatchers("/", "/register", "/login", "/front/**", "/coffees","/blog", "/about",
                                "/css/**", "/js/**", "/order-success", "/verify-otp", "/logout"
                        ).permitAll()
                        .requestMatchers("/add-testimonial", "/api/testimonials", "/checkout",
                                "/profile", "/my-orders", "/my-orders/**"
                        ).authenticated()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Ehtiyac olduqda sessiya yarat
                        .maximumSessions(1) // Eyni istifadəçinin yalnız 1 aktiv sessiyası olsun
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/")
                        .failureHandler(customFailureHandler())
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                        .permitAll()
                );

        return http.build();
    }
}
