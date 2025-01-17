package com.collection.nplusone.v3.service;

import com.collection.nplusone.dto.BalanceContentsResponse;
import com.collection.nplusone.v3.domain.BalanceGameV3;
import com.collection.nplusone.v3.repository.BalanceGameRepositoryV3;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceContentServiceV3 {

    private final BalanceGameRepositoryV3 balanceGameRepository;

    public BalanceContentsResponse getContents(String category) {
        List<BalanceGameV3> games = balanceGameRepository.findByCategory(category);
        return BalanceContentsResponse.fromV3(games);
    }
}
