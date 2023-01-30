package com.designPattern.creationalPattern.prototype;

import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;
import com.designPattern.creationalPattern.pattern.prototype.repo.PrototypeRepository;
import com.designPattern.creationalPattern.pattern.prototype.service.PrototypeServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PrototypePatternTests {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    List<String> codes = Arrays.asList("CODE_1", "CODE_2", "CODE_3", "CODE_4", "CODE_5");

    @Autowired
    PrototypeServiceImpl prototypeServiceImpl;

    @Autowired
    PrototypeRepository prototypeCacheRepositoryImpl;

    @Test
    void 코드값_초기화() {
        PrototypeServiceImpl prototypeService = this.prototypeServiceImpl.clone()
                .prototypeWrite(this.prototypeCacheRepositoryImpl)
                .builder();

        for(String code : codes) {
            if("CODE_3".equals(code)) {
                try {
                    this.prototypeServiceImpl.exceptionSave(code);
                } catch (Exception e) {
                    logger.info("Code DB Save Fail : {}", code);
                }
            } else {
                this.prototypeServiceImpl.save(code);
            }

            prototypeService.save(code);
        }
    }

    @Test
    void 코드값_테스트() {
        this.코드값_초기화();

        PrototypeServiceImpl prototypeService = this.prototypeServiceImpl.clone()
                .prototypeWrite(this.prototypeCacheRepositoryImpl)
                .builder();

        for(String code : codes) {
            Optional<PrototypeEntity> findCode = Optional.ofNullable(this.prototypeServiceImpl.findById(code))
                    .filter(Optional::isPresent)
                    .orElseGet(() -> {
                        logger.info("Cache Code : {}", code);
                        return prototypeService.findById(code);
                    });

            logger.info("Find Code : {}", findCode.get().getCode());
        }
    }
}
