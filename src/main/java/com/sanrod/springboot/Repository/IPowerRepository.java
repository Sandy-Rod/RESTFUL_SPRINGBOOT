package com.sanrod.springboot.Repository;

import com.sanrod.springboot.Model.Power;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPowerRepository extends JpaRepository<Power, Integer> {
}
