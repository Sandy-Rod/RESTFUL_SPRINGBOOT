package com.sanrod.springboot.Controller;

import com.sanrod.springboot.DAO.HeroDaoService;
import com.sanrod.springboot.Model.Hero;
import com.sanrod.springboot.Exceptions.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
//@RequestMapping("/primerendpoint")
public class HeroController {

    @Autowired
    private HeroDaoService heroDaoService;

    @GetMapping("/hero")
    public List<Hero> findAllHeroes(){
        return  heroDaoService.findAll();
    }

    @GetMapping("/hero/{id}")
    public Hero findHeroById(@PathVariable int id){
        Hero result = heroDaoService.findHeroByID(id);
        if(result == null){
            throw new HeroNotFoundException("EL HEROE CON ESTE ID " + id + " NO EXISTE." );
        }
        return result;
    }

    @DeleteMapping("/hero/{id}")
    public void deleteHeroById(@PathVariable int id){
        boolean result = heroDaoService.deleteHero(id);
        if(!result){
            throw new HeroNotFoundException("EL HEROE CON ESTE ID " + id + " NO EXISTE." );
        }
    }


    //Añadir un heroe
    @PostMapping("/hero")
    public ResponseEntity<Object> addHero(@RequestBody @Valid Hero hero){
        Hero addedHero = heroDaoService.addHero(hero);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedHero.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }



}
