//package com.projet_microservice.projet_microservice;
//
//
//import java.util.Locale;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Description;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
////import org.thymeleaf.templateresolver.TemplateResolver;
//
//
//@Configuration
//@ComponentScan({ "com.projet_microservice.projet_microservice","com.dao","com.logmanagement", "com.logs" })
//@EnableAutoConfiguration
//public class MvcConfig extends WebMvcConfigurerAdapter {
//	
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("i18n/messages");
//		return messageSource;
//	}
//	
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor() {
//	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//	localeChangeInterceptor.setParamName("lang");
//	return localeChangeInterceptor;
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//	registry.addInterceptor(localeChangeInterceptor());
//	}
//	
//	@Bean
//	public CookieLocaleResolver localeResolver() {
//	CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//	localeResolver.setCookieName("lang");
//	localeResolver.setDefaultLocale(new Locale("fr"));
//	return localeResolver;
//	}
//	
//	@Override
//	@Bean
//	public TemplateResolver templateResolver() {
//	        TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//	        templateResolver.setPrefix("templates/");
//	        templateResolver.setCacheable(false);
//	        templateResolver.setSuffix(".html");
//	        templateResolver.setTemplateMode("HTML5");
//	        return templateResolver;
//	    }
//	
//	@Bean
//	@Description("Thymeleaf Template Resolver")
//	public ClassLoaderTemplateResolver templateResolver() {
//		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//	    templateResolver.setPrefix("/WEB-INF/views/");
//	    templateResolver.setSuffix(".html");
//	    templateResolver.setTemplateMode("HTML5");
//	 
//	    return templateResolver;
//	}
//	 
//	@Bean
//	@Description("Thymeleaf Template Engine")
//	public SpringTemplateEngine templateEngine() {
//	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//	    templateEngine.setTemplateResolver(templateResolver());
//	    templateEngine.setTemplateEngineMessageSource(messageSource());
//	    return templateEngine;
//	}
//	
//	@Bean
//	@Description("Thymeleaf View Resolver")
//	public ThymeleafViewResolver viewResolver() {
//	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//	    viewResolver.setTemplateEngine(templateEngine());
//	    viewResolver.setOrder(1);
//	    return viewResolver;
//	}
//}
////
////@Configuration
////@EnableWebMvc
////public class MvcConfig extends WebMvcConfigurerAdapter {
////
////    public MvcConfig() {
////        super();
////    }
////
////    @Override
////    public void addViewControllers(final ViewControllerRegistry registry)             {
////        super.addViewControllers(registry);
////        registry.addViewController("/").setViewName("index");
////        registry.addViewController("/sorting").setViewName("sorting");
////    }
////
////    @Override
////    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
////        configurer.enable();
////    }
////
////    @Override
////    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/resources/**").addResourceLocations("/", "/resources/","/resource/*");
////        registry.addResourceHandler("/assets/**")
////    .addResourceLocations("classpath:/assets/");
////        registry.addResourceHandler("/css/**")
////    .addResourceLocations("/css/");
////    }
////
////
////    @Bean
////    public TemplateResolver templateResolver() {
////            TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
////            templateResolver.setPrefix("templates/");
////            templateResolver.setCacheable(false);
////            templateResolver.setSuffix(".html");
////            templateResolver.setTemplateMode("HTML5");
////            return templateResolver;
////        }
////
////    @Bean
////    public SpringTemplateEngine templateEngine() {
////        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
////        templateEngine.setTemplateResolver(templateResolver());
////        return templateEngine;
////    }
////
////    @Bean
////    public ViewResolver viewResolver() {
////        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
////        viewResolver.setTemplateEngine(templateEngine());
////        viewResolver.setCharacterEncoding("UTF-8");
////        viewResolver.setOrder(1);
////        return viewResolver;
////    }
////}