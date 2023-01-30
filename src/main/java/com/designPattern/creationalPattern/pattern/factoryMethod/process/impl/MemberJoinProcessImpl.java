package com.designPattern.creationalPattern.pattern.factoryMethod.process.impl;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.factoryMethod.process.MemberJoinProcess;
import com.designPattern.creationalPattern.repo.memberJoin.MemberJoin;

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
