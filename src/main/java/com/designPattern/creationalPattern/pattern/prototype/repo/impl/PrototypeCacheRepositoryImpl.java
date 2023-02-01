package com.designPattern.creationalPattern.pattern.prototype.repo.impl;

import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;
import com.designPattern.creationalPattern.pattern.prototype.repo.PrototypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <pre>
 *     캐시 사용 코드 구현체
 *     예제를 위해 변수에 저장
 * </pre>
 */
@Repository
public class PrototypeCacheRepositoryImpl implements PrototypeRepository {

    private final List<PrototypeEntity> cacheValue = new ArrayList<>();

    /**
     * {@link PrototypeRepository#save(PrototypeEntity)}
     */
    @Override
    public PrototypeEntity save(PrototypeEntity value) {
        this.cacheValue.add(value);
        return value;
    }

    /**
     * {@link PrototypeRepository#findAll()}
     */
    @Override
    public List<PrototypeEntity> findAll() {
        return this.cacheValue;
    }

    /**
     * {@link PrototypeRepository#findById(String)}
     */
    @Override
    public Optional<PrototypeEntity> findById(String code) {

        for(PrototypeEntity prototypeEntity : cacheValue) {
            if(code.equals(prototypeEntity.getCode())) {
                return Optional.of(prototypeEntity);
            }
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(this.cacheValue);
        } catch (Exception e) {
            return this.cacheValue.toString();
        }
    }
}
