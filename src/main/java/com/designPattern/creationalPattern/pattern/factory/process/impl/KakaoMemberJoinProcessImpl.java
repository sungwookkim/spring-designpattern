package com.designPattern.creationalPattern.pattern.factory.process.impl;

import com.designPattern.creationalPattern.pattern.factory.process.MemberJoinProcess;
import com.designPattern.creationalPattern.pattern.factory.repo.MemberJoinFactory;
import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.repo.test.KakaoMemberJoinImpl;

import java.util.UUID;

/**
 * <pre>
 *     카카오톡 회원가입 처리 프로세스 클래스
 * </pre>
 */
public class KakaoMemberJoinProcessImpl implements MemberJoinProcess {
    private final KakaoMemberJoinEntity kakaoMemberJoinEntity;

    public KakaoMemberJoinProcessImpl(KakaoMemberJoinEntity kakaoMemberJoinEntity) {
        this.kakaoMemberJoinEntity = kakaoMemberJoinEntity;
    }

    /**
     * {@link MemberJoinProcess#join()}
     * 카카오톡 회원가입인 경우엔 응답 받은 카카오톡 전문에서 특정 데이터만 추출하여
     * 기본 회원가입 처리도 동시 처리 진행한다.
     */
    @Override
    public void join() {
        KakaoMemberJoinImpl kakaoMemberJoinImpl = MemberJoinFactory.getInstance(KakaoMemberJoinImpl.class);

        MemberJoinEntity memberJoinEntity = new MemberJoinEntity(this.kakaoMemberJoinEntity.getKakaoAccountEmail()
                , UUID.randomUUID().toString().replace("-", "").substring(0, 10)
                , MemberJoinEntity.MemberJoinType.KAKAO);

        kakaoMemberJoinImpl.kakaoJoin(this.kakaoMemberJoinEntity);
        kakaoMemberJoinImpl.join(memberJoinEntity);
    }
}
