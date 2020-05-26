package MiniSpringBootIntro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;


@Service
public class RestEXTService {

    @Autowired
    RestTemplate restTemplateEXT;

    public ResponseEntity<String> from_a_website() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        String thePath = "http://dummy.restapiexample.com/api/v1/employees";
        URI tarURI = new URI(thePath);
        HttpEntity req = new HttpEntity(null,headers);
        return restTemplateEXT.exchange(tarURI, HttpMethod.GET,req,String.class);

    }



}
