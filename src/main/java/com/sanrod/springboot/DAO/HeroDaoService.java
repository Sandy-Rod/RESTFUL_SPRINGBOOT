package com.sanrod.springboot.DAO;

import com.sanrod.springboot.Model.Hero;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HeroDaoService {


    private static List<Hero> heroes = new ArrayList<>();

    static {
        heroes.add(new Hero(1, "Peter Parker", "Spiderman", new Date()));
        heroes.add(new Hero(2, "Tony Stark", "Ironman", new Date()));
        heroes.add(new Hero(3, "Bruce Banner", "Hulk", new Date()));
    }

    private static int counter = 3;

    //obtengo todos heroes
    public List<Hero> findAll(){
        return heroes;
    }


    //obtengo un heroe en concreto
    public Hero findHeroByID(int id){
        Hero result = null;
        for(Hero hero : heroes){
            if(hero.getId() == id){
                result = hero;
            }
        }
        return result;
    }


    //Añadir un heroe
    public Hero addHero(Hero hero){
        hero.setId(++counter);
        heroes.add(hero);
        return hero;
    }


    //Borrar un heroe
    public boolean deleteHero(int id){
        Iterator<Hero> heroIterator = heroes.iterator();
        Hero heroToRemove = null;
        do{
            heroToRemove = heroIterator.next();
            if(heroToRemove.getId()== id){
                heroIterator.remove();
                return true;
            }
        }while(heroIterator.hasNext());
        return false;
    }
}