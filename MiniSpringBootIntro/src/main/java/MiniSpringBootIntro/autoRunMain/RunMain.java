package MiniSpringBootIntro.autoRunMain;

import MiniSpringBootIntro.Application;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class RunMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .build()
                .run(args);

        List bean01List = (List) ctx.getBeanFactory().getBean("bean01");
        System.out.println(bean01List);

        String theUser = ctx.getEnvironment().getProperty("demo.api01.user");
        System.out.println("The user is: " + theUser);

        // We can use this to only run app for the tasks above and stop it if we remove this dependency:
        // <artifactId>spring-boot-starter-web</artifactId>

    }


}
