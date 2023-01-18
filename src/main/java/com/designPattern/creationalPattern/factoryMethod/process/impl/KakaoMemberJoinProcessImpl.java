package com.designPattern.creationalPattern.factoryMethod.process.impl;

import com.designPattern.creationalPattern.factoryMethod.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.factoryMethod.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.factoryMethod.process.MemberJoinProcess;
import com.designPattern.creationalPattern.factoryMethod.repo.KakaoMemberJoin;

import java.util.UUID;

/**
 * <pre>
 *     카카오톡 회원가입 처리 프로세스 클래스
 * </pre>
 */
public class KakaoMemberJoinProcessImpl implements MemberJoinProcess {
    private final KakaoMemberJoin kakaoMemberJoinImpl;
    private final KakaoMemberJoinEntity kakaoMemberJoinEntity;

    public KakaoMemberJoinProcessImpl(KakaoMemberJoin kakaoMemberJoinImpl, KakaoMemberJoinEntity kakaoMemberJoinEntity) {
        this.kakaoMemberJoinImpl = kakaoMemberJoinImpl;
        this.kakaoMemberJoinEntity = kakaoMemberJoinEntity;
    }

    /**
     * {@link MemberJoinProcess#join()}
     * 카카오톡 회원가입인 경우엔 응답 받은 카카오톡 전문에서 특정 데이터만 추출하여
     * 기본 회원가입 처리도 동시 처리 진행한다.
     */
    @Override
    public void join() {
        MemberJoinEntity memberJoinEntity = new MemberJoinEntity(this.kakaoMemberJoinEntity.getKakaoAccountEmail()
                , UUID.randomUUID().toString().replace("-", "").substring(0, 10)
                , MemberJoinEntity.MemberJoinType.KAKAO);

        this.kakaoMemberJoinImpl.kakaoJoin(this.kakaoMemberJoinEntity);
        this.kakaoMemberJoinImpl.join(memberJoinEntity);
    }
}
