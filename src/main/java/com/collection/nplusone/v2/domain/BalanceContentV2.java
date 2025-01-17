package com.collection.nplusone.v2.domain;

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
@Table(name = "balance_content_v2")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BalanceContentV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "balanceContent")
    private List<BalanceOptionV2> balanceOptions = new ArrayList<>();
}
