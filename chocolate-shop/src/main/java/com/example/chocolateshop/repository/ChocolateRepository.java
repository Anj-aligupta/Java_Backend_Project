package com.example.chocolateshop.repository;

import com.example.chocolateshop.model.Chocolate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate, Long> {
}

