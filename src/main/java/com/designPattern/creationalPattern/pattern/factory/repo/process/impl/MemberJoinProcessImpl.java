package com.designPattern.creationalPattern.pattern.factory.repo.process.impl;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.factory.repo.process.MemberJoinProcess;
import com.designPattern.creationalPattern.repo.memberJoin.factory.MemberJoinFactory;
import com.designPattern.creationalPattern.repo.memberJoin.test.MemberJoinImpl;

/**
 * <pre>
 *     기본 회원가입 처리 프로세스 클래스
 * </pre>
 */
public class MemberJoinProcessImpl implements MemberJoinProcess {
    private final MemberJoinEntity memberJoinEntity;

    public MemberJoinProcessImpl(MemberJoinEntity memberJoinEntity) {
        this.memberJoinEntity = memberJoinEntity;
    }

    /**
     * {@link MemberJoinProcess#join()}
     */
    @Override
    public void join() {
        MemberJoinFactory.getInstance(MemberJoinImpl.class)
                .join(memberJoinEntity);
    }
}
