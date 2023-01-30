package com.designPattern.creationalPattern.pattern.builder.process.validate.impl;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.builder.process.validate.MemberJoinValidateBuilderProcess;
import com.designPattern.creationalPattern.repo.memberJoin.factory.MemberJoinFactory;
import com.designPattern.creationalPattern.repo.memberJoin.read.test.MemberJoinReadImpl;

/**
 * <pre>
 *     기본 회원가입 예외 검증 구현체
 * </pre>
 */
public class MemberJoinValidateBuilderProcessImpl implements MemberJoinValidateBuilderProcess {

    private final MemberJoinEntity memberJoinEntity;

    public MemberJoinValidateBuilderProcessImpl(MemberJoinEntity memberJoinEntity) {
        this.memberJoinEntity = memberJoinEntity;
    }

    /**
     * <pre>
     *     {@link MemberJoinValidateBuilderProcess#validate()}
     * </pre>
     */
    @Override
    public void validate() {
        MemberJoinEntity findMemberJoinEntity = MemberJoinFactory.getInstance(MemberJoinReadImpl.class)
                .findMember(this.memberJoinEntity.getMemberId());

        if(!"".equals(findMemberJoinEntity.getMemberId())) {
            throw new IllegalStateException("존재하는 회원 입니다.");
        }
    }
}
