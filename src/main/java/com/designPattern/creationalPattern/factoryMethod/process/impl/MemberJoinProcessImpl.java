package com.designPattern.creationalPattern.factoryMethod.process.impl;

import com.designPattern.creationalPattern.factoryMethod.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.factoryMethod.process.MemberJoinProcess;
import com.designPattern.creationalPattern.factoryMethod.repo.MemberJoin;

/**
 * <pre>
 *     기본 회원가입 처리 프로세스 클래스
 * </pre>
 */
public class MemberJoinProcessImpl implements MemberJoinProcess {
    private final MemberJoin memberJoinImpl;
    private final MemberJoinEntity memberJoinEntity;

    public MemberJoinProcessImpl(MemberJoin memberJoinImpl, MemberJoinEntity memberJoinEntity) {
        this.memberJoinImpl = memberJoinImpl;
        this.memberJoinEntity = memberJoinEntity;
    }

    /**
     * {@link MemberJoinProcess#join()}
     */
    @Override
    public void join() {
        this.memberJoinImpl.join(memberJoinEntity);
    }
}
