package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.converter.AuthorConverter;
import pl.coderslab.converter.LocalDateConverter;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"pl.coderslab"})
@EnableTransactionManagement
public class FormatterConfig extends WebMvcConfigurerAdapter {

    @Override
    public	void	addFormatters(FormatterRegistry registry)	{
        super.addFormatters(registry);
        registry.addConverter(authorConverter());
        registry.addConverter(localDateConverter());
    }
  @Bean
    public AuthorConverter authorConverter(){
      return new AuthorConverter();
  }
    @Bean
    public LocalDateConverter localDateConverter(){
        return new LocalDateConverter();
    }
}
