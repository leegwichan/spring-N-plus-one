package com.collection.nplusone.v3.repository;

import com.collection.nplusone.v3.domain.BalanceContentV3;
import com.collection.nplusone.v3.domain.BalanceOptionV3;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceOptionRepositoryV3 extends JpaRepository<BalanceOptionV3, Long> {

    List<BalanceOptionV3> findAllByBalanceContentIn(List<BalanceContentV3> contents);
}
