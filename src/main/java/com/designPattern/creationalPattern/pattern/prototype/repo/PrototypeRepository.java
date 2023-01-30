package com.designPattern.creationalPattern.pattern.prototype.repo;

import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;

import java.util.List;
import java.util.Optional;

public interface PrototypeRepository {
    PrototypeEntity save(PrototypeEntity value);

    List<PrototypeEntity> findAll();

    Optional<PrototypeEntity> findById(String code);
}
