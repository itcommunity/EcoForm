package org.eco.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
@ComponentScan("org.eco")
public class AppConfig extends WebMvcConfigurerAdapter  {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**/**")
			.allowedOrigins("*")
			.allowedMethods("PUT", "DELETE","GET","POST").allowedHeaders("*");
	}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration registration = registry.addResourceHandler("/**");
        registration.addResourceLocations("/WEB-INF/static/");
        registration.setCachePeriod(0);
    }

    @Bean
    public JdbcTemplate initJDBCTemplate(){
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setDriverClass(org.postgresql.Driver.class);
        simpleDriverDataSource.setUrl("jdbc:postgresql://localhost:5432/ecoevolution");
        simpleDriverDataSource.setUsername("postgres");
        simpleDriverDataSource.setPassword("1234");

        return new JdbcTemplate(simpleDriverDataSource);

    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(2000000);
        return multipartResolver;
    }

}
