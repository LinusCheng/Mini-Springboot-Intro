package test02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Environment.class})
public class LoadEnvVar {

    @Value("${demo.name}")
    String demoName;

    @Test
    public void show(){
        System.out.println("\n\n\n\n" + demoName);
    }

}
