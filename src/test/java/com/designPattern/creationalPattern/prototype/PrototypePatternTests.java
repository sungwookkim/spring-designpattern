package com.designPattern.creationalPattern.prototype;

import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;
import com.designPattern.creationalPattern.pattern.prototype.repo.PrototypeRepository;
import com.designPattern.creationalPattern.pattern.prototype.service.PrototypeServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                .prototypeRepository(this.prototypeCacheRepositoryImpl)
                .builder();

        for(String code : codes) {
            // 코드 값이 CODE_3인 경우 임의로 예외를 발생 시켜 트랜잭션 롤백이 정상적으로 수행되는지 확인를 위한 코드
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
                .prototypeRepository(this.prototypeCacheRepositoryImpl)
                .builder();

        for(String code : codes) {
            /*
             * DB에 없는 코드 값인 경우 캐시에서 조회하는 코드.
             * 위 코드값_초기화()에서 임의로 발생 시킨 예외의 코드 값인 경우 DB에 없기 때문에 복사된 객체(캐시 저장소 객체)에서 해당 코드 값을 조회
              */
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
