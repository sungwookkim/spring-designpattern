package com.designPattern.creationalPattern.pattern.abstractFactory.process;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.join.MemberJoinAbsFactoryProcess;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.join.impl.MemberJoinAbsFactoryProcessImpl;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.validate.MemberJoinValidateAbsFactoryProcess;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.validate.impl.MemberJoinValidateAbsFactoryProcessImpl;

/**
 * <pre>
 *     기본 회원가입 추상 팩토리 클래스
 * </pre>
 */
public class DefaultMemberJoinAbsFactory implements MemberJoinAbsFactory {

    /**
     * <pre>
     *     {@link MemberJoinAbsFactory#createMemberJoin(Object)}
     * </pre>
     */
    @Override
    public <T> MemberJoinAbsFactoryProcess createMemberJoin(T joinEntity) {
        return new MemberJoinAbsFactoryProcessImpl((MemberJoinEntity)joinEntity);
    }

    /**
     * <pre>
     *     {@link MemberJoinAbsFactory#createMemberJoinValidate(Object)}
     * </pre>
     */
    @Override
    public <T> MemberJoinValidateAbsFactoryProcess createMemberJoinValidate(T validateEntity) {
        return new MemberJoinValidateAbsFactoryProcessImpl((MemberJoinEntity) validateEntity);
    }
}
