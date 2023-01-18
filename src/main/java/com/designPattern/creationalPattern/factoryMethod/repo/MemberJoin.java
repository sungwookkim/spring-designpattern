package com.designPattern.creationalPattern.factoryMethod.repo;

import com.designPattern.creationalPattern.factoryMethod.entity.MemberJoinEntity;

/**
 * <pre>
 *     가입 회원 정보를 다루기 위한 인터페이스
 * </pre>
 */
public interface MemberJoin {

    /**
     * <pre>
     *     기본 회원 정보를 저장하는 메서드
     * </pre>
     *
     * @param memberJoinEntity 기본 회원정보 엔티티
     */
    void join(MemberJoinEntity memberJoinEntity);
}
