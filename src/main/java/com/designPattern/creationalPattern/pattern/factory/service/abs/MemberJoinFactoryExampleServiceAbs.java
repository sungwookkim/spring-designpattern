package com.designPattern.creationalPattern.pattern.factory.service.abs;

import com.designPattern.creationalPattern.pattern.factory.repo.process.MemberJoinProcess;
import com.designPattern.creationalPattern.pattern.factory.service.MemberJoinFactoryExampleService;

/**
 * <pre>
 *     회원가입 처리 팩토리 메서드 패턴을 활용한 추상 클래스
 * </pre>
 */
public abstract class MemberJoinFactoryExampleServiceAbs implements MemberJoinFactoryExampleService {

    /**
     * {@link MemberJoinFactoryExampleService#join(Object)}
     */
    @Override
    public <T> void join(T joinEntity) {
        MemberJoinProcess memberJoinProcessFactoryMethod = this.createMemberJoin(joinEntity);
        memberJoinProcessFactoryMethod.join();
    }

    /**
     * <pre>
     *     팩토리 메서드 패턴 메서드.
     *     자식 클래스에서 회원가입 처리를 하는 {@link MemberJoinProcess} 구현체를 반환.
     * </pre>
     *
     * @param joinEntity 하위 클래스에서 회원가입 저장 시 사용될 엔티티
     * @param <T> 회원가입 저장 시 사용될 객체 타입
     * @return {@link MemberJoinProcess} 구현체
     */
    protected abstract <T> MemberJoinProcess createMemberJoin(T joinEntity);
}
