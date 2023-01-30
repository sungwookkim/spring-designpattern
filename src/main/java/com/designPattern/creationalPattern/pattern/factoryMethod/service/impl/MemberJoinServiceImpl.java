package com.designPattern.creationalPattern.pattern.factoryMethod.service.impl;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.factoryMethod.process.MemberJoinProcess;
import com.designPattern.creationalPattern.pattern.factoryMethod.process.impl.MemberJoinProcessImpl;
import com.designPattern.creationalPattern.repo.memberJoin.MemberJoin;
import com.designPattern.creationalPattern.repo.memberJoin.write.MemberJoinWrite;
import com.designPattern.creationalPattern.pattern.factoryMethod.service.MemberJoinService;
import com.designPattern.creationalPattern.pattern.factoryMethod.service.abs.MemberJoinServiceAbs;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     기본 회원가입 팩토리 메서드 패턴 하위 클래스
 * </pre>
 */
@Service
public class MemberJoinServiceImpl extends MemberJoinServiceAbs implements MemberJoinService {
    private final MemberJoin memberJoinImpl;

    public MemberJoinServiceImpl(MemberJoin memberJoinImpl) {
        this.memberJoinImpl = memberJoinImpl;
    }

    /**
     * <pre>
     *     {@link MemberJoinService#join(Object)}
     * </pre>
     *
     * @param joinEntity 전달 받은 객체를 {@link MemberJoinEntity}로 형변환.
     * @param <T> {@link MemberJoinEntity} 타입
     * @return 기본 회원가입 처리를 하는 {@link MemberJoinProcessImpl} 구현체 반환
     */
    @Override
    protected <T> MemberJoinProcess createMemberJoin(T joinEntity) {
        return new MemberJoinProcessImpl(this.memberJoinImpl, (MemberJoinEntity) joinEntity);
    }
}
