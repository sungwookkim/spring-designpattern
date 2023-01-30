package com.designPattern.creationalPattern.pattern.abstractFactory.process;

import com.designPattern.creationalPattern.pattern.abstractFactory.process.join.MemberJoinAbsFactoryProcess;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.validate.MemberJoinValidateAbsFactoryProcess;

/**
 * <pre>
 *     회원가입 추상 팩토리 인터페이스
 * </pre>
 */
public interface MemberJoinAbsFactory {
    /**
     * <pre>
     *     회원가입 프로세스 구현체 반환 메서드
     * </pre>
     *
     * @param joinEntity 회원가입에 필요한 회원정보
     * @return 회원가입 프로세스 구현체
     * @param <T> 회원가입 형태에 맞는 엔티티 타입
     */
    <T> MemberJoinAbsFactoryProcess createMemberJoin(T joinEntity);

    /**
     * <pre>
     *     회원가입 예외 프로세스 구현체 반환 메서드
     * </pre>
     *
     * @param validateEntity 회원가입 예외 처리에 필요한 회원정보
     * @return 회원가입 예외 검증 프로세스 구현체
     * @param <T> 회원가입 형태에 따른 예외 검증 엔티티 타입
     */
    <T> MemberJoinValidateAbsFactoryProcess createMemberJoinValidate(T validateEntity);
}
