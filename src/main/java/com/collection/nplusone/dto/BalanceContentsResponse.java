package com.collection.nplusone.dto;

import com.collection.nplusone.v1.domain.BalanceContentV1;
import com.collection.nplusone.v2.domain.BalanceContentV2;
import com.collection.nplusone.v3.domain.BalanceGameV3;
import java.util.List;

public record BalanceContentsResponse(List<BalanceContentResponse> contents) {

    public static BalanceContentsResponse fromV1(List<BalanceContentV1> contents) {
        List<BalanceContentResponse> response = contents.stream()
                .map(BalanceContentResponse::new)
                .toList();
        return new BalanceContentsResponse(response);
    }

    public static BalanceContentsResponse fromV2(List<BalanceContentV2> contents) {
        List<BalanceContentResponse> response = contents.stream()
                .map(BalanceContentResponse::new)
                .toList();
        return new BalanceContentsResponse(response);
    }

    public static BalanceContentsResponse fromV3(List<BalanceGameV3> games) {
        List<BalanceContentResponse> response = games.stream()
                .map(BalanceContentResponse::new)
                .toList();
        return new BalanceContentsResponse(response);
    }
}
