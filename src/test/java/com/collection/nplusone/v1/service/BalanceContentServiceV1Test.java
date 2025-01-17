package com.collection.nplusone.v1.service;

import com.collection.nplusone.v1.domain.BalanceContentV1;
import com.collection.nplusone.v1.domain.BalanceOptionV1;
import com.collection.nplusone.v1.repository.BalanceContentRepositoryV1;
import com.collection.nplusone.v1.repository.BalanceOptionRepositoryV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class BalanceContentServiceV1Test {

    private static final String CATEGORY = "CATEGORY";
    private static final Logger log = LoggerFactory.getLogger(BalanceContentServiceV1Test.class);

    @Autowired
    private BalanceContentServiceV1 balanceContentService;

    @Autowired
    private BalanceContentRepositoryV1 balanceContentRepository;

    @Autowired
    private BalanceOptionRepositoryV1 balanceOptionRepository;

    @BeforeEach
    void setUp() {
        var content1 = balanceContentRepository.save(new BalanceContentV1("name1", CATEGORY));
        var content2 = balanceContentRepository.save(new BalanceContentV1("name2", CATEGORY));
        var content3 = balanceContentRepository.save(new BalanceContentV1("name3", CATEGORY));

        balanceOptionRepository.save(new BalanceOptionV1(content1, "name1_1"));
        balanceOptionRepository.save(new BalanceOptionV1(content1, "name1_2"));
        balanceOptionRepository.save(new BalanceOptionV1(content2, "name2_1"));
        balanceOptionRepository.save(new BalanceOptionV1(content2, "name2_2"));
        balanceOptionRepository.save(new BalanceOptionV1(content3, "name3_1"));
        balanceOptionRepository.save(new BalanceOptionV1(content3, "name3_2"));
    }

    @Test
    void test() {
        log.info("-- 테스트 쿼리 시작 --");
        balanceContentService.getContents(CATEGORY);
        log.info("-- 테스트 쿼리 종료 --");
    }
}
