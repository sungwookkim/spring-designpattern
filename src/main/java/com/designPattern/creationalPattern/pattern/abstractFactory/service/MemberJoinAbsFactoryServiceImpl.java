package com.designPattern.creationalPattern.pattern.abstractFactory.service;

import com.designPattern.creationalPattern.pattern.abstractFactory.process.DefaultMemberJoinAbsFactory;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.KakaoMemberJoinAbsFactory;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.MemberJoinAbsFactory;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.join.MemberJoinAbsFactoryProcess;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.validate.MemberJoinValidateAbsFactoryProcess;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     회원가입 트랜잭션 처리 클래스
 * </pre>
 */
@Service
public class MemberJoinAbsFactoryServiceImpl {

    /**
     * <pre>
     *     회원가입 프로세스 트랜잭션 처리를 하는 메서드
     * </pre>
     *
     * @param memberJoinAbsFactory 회원가입 추상 팩토리
     * @param joinEntity 회원가입 처리에 필요한 엔티티
     * @param <T>  회원가입에 유형에 따른 회원정보 엔티티 타입
     */
    public <T> void join(MemberJoinAbsFactory memberJoinAbsFactory, T joinEntity) {
        MemberJoinAbsFactoryProcess memberJoinAbsFactoryProcess = memberJoinAbsFactory.createMemberJoin(joinEntity);
        MemberJoinValidateAbsFactoryProcess memberJoinValidateAbsFactoryProcess = memberJoinAbsFactory.createMemberJoinValidate(joinEntity);

        memberJoinValidateAbsFactoryProcess.validate();
        memberJoinAbsFactoryProcess.join();
    }
}
