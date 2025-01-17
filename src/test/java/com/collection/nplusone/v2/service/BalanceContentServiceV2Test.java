package com.collection.nplusone.v2.service;

import com.collection.nplusone.v2.domain.BalanceContentV2;
import com.collection.nplusone.v2.domain.BalanceOptionV2;
import com.collection.nplusone.v2.repository.BalanceContentRepositoryV2;
import com.collection.nplusone.v2.repository.BalanceOptionRepositoryV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class BalanceContentServiceV2Test {

    private static final String CATEGORY = "CATEGORY";
    private static final Logger log = LoggerFactory.getLogger(BalanceContentServiceV2Test.class);

    @Autowired
    private BalanceContentServiceV2 balanceContentService;

    @Autowired
    private BalanceContentRepositoryV2 balanceContentRepository;

    @Autowired
    private BalanceOptionRepositoryV2 balanceOptionRepository;

    @BeforeEach
    void setUp() {
        var content1 = balanceContentRepository.save(new BalanceContentV2("name1", CATEGORY));
        var content2 = balanceContentRepository.save(new BalanceContentV2("name2", CATEGORY));
        var content3 = balanceContentRepository.save(new BalanceContentV2("name3", CATEGORY));

        balanceOptionRepository.save(new BalanceOptionV2(content1, "name1_1"));
        balanceOptionRepository.save(new BalanceOptionV2(content1, "name1_2"));
        balanceOptionRepository.save(new BalanceOptionV2(content2, "name2_1"));
        balanceOptionRepository.save(new BalanceOptionV2(content2, "name2_2"));
        balanceOptionRepository.save(new BalanceOptionV2(content3, "name3_1"));
        balanceOptionRepository.save(new BalanceOptionV2(content3, "name3_2"));
    }

    @Test
    void 다건_조회() {
        log.info("-- 테스트 쿼리 시작 --");
        balanceContentService.getContents(CATEGORY);
        log.info("-- 테스트 쿼리 종료 --");
    }
}
