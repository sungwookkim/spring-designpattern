package com.designPattern.creationalPattern.factoryMethod.repo;

import com.designPattern.creationalPattern.factoryMethod.entity.KakaoMemberJoinEntity;

/**
 * <pre>
 *     카카오톡으로 가입하는 회원 정보를 다루기 위한 인터페이스
 * </pre>
 */
public interface KakaoMemberJoin extends MemberJoin {

    /**
     * <pre>
     *     카카오톡으로 가입하는 회원 정보를 저장하는 메서드
     * </pre>
     *
     * @param kakaoMemberJoinEntity 카카오톡 회원정보 엔티티
     */
    void kakaoJoin(KakaoMemberJoinEntity kakaoMemberJoinEntity);
}
