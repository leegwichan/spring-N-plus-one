package com.collection.nplusone.v3.domain;

import java.util.List;
import lombok.Getter;

public class BalanceGameV3 {

    @Getter
    private final BalanceContentV3 content;

    private final List<BalanceOptionV3> options;

    public BalanceGameV3(BalanceContentV3 content, List<BalanceOptionV3> options) {
        validate(content, options);
        this.content = content;
        this.options = options;
    }

    public static List<BalanceGameV3> createList(List<BalanceContentV3> balanceContents,
                                                 List<BalanceOptionV3> balanceOptions) {
        return balanceContents.stream()
                .map(content -> new BalanceGameV3(content, findOptions(content, balanceOptions)))
                .toList();
    }

    private static List<BalanceOptionV3> findOptions(BalanceContentV3 content, List<BalanceOptionV3> options) {
        return options.stream()
                .filter(option -> option.isContain(content))
                .toList();
    }

    private void validate(BalanceContentV3 content, List<BalanceOptionV3> options) {
        // TODO 검증
    }

    public BalanceOptionV3 getFirstOption() {
        return options.get(0);
    }

    public BalanceOptionV3 getSecondOption() {
        return options.get(1);
    }
}
