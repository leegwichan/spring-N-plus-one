package com.collection.nplusone.v1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "balance_option_v1")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BalanceOptionV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "balance_content_id", nullable = false)
    private BalanceContentV1 balanceContent;

    public BalanceOptionV1(BalanceContentV1 content, String name) {
        this.balanceContent = content;
        this.name = name;
    }
}
