package com.designPattern.creationalPattern.pattern.abstractFactory.process;

import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.join.MemberJoinAbsFactoryProcess;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.join.impl.KakaoMemberJoinAbsFactoryProcessImpl;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.validate.MemberJoinValidateAbsFactoryProcess;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.validate.impl.KakaoMemberJoinValidateAbsFactoryProcessImpl;

/**
 * <pre>
 *     카카오톡 회원가입 추상 팩토리 클래스
 * </pre>
 */
public class KakaoMemberJoinAbsFactory implements MemberJoinAbsFactory {

    /**
     * <pre>
     *     {@link MemberJoinAbsFactory#createMemberJoin(Object)}
     * </pre>
     */
    @Override
    public <T> MemberJoinAbsFactoryProcess createMemberJoin(T joinEntity) {
        return new KakaoMemberJoinAbsFactoryProcessImpl((KakaoMemberJoinEntity) joinEntity);
    }

    /**
     * <pre>
     *     {@link MemberJoinAbsFactory#createMemberJoinValidate(Object)}
     * </pre>
     */
    @Override
    public <T> MemberJoinValidateAbsFactoryProcess createMemberJoinValidate(T validateEntity) {
        return new KakaoMemberJoinValidateAbsFactoryProcessImpl((KakaoMemberJoinEntity) validateEntity);
    }
}
