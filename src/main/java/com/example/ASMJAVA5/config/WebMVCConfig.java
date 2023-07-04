package com.example.ASMJAVA5.config;


import com.example.ASMJAVA5.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Configuration
public class WebMVCConfig implements  WebMvcConfigurer {

	@Bean("messageSource")
	public MessageSource loadMessageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		
		source.setBasenames(
				"classpath:message/valiate", 
				"classpath:i18n/home"
		);
		
		source.setDefaultEncoding(StandardCharsets.UTF_8.name());
		return source;
	}
	
	@Bean("localeResolver")
	public LocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setCookieMaxAge(60*60 * 24 * 3);
		cookieLocaleResolver.setCookiePath("/");
		cookieLocaleResolver.setDefaultLocale(new Locale("en"));
		return cookieLocaleResolver;
	}
	
	
	@Autowired 
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/admin/**","/user/**")
		.excludePathPatterns("/login", "/register");
		
		LocaleChangeInterceptor changeInterceptor  = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("language");
		registry.addInterceptor(changeInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/user/**");
	}
	
	
		
	
}
