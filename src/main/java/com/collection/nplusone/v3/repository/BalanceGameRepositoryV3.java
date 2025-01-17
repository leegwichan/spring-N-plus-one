package com.collection.nplusone.v3.repository;

import com.collection.nplusone.v3.domain.BalanceContentV3;
import com.collection.nplusone.v3.domain.BalanceGameV3;
import com.collection.nplusone.v3.domain.BalanceOptionV3;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BalanceGameRepositoryV3 {

    private final BalanceContentRepositoryV3 balanceContentRepository;
    private final BalanceOptionRepositoryV3 balanceOptionRepository;

    public List<BalanceGameV3> findByCategory(String category) {
        List<BalanceContentV3> contents = balanceContentRepository.findAllByCategory(category);
        List<BalanceOptionV3> options = balanceOptionRepository.findAllByBalanceContentIn(contents);
        return BalanceGameV3.createList(contents, options);
    }
}
