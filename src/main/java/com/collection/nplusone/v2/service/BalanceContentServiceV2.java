package com.collection.nplusone.v2.service;

import com.collection.nplusone.dto.BalanceContentsResponse;
import com.collection.nplusone.v2.repository.BalanceContentRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceContentServiceV2 {

    private final BalanceContentRepositoryV2 balanceContentRepository;

    public BalanceContentsResponse getContents(String category) {
        var contents = balanceContentRepository.findAllByCategory(category);
        return BalanceContentsResponse.fromV2(contents);
    }
}
