package com.designPattern.creationalPattern.pattern.prototype.repo.impl;

import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;
import com.designPattern.creationalPattern.pattern.prototype.repo.PrototypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PrototypeMybatisRepositoryImpl implements PrototypeRepository {

    private final List<PrototypeEntity> mybatisValue = new ArrayList<>();

    @Override
    public PrototypeEntity save(PrototypeEntity value) {
        this.mybatisValue.add(value);
        return value;
    }

    @Override
    public List<PrototypeEntity> findAll() {
        return this.mybatisValue;
    }

    @Override
    public Optional<PrototypeEntity> findById(String code) {
        for(PrototypeEntity prototypeEntity : mybatisValue) {
            if(code.equals(prototypeEntity.getCode())) {
                return Optional.of(prototypeEntity);
            }
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(this.mybatisValue);
        } catch (Exception e) {
            return this.mybatisValue.toString();
        }
    }
}
