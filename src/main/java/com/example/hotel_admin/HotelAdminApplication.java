package com.example.hotel_admin;

import com.example.hotel_admin.entity.GuestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.util.Arrays;

@SpringBootApplication
public class HotelAdminApplication {

//    private final GuestEntity guestEntity;
//
//    public HotelAdminApplication(GuestEntity guestEntity) {
//        this.guestEntity = guestEntity;
//    }


    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext run = SpringApplication.run(HotelAdminApplication.class, args);
       // GuestEntity guest = run.getBean("guestEntity", GuestEntity.class);

        System.out.println(Arrays.stream(run.getBeanDefinitionNames()).reduce((x,y)->x+y));
    }

//    @Bean
//    public ViewResolver viewResolver() {
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setTemplateMode("XHTML");
//        templateResolver.setPrefix("templates/");
//        templateResolver.setSuffix(".html");
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver);
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(engine);
//        return viewResolver;
//    }

}
