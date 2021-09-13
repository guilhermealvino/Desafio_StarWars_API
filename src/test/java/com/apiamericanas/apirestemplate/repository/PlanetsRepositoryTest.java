package com.apiamericanas.apirestemplate.repository;


import com.apiamericanas.apirestemplate.model.Planet;
import jakarta.validation.constraints.AssertTrue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PlanetsRepositoryTest {

    Planet planet1, planet2;

    @Autowired
    PlanetsRepository repository;

    @Before
    public void incluir(){
        planet1 = repository.save(Planet.builder().name("terra").climate("quente").terrain("rochoso").build());
        planet2 = repository.save(Planet.builder().name("saturno").climate("frio").terrain("escasso").build());
    }

    @After
    public void deletar(){
        repository.delete(planet1);
        repository.delete(planet2);
    }

    @Test
    public void testaCriarPlaneta(){
        Planet planet = repository.save(Planet.builder().name("jupiter").climate("gelado").terrain("rochoso").build());


            Assert.assertNotNull(planet);



    }

    @Test
    public void testaBuscarPorNome() {
        Planet result = repository.findPlanetByNameEquals("terra");

        if(result != null){

            Assert.assertTrue(result.getName().equals("terra"));
        }
    }

   /* @Test
    public void testaBuscar_por_id() {
        Optional<Planet> obj = repository.findById("613e8e272d462f397249823f");
        Assert.assertTrue(obj.isPresent());



    }*/

    @Test
    public void testaBuscarTodosPlanetas() {

        List<Planet> result = repository.findAll();

        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void testaDeletarPlaneta() {

        Planet planeta = repository.findPlanetByNameEquals("jupiter");
        repository.delete(planeta);
        Planet planetaValidacao = repository.findPlanetByNameEquals("jupiter");

        Assert.assertNull(planetaValidacao);


    }
}
