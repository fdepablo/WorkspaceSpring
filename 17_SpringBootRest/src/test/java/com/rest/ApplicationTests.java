package com.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.rest.modelo.entidades.Pelicula;

@RunWith(SpringRunner.class)
//@SpringBootTest
@RestClientTest
public class ApplicationTests {

	Logger logger = LoggerFactory.getLogger(ApplicationTests.class);
	
	@Test
	public void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        Pelicula pelicula = restTemplate.getForObject("http://localhost:8080/peliculas/1", Pelicula.class);
        logger.debug(pelicula.toString());
        Assert.assertEquals("El día de la bestia", pelicula.getTitulo());
	}
}
