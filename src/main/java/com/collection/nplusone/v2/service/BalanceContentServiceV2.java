package com.collection.nplusone.v2.service;

import com.collection.nplusone.dto.BalanceContentsResponse;
import com.collection.nplusone.v2.repository.BalanceContentRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BalanceContentServiceV2 {

    private final BalanceContentRepositoryV2 balanceContentRepository;

    @Transactional(readOnly = true)
    public BalanceContentsResponse getContents(String category) {
        var contents = balanceContentRepository.findAllByCategory(category);
        return BalanceContentsResponse.fromV2(contents);
    }
}
