package MiniSpringBootIntro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FirstDemoConfig {

    @Value("${demo.name}")
    String demoName;
    @Value("${demo.showenv}")
    String showenv;

    @Bean
    public List<String> bean01(){
        System.out.println("In bean01");
        System.out.println("Env: " + showenv);
        return new ArrayList<String>(){{add(demoName);add("cool demo string 2");}};
    }


}
