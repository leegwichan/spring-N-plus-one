package com.collection.nplusone.v1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "balance_content_v1")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BalanceContentV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @OneToMany(mappedBy = "balanceContent")
    private List<BalanceOptionV1> balanceOptions = new ArrayList<>();

    public BalanceContentV1(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public BalanceOptionV1 getFirstOption() {
        return balanceOptions.get(0);
    }

    public BalanceOptionV1 getSecondOption() {
        return balanceOptions.get(1);
    }
}
