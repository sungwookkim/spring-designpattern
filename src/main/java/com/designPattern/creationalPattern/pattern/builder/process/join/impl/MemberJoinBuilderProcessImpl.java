package com.designPattern.creationalPattern.pattern.builder.process.join.impl;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.builder.process.join.MemberJoinBuilderProcess;
import com.designPattern.creationalPattern.repo.memberJoin.factory.MemberJoinFactory;
import com.designPattern.creationalPattern.repo.memberJoin.write.test.MemberJoinWriteImpl;

/**
 * <pre>
 *     기본 회원가입 처리 프로세스 클래스
 * </pre>
 */
public class MemberJoinBuilderProcessImpl implements MemberJoinBuilderProcess {

    private final MemberJoinEntity memberJoinEntity;

    public MemberJoinBuilderProcessImpl(MemberJoinEntity memberJoinEntity) {
        this.memberJoinEntity = memberJoinEntity;
    }

    /**
     * {@link MemberJoinBuilderProcess#join()}
     */
    @Override
    public void join() {
        MemberJoinFactory.getInstance(MemberJoinWriteImpl.class)
                .join(memberJoinEntity);
    }
}
