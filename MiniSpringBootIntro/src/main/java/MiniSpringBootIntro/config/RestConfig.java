package MiniSpringBootIntro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {


    @Bean
//    @LoadBalanced
    public RestTemplate restTemplateEur(){
        return new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplateEXT(){
        System.out.println("In restTemplate external");
        return new RestTemplate();
    }


}
