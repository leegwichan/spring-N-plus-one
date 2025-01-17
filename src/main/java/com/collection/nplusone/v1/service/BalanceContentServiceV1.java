package com.collection.nplusone.v1.service;

import com.collection.nplusone.dto.BalanceContentsResponse;
import com.collection.nplusone.v1.repository.BalanceContentRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceContentServiceV1 {

    private final BalanceContentRepositoryV1 balanceContentRepository;

    public BalanceContentsResponse getContents(String category) {
        var contents = balanceContentRepository.findAllByCategory(category);
        return BalanceContentsResponse.fromV1(contents);
    }
}
