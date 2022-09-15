package com.example.demo.webSecurityConfig;

import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserSecurityServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class UsersLogInConfig extends WebSecurityConfigurerAdapter {
    //    final
//    DataSource dataSource;
    final
    UserRepository userRepository;

    @Autowired
    public UsersLogInConfig(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserSecurityServies(userRepository);
//    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return  authProvider;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserSecurityServies(userRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().
                authorizeRequests().
                antMatchers("/").permitAll().
                anyRequest().
                authenticated().
                and().
                formLogin().
                loginPage("/login").permitAll().
                loginProcessingUrl("/loginCheck").failureForwardUrl("/newLogin").
                defaultSuccessUrl("/index", true);


    }
}
