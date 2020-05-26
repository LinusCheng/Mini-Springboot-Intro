package MiniSpringBootIntro.controller;

import MiniSpringBootIntro.service.FirstDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstDemoController {

    private static final Logger logger = LoggerFactory.getLogger(FirstDemoController.class);

    @Autowired
    FirstDemoService firstDemoService;

    @GetMapping("try01")
    public String try01(){
        logger.info("GET  req: Demo Bean");
        return firstDemoService.theBean01Data();
    }

}
