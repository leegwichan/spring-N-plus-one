package com.collection.nplusone.v3.repository;

import com.collection.nplusone.v3.domain.BalanceContentV3;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceContentRepositoryV3 extends JpaRepository<BalanceContentV3, Long> {

    List<BalanceContentV3> findAllByCategory(String category);
}
