package com.sanrod.springboot.DAO;

import com.sanrod.springboot.Model.Hero;
import com.sanrod.springboot.Model.Power;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


public interface IHeroService {

    List<Hero> findAll();
    Hero findHeroByID(int id);
    Hero addHero(Hero hero);
    void deleteHero(int id);

    List<Power> findAllPowersByHero(int heroIOd);
    Power findPowerById(int heroId, int powerId);
    Power addPower(int heroId, Power power);
    void deletePower(int heroId, int powerId);

}
