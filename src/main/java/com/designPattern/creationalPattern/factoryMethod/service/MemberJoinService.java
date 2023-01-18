package com.designPattern.creationalPattern.factoryMethod.service;

/**
 * <pre>
 *     회원가입 처리 시 트랜잭션 처리를 위한 인터페이스
 * </pre>
 */
public interface MemberJoinService {

    /**
     * <pre>
     *     회원가입 저장 트랜잭션 처리 메서드.
     *     해당 메서드는 팩토리 메서드 패턴을 활용한다.
     *     이때 저장 시 전달 받은 회원 정보 객체 타입이 다양할 수 있음으로 제네릭으로 선언.
     * </pre>
     *
     * @param joinEntity 저정할 회원정보 엔티티
     * @param <T> 저장 시 전달 받을 엔티티 타입
     */
    <T> void join(T joinEntity);
}
