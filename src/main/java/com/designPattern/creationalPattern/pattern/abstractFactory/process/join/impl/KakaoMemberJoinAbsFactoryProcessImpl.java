package com.designPattern.creationalPattern.pattern.abstractFactory.process.join.impl;

import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.join.MemberJoinAbsFactoryProcess;
import com.designPattern.creationalPattern.repo.memberJoin.factory.MemberJoinFactory;
import com.designPattern.creationalPattern.repo.memberJoin.write.test.KakaoMemberJoinWriteImpl;

import java.util.UUID;

/**
 * <pre>
 *     카카오톡 회원가입 처리 프로세스 클래스
 * </pre>
 */
public class KakaoMemberJoinAbsFactoryProcessImpl implements MemberJoinAbsFactoryProcess {
    private final KakaoMemberJoinEntity kakaoMemberJoinEntity;

    public KakaoMemberJoinAbsFactoryProcessImpl(KakaoMemberJoinEntity kakaoMemberJoinEntity) {
        this.kakaoMemberJoinEntity = kakaoMemberJoinEntity;
    }

    /**
     * {@link MemberJoinAbsFactoryProcess#join()}
     * 카카오톡 회원가입인 경우엔 응답 받은 카카오톡 전문에서 특정 데이터만 추출하여
     * 기본 회원가입 처리도 동시 처리 진행한다.
     */
    @Override
    public void join() {
        KakaoMemberJoinWriteImpl kakaoMemberJoinWriteImpl = MemberJoinFactory.getInstance(KakaoMemberJoinWriteImpl.class);

        MemberJoinEntity memberJoinEntity = new MemberJoinEntity(this.kakaoMemberJoinEntity.getKakaoAccountEmail()
                , UUID.randomUUID().toString().replace("-", "").substring(0, 10)
                , MemberJoinEntity.MemberJoinType.KAKAO);

        kakaoMemberJoinWriteImpl.kakaoJoin(this.kakaoMemberJoinEntity);
        kakaoMemberJoinWriteImpl.join(memberJoinEntity);
    }
}
