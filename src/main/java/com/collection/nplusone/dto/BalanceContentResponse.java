package com.collection.nplusone.dto;

public record BalanceContentResponse(
        long contentId,
        String contentName,
        BalanceOptionResponse firstOption,
        BalanceOptionResponse secondOption
) {
}
