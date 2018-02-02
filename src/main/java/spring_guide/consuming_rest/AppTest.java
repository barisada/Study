package spring_guide.consuming_rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class AppTest {
    private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Quote q = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        LOG.info("quote : {}", q);
    }
}
