//package com.aouto.CarDealer;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.cors().disable()
////                .authorizeRequests()
////                .antMatchers("/", "image/upload")
////                .permitAll()
////                .and()
////                .httpBasic();
////    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//        .authorizeRequests().antMatchers("/**").permitAll()
//                .anyRequest().authenticated();
//    }
//
//
//
//}
