package com.collection.nplusone.dto;

import com.collection.nplusone.v1.domain.BalanceOptionV1;
import com.collection.nplusone.v2.domain.BalanceOptionV2;
import com.collection.nplusone.v3.domain.BalanceOptionV3;

public record BalanceOptionResponse(
        long optionId,
        String optionName
) {

    public BalanceOptionResponse(BalanceOptionV1 option) {
        this(option.getId(), option.getName());
    }

    public BalanceOptionResponse(BalanceOptionV2 option) {
        this(option.getId(), option.getName());
    }

    public BalanceOptionResponse(BalanceOptionV3 option) {
        this(option.getId(), option.getName());
    }
}
