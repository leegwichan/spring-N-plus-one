package com.collection.nplusone.dto;

import com.collection.nplusone.v1.domain.BalanceContentV1;
import com.collection.nplusone.v2.domain.BalanceContentV2;
import com.collection.nplusone.v3.domain.BalanceGameV3;

public record BalanceContentResponse(
        long contentId,
        String contentName,
        BalanceOptionResponse firstOption,
        BalanceOptionResponse secondOption
) {
    public BalanceContentResponse(BalanceContentV1 content) {
        this(
                content.getId(),
                content.getName(),
                new BalanceOptionResponse(content.getFirstOption()),
                new BalanceOptionResponse(content.getSecondOption())
        );
    }

    public BalanceContentResponse(BalanceContentV2 content) {
        this(
                content.getId(),
                content.getName(),
                new BalanceOptionResponse(content.getFirstOption()),
                new BalanceOptionResponse(content.getSecondOption())
        );
    }

    public BalanceContentResponse(BalanceGameV3 game) {
        this(
                game.getContent().getId(),
                game.getContent().getName(),
                new BalanceOptionResponse(game.getFirstOption()),
                new BalanceOptionResponse(game.getSecondOption())
        );
    }
}
