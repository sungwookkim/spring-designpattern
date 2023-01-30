package com.designPattern.creationalPattern.pattern.prototype.service;

import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;
import com.designPattern.creationalPattern.pattern.prototype.repo.PrototypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrototypeServiceImpl {

    private final PrototypeRepository prototypeRepository;

    PrototypeServiceImpl(PrototypeRepository prototypeJPARepository) {
        this.prototypeRepository = prototypeJPARepository;
    }

    public void save(String code) {
        PrototypeEntity prototypeEntity = new PrototypeEntity(code);
        TransactionalImpl.Singleton.exec(() -> prototypeRepository.save(prototypeEntity));
    }

    public void exceptionSave(String code) {
        PrototypeEntity prototypeEntity = new PrototypeEntity(code);

        TransactionalImpl.Singleton.exec(() -> {
            prototypeRepository.save(prototypeEntity);
            if(true) {
                throw new IllegalStateException("롤백");
            }
        });
    }

    public Optional<PrototypeEntity> findById(String code) {
        return TransactionalImpl.Singleton.exec(() -> prototypeRepository.findById(code));
    }

    public List<PrototypeEntity> findAll() {
        return TransactionalImpl.Singleton.exec(prototypeRepository::findAll);
    }

    public PrototypeServiceImpl.CloneBuilder clone() {
        return new PrototypeServiceImpl.CloneBuilder(this);
    }

    public static class CloneBuilder {
        private PrototypeRepository prototypeRepository;

        CloneBuilder(PrototypeServiceImpl prototypeServiceImpl) {
            this.prototypeRepository = prototypeServiceImpl.prototypeRepository;
        }

        public PrototypeServiceImpl.CloneBuilder prototypeWrite(PrototypeRepository prototypeRepository) {
            this.prototypeRepository = prototypeRepository;
            return this;
        }

        public PrototypeServiceImpl builder() {
            return new PrototypeServiceImpl(this.prototypeRepository);
        }
    }
}
