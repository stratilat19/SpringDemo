package com.learnSpring.db.repositories;

import com.learnSpring.db.entities.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Integer> {
}
