package com.apiamericanas.apirestemplate.resource;

import com.apiamericanas.apirestemplate.model.Planet;
import com.apiamericanas.apirestemplate.repository.PlanetsRepository;
import com.apiamericanas.apirestemplate.util.ApiSWUtil;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiSWResource {

	@Autowired
	private PlanetsRepository planets;

	@GetMapping("/planets")
	public List<Planet> getAllPlanets() {
		return planets.findAll();
	}
    
    // listar planetas da api do star wars
    //-> @GetMapping("/api.r/planets")
    public ResponseEntity<List> getAllPlanetsSwAPI() throws IOException {
        try {
            
           List<com.apiamericanas.api.resource.models.Planet> planetsApi = ApiSWUtil.getAllPlanets();
           if(planetsApi != null)
           {
               return  ResponseEntity.ok( planetsApi);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return ResponseEntity.badRequest().build();

    }

// Buscar por nome no banco de dados
    @GetMapping("/planets/name/{nome}")
    public ResponseEntity getPlanetByName(@PathVariable String nome) {

        Planet planet = planets.findPlanetByNameEquals(nome);


        if (planet == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(planet);
    }
	//  Buscar por ID no banco de dados
    @GetMapping(value = "/planets/{id}")
	public ResponseEntity<Planet> getPlanetByID(@PathVariable("id") ObjectId id) {

		Planet planet = planets.findBy_id(id);

		if (planet == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(planet);
	}

    @PutMapping(value = "/planets/{id}")
    public ResponseEntity<Planet> modifyPlanetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Planet planet) {
        planet.set_id(id);
        planets.save(planet);
        return ResponseEntity.ok(planet);
    }

    @PostMapping(value = "/planets")
    public ResponseEntity<Planet> createPlanet(@Valid @RequestBody Planet planet) {
        try {
        //se nao passar o nome no json = requisicao invalida
            final String namePlanet = planet.getName();
        if(namePlanet == null)
        {
            return ResponseEntity.unprocessableEntity().build();
        }
        Planet planetFind = planets.findPlanetByNameEquals(namePlanet);
        if (planetFind == null) {

            final com.apiamericanas.api.resource.models.Planet planetApi;

                planetApi = ApiSWUtil.getPlanetByName(namePlanet);

            if (planetApi != null) {

                planets.save(planet);
                return ResponseEntity.ok(planet);
            }

            planet.set_id(ObjectId.get());
            planets.save(planet);
            return ResponseEntity.ok(planet);
        }
        else
        {
            //Se ja existir um planeta, aqui atualiza, insere com msm id e altera o que for diferente
            planetFind.setClimate(planet.getClimate());
            planetFind.setTerrain(planet.getTerrain());
            planets.save(planetFind);
            return ResponseEntity.ok(planetFind);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/planets/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") ObjectId id) {
        Planet planet = planets.findBy_id(id);

        if (planet == null) {
            return ResponseEntity.notFound().build();
        }

        planets.delete(planet);

        return ResponseEntity.noContent().build();
    }



}
