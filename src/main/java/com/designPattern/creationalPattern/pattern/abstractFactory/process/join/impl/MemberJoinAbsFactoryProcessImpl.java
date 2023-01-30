package com.designPattern.creationalPattern.pattern.abstractFactory.process.join.impl;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.join.MemberJoinAbsFactoryProcess;
import com.designPattern.creationalPattern.repo.memberJoin.factory.MemberJoinFactory;
import com.designPattern.creationalPattern.repo.memberJoin.write.test.MemberJoinWriteImpl;

/**
 * <pre>
 *     기본 회원가입 처리 프로세스 클래스
 * </pre>
 */
public class MemberJoinAbsFactoryProcessImpl implements MemberJoinAbsFactoryProcess {
    private final MemberJoinEntity memberJoinEntity;

    public MemberJoinAbsFactoryProcessImpl(MemberJoinEntity memberJoinEntity) {
        this.memberJoinEntity = memberJoinEntity;
    }

    /**
     * {@link MemberJoinAbsFactoryProcess#join()}
     */
    @Override
    public void join() {
        MemberJoinFactory.getInstance(MemberJoinWriteImpl.class)
                .join(memberJoinEntity);
    }
}
