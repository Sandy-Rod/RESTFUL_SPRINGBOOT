package com.sanrod.springboot.Repository;

import com.sanrod.springboot.Model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHeroRepository extends JpaRepository<Hero, Integer> {

    //método para que busque por nombre
    //Hero fingByName(String name);

}
