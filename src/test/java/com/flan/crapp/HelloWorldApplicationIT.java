package com.flan.crapp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class HelloWorldApplicationIT {

  @Autowired
  private TestRestTemplate template;

  @Test
  public void contextLoads() throws Exception {
  }

  @Test
  public void testRequest() throws Exception {
    ResponseEntity<String> responseEntity = template.getForEntity("/_ah/health", String.class);
    assertTrue(responseEntity.toString().contains("surviving"));
  }
}
