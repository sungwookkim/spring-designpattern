package com.designPattern.creationalPattern.pattern.prototype.repo;

import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 *     코드 관련 인터페이스
 * </pre>
 */
public interface PrototypeRepository {

    /**
     * <pre>
     *     코드 저장
     * </pre>
     *
     * @param value 저장할 코드 정보
     * @return 저장된 코드 엔티티
     */
    PrototypeEntity save(PrototypeEntity value);

    /**
     * <pre>
     *     코드 전체 조회
     * </pre>
     *
     * @return 전체 코드 정보
     */
    List<PrototypeEntity> findAll();

    /**
     * <pre>
     *     특정 코드 조회
     * </pre>
     *
     * @param code 조회 하고자 하는 코드 값
     * @return 조회된 코드 정보
     */
    Optional<PrototypeEntity> findById(String code);
}
