package com.sanrod.springboot.DAO;

import com.sanrod.springboot.Model.Hero;
import com.sanrod.springboot.Model.Power;
import com.sanrod.springboot.Repository.IHeroRepository;
import com.sanrod.springboot.Repository.IPowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpa")
public class HeroJpaService implements IHeroService{

    @Autowired
    private IHeroRepository heroRepository;

    @Autowired
    private IPowerRepository powerRepository;

    @Override
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public Hero findHeroByID(int id) {
        return heroRepository.findById(id).orElse(null);
    }


    @Override
    public Hero addHero(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public void deleteHero(int id) {
        Hero hero = heroRepository.findById(id).orElse(null);
        if(hero != null){
            heroRepository.delete(hero);
        }
    }

    @Override
    public List<Power> findAllPowersByHero(int heroId) {
        Hero hero = heroRepository.findById(heroId).orElse(null);
        if(hero != null){
            return hero.getPowers();
        }
        return null;
    }

    @Override
    public Power findPowerById(int heroId, int powerId) {
        Hero hero = heroRepository.findById(heroId).orElse(null);
        if(hero != null && hero.getPowers() != null && !hero.getPowers().isEmpty()){
            return hero.getPowers().stream().filter(power -> power.getId() == powerId).findFirst().orElse(null);
        }
        return null;
    }

    @Override
    public Power addPower(int heroId, Power power) {
        Hero hero = heroRepository.findById(heroId).orElse(null);
        if(hero != null) {
            power.setHero(hero);
            return powerRepository.save(power);
        }
        return null;
    }




    @Override
    public void deletePower(int heroId, int powerId) {
        Power power = findPowerById(heroId, powerId);
        if(power!= null){
            powerRepository.delete(power);
        }
    }
}