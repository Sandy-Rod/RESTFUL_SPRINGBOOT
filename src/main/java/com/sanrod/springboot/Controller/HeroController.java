package com.sanrod.springboot.Controller;

import com.sanrod.springboot.DAO.IHeroService;
import com.sanrod.springboot.Model.Hero;
import com.sanrod.springboot.Exceptions.HeroNotFoundException;
import com.sanrod.springboot.Model.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
//@RequestMapping("/firstEndpoint/")
public class HeroController {

    @Autowired
    @Qualifier("jpa")
    private IHeroService heroService;

    @GetMapping("/hero")
    public List<Hero> findAllHeroes(){
        return  heroService.findAll();
    }


    @GetMapping("/hero/{id}")
    public Hero findHeroById(@PathVariable int id){
        Hero result = heroService.findHeroByID(id);
        if(result == null){
            throw new HeroNotFoundException("EL HEROE CON ESTE ID " + id + " NO EXISTE." );
        }
        return result;
    }


    @DeleteMapping("/hero/{id}")
    public void deleteHeroById(@PathVariable int id){
        Hero result = heroService.findHeroByID(id);
        if(result ==null){
            throw new HeroNotFoundException("EL HEROE CON ESTE ID " + id + " NO EXISTE." );
        }
        heroService.deleteHero(id);
    }


    //Añadir un heroe
    @PostMapping("/hero")
    public ResponseEntity<Object> addHero(@RequestBody @Valid Hero hero){
        Hero addedHero = heroService.addHero(hero);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedHero.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/hero/{heroId}/power")
    public List<Power> findAllPowerByHero(@PathVariable int heroId){
        return heroService.findAllPowersByHero(heroId);
    }



    @PostMapping("/hero/{heroId}/power")
    public ResponseEntity<Object> addPower(@PathVariable int heroId, @RequestBody @Valid Power power) {
        Power addedPower = heroService.addPower(heroId, power);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{powerId}")
                .buildAndExpand(addedPower.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }


    @GetMapping("/hero/{heroId}/power/{powerId}")
    public Power findPowerByHero(@PathVariable int heroId, @PathVariable int powerId){
        return heroService.findPowerById(heroId,powerId);
    }


    @DeleteMapping("/hero/{heroId}/power/{powerId}")
    public void deletePowerById(@PathVariable int heroId, @PathVariable int powerId){
        heroService.deletePower(heroId, powerId);
    }















}