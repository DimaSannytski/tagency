package com.ua.tagency.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetService")
    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(@Qualifier("userDetService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')").and().formLogin()
                .loginPage("/login").successHandler(new CustomAuthenticationSuccessHandler())
                .failureUrl("/login?fail=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout().logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID", "RememberMeCookie").invalidateHttpSession(true)
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().sessionManagement().maximumSessions(1).and().and()
                .rememberMe().rememberMeParameter("rememberMe").key("secret key")
                .rememberMeCookieName("RememberMeCookie")
                .tokenValiditySeconds(365*24*60*60);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
