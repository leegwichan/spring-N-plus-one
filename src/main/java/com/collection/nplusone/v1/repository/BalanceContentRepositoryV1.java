package com.collection.nplusone.v1.repository;

import com.collection.nplusone.v1.domain.BalanceContentV1;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceContentRepositoryV1 extends JpaRepository<BalanceContentV1, Long> {

    List<BalanceContentV1> findAllByCategory(String category);
}
