package com.collection.nplusone.v3.service;

import com.collection.nplusone.v3.domain.BalanceContentV3;
import com.collection.nplusone.v3.domain.BalanceOptionV3;
import com.collection.nplusone.v3.repository.BalanceContentRepositoryV3;
import com.collection.nplusone.v3.repository.BalanceOptionRepositoryV3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class BalanceContentServiceV3Test {

    private static final String CATEGORY = "CATEGORY";
    private static final Logger log = LoggerFactory.getLogger(BalanceContentServiceV3Test.class);

    @Autowired
    private BalanceContentServiceV3 balanceContentService;

    @Autowired
    private BalanceContentRepositoryV3 balanceContentRepository;

    @Autowired
    private BalanceOptionRepositoryV3 balanceOptionRepository;

    @BeforeEach
    void setUp() {
        var content1 = balanceContentRepository.save(new BalanceContentV3("name1", CATEGORY));
        var content2 = balanceContentRepository.save(new BalanceContentV3("name2", CATEGORY));
        var content3 = balanceContentRepository.save(new BalanceContentV3("name3", CATEGORY));

        balanceOptionRepository.save(new BalanceOptionV3(content1, "name1_1"));
        balanceOptionRepository.save(new BalanceOptionV3(content1, "name1_2"));
        balanceOptionRepository.save(new BalanceOptionV3(content2, "name2_1"));
        balanceOptionRepository.save(new BalanceOptionV3(content2, "name2_2"));
        balanceOptionRepository.save(new BalanceOptionV3(content3, "name3_1"));
        balanceOptionRepository.save(new BalanceOptionV3(content3, "name3_2"));
    }

    @Test
    void test() {
        log.info("-- 테스트 쿼리 시작 --");
        balanceContentService.getContents(CATEGORY);
        log.info("-- 테스트 쿼리 종료 --");
    }
}
