package com.collection.nplusone.v2.repository;

import com.collection.nplusone.v2.domain.BalanceContentV2;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceContentRepositoryV2 extends JpaRepository<BalanceContentV2, Long> {

    @EntityGraph(attributePaths = "balanceOptions")
    List<BalanceContentV2> findAllByCategory(String category);
}
