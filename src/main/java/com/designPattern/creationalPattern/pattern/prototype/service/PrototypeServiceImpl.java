package com.designPattern.creationalPattern.pattern.prototype.service;

import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;
import com.designPattern.creationalPattern.pattern.prototype.repo.PrototypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 *     코드 관련 프로세스 처리를 위한 서비스 클래스
 * </pre>
 */
@Service
public class PrototypeServiceImpl {

    private final PrototypeRepository prototypeRepository;

    PrototypeServiceImpl(PrototypeRepository prototypeJPARepository) {
        this.prototypeRepository = prototypeJPARepository;
    }

    /**
     * <pre>
     *     코드 정보 저장
     * </pre>
     *
     * @param code 저장하고자 하는 코드 값
     */
    public void save(String code) {
        PrototypeEntity prototypeEntity = new PrototypeEntity(code);
        TransactionalImpl.Singleton.exec(() -> prototypeRepository.save(prototypeEntity));
    }

    /**
     * <pre>
     *     예외 발생 시 트랜잭션 롤백 확인을 위한 테스트용 저장
     * </pre>
     *
     * @param code 트랜잭션 롤백을 시키고자 하는 코드 값
     */
    public void exceptionSave(String code) {
        PrototypeEntity prototypeEntity = new PrototypeEntity(code);

        TransactionalImpl.Singleton.exec(() -> {
            prototypeRepository.save(prototypeEntity);
            if(true) {
                throw new IllegalStateException("롤백");
            }
        });
    }

    /**
     * <pre>
     *     특정 코드 값을 조회
     * </pre>
     *
     * @param code 조회 하고자 하는 특정 코드 값
     * @return 조회된 코드 정보
     */
    public Optional<PrototypeEntity> findById(String code) {
        return TransactionalImpl.Singleton.exec(() -> prototypeRepository.findById(code));
    }

    /**
     * <pre>
     *     전체 코드 정보 조회
     * </pre>
     *
     * @return 조회된 모든 코드 정보
     */
    public List<PrototypeEntity> findAll() {
        return TransactionalImpl.Singleton.exec(prototypeRepository::findAll);
    }

    /**
     * <pre>
     *     객체 복사에 필요한 빌더 객체
     *     복사 객체의 반환을 위해선 빌더 클래스의 builder 메서드를 호출하여야 한다.
     * </pre>
     *
     * @return 해당 객체의 복사를 도와주는 빌더 객체
     */
    public PrototypeServiceImpl.CloneBuilder clone() {
        return new PrototypeServiceImpl.CloneBuilder(this);
    }

    /**
     * <pre>
     *     복사된 객체의 속성을 변경하기 위한 빌더 클래스
     *     set 메서드로 속성 변경을 허용하게 되면 Spring bean에 등록되어 있는 객체의 속성까지 변경될 우려가 있기 때문에
     *     set 메서드 대신 빌더 패턴을 이용해서 속성 변경을 유도
     * </pre>
     */
    public static class CloneBuilder {
        private PrototypeRepository prototypeRepository;

        CloneBuilder(PrototypeServiceImpl prototypeServiceImpl) {
            this.prototypeRepository = prototypeServiceImpl.prototypeRepository;
        }

        public PrototypeServiceImpl.CloneBuilder prototypeRepository(PrototypeRepository prototypeRepository) {
            this.prototypeRepository = prototypeRepository;
            return this;
        }

        public PrototypeServiceImpl builder() {
            return new PrototypeServiceImpl(this.prototypeRepository);
        }
    }
}
