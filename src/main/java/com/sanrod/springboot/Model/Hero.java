package com.sanrod.springboot.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity //(name=nombreTablaDiferenteObjeto) indicamos otro nombre de la tabla
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min=3, message = "El tamaño tiene que ser mayor que 2")
    private String name;
    private String heroName;
    @Past
    private Date birthDate;

    @OneToMany(orphanRemoval = true, mappedBy = "hero", fetch = FetchType.LAZY)
    private List<Power> powers;

    public Hero(){
    }


    public Hero(Integer id, String name, String heroName, Date birthDate){
        this.id         = id;
        this.name       = name;
        this.heroName   = heroName;
        this.birthDate  = birthDate;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }
}
