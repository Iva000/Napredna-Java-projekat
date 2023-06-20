/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.web;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.header.writers.StaticHeadersWriter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.header.writers.StaticHeadersWriter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.header.writers.StaticHeadersWriter;
//import java.io.IOException;

/**
 *
 * @author Iva
 */
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer{
//   
//    @Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("*");
//	}
////	 @Override
////	    public void addCorsMappings(CorsRegistry registry) {
////	        registry.addMapping("/**")
////	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
////	                .allowedOrigins("*")
////	                .allowedHeaders("Content_Type", "Authorization");
////	    }
//
//	@Bean
//	public WebSecurityConfigurerAdapter webSecurity() {
//		return new WebSecurityConfigurerAdapter() {
//
//			@Override
//			protected void configure(HttpSecurity http) throws Exception {
//				http.cors().and().csrf().disable();
//				http.cors();
//				http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));
//			}
//		};
//	}
//        @Bean
//    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
//        return new WebSecurityConfigurerAdapter() {
//            @Override
//            protected void configure(HttpSecurity http) throws Exception {
//                http.cors().and().csrf().disable();
//                http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));
//            }
//        };
//    }
//}

//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*");
//    }
//
//    @Bean
//    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
//        return new WebSecurityConfigurerAdapter() {
//
//            @Override
//            protected void configure(HttpSecurity http) throws Exception {
//                http.cors().and().csrf().disable();
//                http.cors();
//                http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));
//            }
//        };
//    }
//}
//@SuppressWarnings("deprecation")
//@Configuration
////@EnableWebMvc
//public class WebConfig implements JakartaConfig {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*");
//    }
////   @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**")
////                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
////                .allowedOrigins("*")
////                .allowedHeaders("Content_Type", "Authorization");
////    }
//
//    @Bean
//    public SecurityFilter webSecurity() {
//        return new SecurityFilter();
//    }
//
//    public static class SecurityFilter implements Filter {
//
//        @Override
//        public void init(FilterConfig filterConfig) throws ServletException {
//            // Optional: You can perform any initialization logic here
//        }
//
//        @Override
//        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//                throws IOException, ServletException {
//            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//            chain.doFilter(request, response);
//        }
//
//        @Override
//        public void destroy() {
//            // Optional: You can perform any cleanup logic here
//        }
//    }
//}





//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//
//@SuppressWarnings("deprecation")
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public FilterRegistrationBean<SecurityFilter> securityFilter() {
//        FilterRegistrationBean<SecurityFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new SecurityFilter());
//        registrationBean.addUrlPatterns("/*");
//        return registrationBean;
//    }
//
//    public static class SecurityFilter implements Filter {
//
//        @Override
//        public void init(FilterConfig filterConfig) throws ServletException {
//            // Optional: You can perform any initialization logic here
//        }
//
//        @Override
//        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//                throws IOException, ServletException {
//            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//            chain.doFilter(request, response);
//        }
//
//        @Override
//        public void destroy() {
//            // Optional: You can perform any cleanup logic here
//        }
//    }
//}


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	}
//	 @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**")
//	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//	                .allowedOrigins("*")
//	                .allowedHeaders("Content_Type", "Authorization");
//	    }

	@Bean
	public WebSecurityConfigurerAdapter webSecurity() {
		return new WebSecurityConfigurerAdapter() {

			@Override
			protected void configure(HttpSecurity http) throws Exception {
				http.cors().and().csrf().disable();
				http.cors();
				http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));
				http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS"));
			}
		};
	}
}
