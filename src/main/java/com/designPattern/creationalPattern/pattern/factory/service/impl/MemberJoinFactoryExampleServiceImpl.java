package com.designPattern.creationalPattern.pattern.factory.service.impl;

import com.designPattern.creationalPattern.pattern.factory.repo.process.MemberJoinProcess;
import com.designPattern.creationalPattern.pattern.factory.repo.process.impl.MemberJoinProcessImpl;
import com.designPattern.creationalPattern.pattern.factory.service.MemberJoinFactoryExampleService;
import com.designPattern.creationalPattern.pattern.factory.service.abs.MemberJoinFactoryExampleServiceAbs;
import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     기본 회원가입 팩토리 메서드 패턴 하위 클래스
 * </pre>
 */
@Service
public class MemberJoinFactoryExampleServiceImpl extends MemberJoinFactoryExampleServiceAbs implements MemberJoinFactoryExampleService {

    /**
     * <pre>
     *     {@link MemberJoinFactoryExampleService#join(Object)}
     * </pre>
     *
     * @param joinEntity 전달 받은 객체를 {@link MemberJoinEntity}로 형변환.
     * @param <T> {@link MemberJoinEntity} 타입
     * @return 기본 회원가입 처리를 하는 {@link MemberJoinProcessImpl} 구현체 반환
     */
    @Override
    protected <T> MemberJoinProcess createMemberJoin(T joinEntity) {
        return new MemberJoinProcessImpl((MemberJoinEntity) joinEntity);
    }
}
