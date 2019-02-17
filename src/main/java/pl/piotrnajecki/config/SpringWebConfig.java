package pl.piotrnajecki.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "pl.piotrnajecki")
@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // here we need to add static resources like html css javascript, diffrently it will not work
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");


    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        // takes files from folder WEB-INF which normally cannot be accessed by users with browsers
        vr.setViewClass(JstlView.class);
        vr.setPrefix("/WEB-INF/view");
        vr.setSuffix(".jsp");
        return vr;
    }

}

