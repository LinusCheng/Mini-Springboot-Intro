package MiniSpringBootIntro.controller;

import MiniSpringBootIntro.service.RestEXTService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class RestEXTController {

    private static final Logger logger = LoggerFactory.getLogger(RestEXTController.class);

    @Autowired
    RestEXTService restEXTService;

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/dummyFetchOtherAPI")
    public JsonNode dummyFetchOtherAPI() throws IOException, URISyntaxException {
        logger.info("GET  req: fetch from other API");
        String bodyStr = restEXTService.from_a_website().getBody();
        return mapper.readTree(bodyStr);
    }


}
