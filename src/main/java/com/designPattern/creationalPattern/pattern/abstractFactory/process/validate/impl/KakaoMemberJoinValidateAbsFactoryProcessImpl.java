package com.designPattern.creationalPattern.pattern.abstractFactory.process.validate.impl;

import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.validate.MemberJoinValidateAbsFactoryProcess;
import com.designPattern.creationalPattern.repo.memberJoin.factory.MemberJoinFactory;
import com.designPattern.creationalPattern.repo.memberJoin.read.test.KakaoMemberJoinReadImpl;

/**
 * <pre>
 *     카카오톡 회원가입 예외 검증 구현체
 * </pre>
 */
public class KakaoMemberJoinValidateAbsFactoryProcessImpl implements MemberJoinValidateAbsFactoryProcess {

    private final KakaoMemberJoinEntity kakaoMemberJoinEntity;

    public KakaoMemberJoinValidateAbsFactoryProcessImpl(KakaoMemberJoinEntity kakaoMemberJoinEntity) {
        this.kakaoMemberJoinEntity = kakaoMemberJoinEntity;
    }

    /**
     * <pre>
     *     {@link MemberJoinValidateAbsFactoryProcess#validate()}
     * </pre>
     */
    @Override
    public void validate() {
        KakaoMemberJoinEntity findKakaoMemberJoinEntity = MemberJoinFactory.getInstance(KakaoMemberJoinReadImpl.class)
                .findKakaoMember(this.kakaoMemberJoinEntity.getKakaoAccountEmail());

        if(findKakaoMemberJoinEntity.getId() != 0L) {
            throw new IllegalStateException("존재하는 회원 입니다.");
        }
    }
}
