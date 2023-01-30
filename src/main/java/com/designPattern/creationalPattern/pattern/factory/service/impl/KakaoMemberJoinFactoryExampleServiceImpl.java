package com.designPattern.creationalPattern.pattern.factory.service.impl;

import com.designPattern.creationalPattern.pattern.factory.repo.process.MemberJoinProcess;
import com.designPattern.creationalPattern.pattern.factory.repo.process.impl.KakaoMemberJoinProcessImpl;
import com.designPattern.creationalPattern.pattern.factory.service.MemberJoinFactoryExampleService;
import com.designPattern.creationalPattern.pattern.factory.service.abs.MemberJoinFactoryExampleServiceAbs;
import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     카카오톡 회원가입 팩토리 메서드 패턴 하위 클래스
 * </pre>
 */
@Service
public class KakaoMemberJoinFactoryExampleServiceImpl extends MemberJoinFactoryExampleServiceAbs implements MemberJoinFactoryExampleService {

    /**
     * <pre>
     *     {@link MemberJoinFactoryExampleService#join(Object)}
     * </pre>
     *
     * @param joinEntity 전달 받은 객체를 {@link KakaoMemberJoinEntity}로 형변환.
     * @param <T> {@link KakaoMemberJoinEntity} 타입
     * @return 기본 회원가입 처리를 하는 {@link KakaoMemberJoinProcessImpl} 구현체 반환
     */
    @Override
    protected <T> MemberJoinProcess createMemberJoin(T joinEntity) {
        return new KakaoMemberJoinProcessImpl((KakaoMemberJoinEntity) joinEntity);
    }
}
