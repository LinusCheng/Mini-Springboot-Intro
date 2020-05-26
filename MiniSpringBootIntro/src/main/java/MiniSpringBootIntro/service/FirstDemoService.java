package MiniSpringBootIntro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstDemoService {

    @Autowired
    List<String> bean01;

    public String theBean01Data(){
        return "In the list: " + bean01.get(0) + ", " + bean01.get(1);
    }

}
