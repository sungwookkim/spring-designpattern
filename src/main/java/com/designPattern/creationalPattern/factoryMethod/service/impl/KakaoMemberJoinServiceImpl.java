package com.designPattern.creationalPattern.factoryMethod.service.impl;

import com.designPattern.creationalPattern.factoryMethod.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.factoryMethod.process.MemberJoinProcess;
import com.designPattern.creationalPattern.factoryMethod.process.impl.KakaoMemberJoinProcessImpl;
import com.designPattern.creationalPattern.factoryMethod.repo.KakaoMemberJoin;
import com.designPattern.creationalPattern.factoryMethod.service.MemberJoinService;
import com.designPattern.creationalPattern.factoryMethod.service.abs.MemberJoinServiceAbs;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     카카오톡 회원가입 팩토리 메서드 패턴 하위 클래스
 * </pre>
 */
@Service
public class KakaoMemberJoinServiceImpl extends MemberJoinServiceAbs implements MemberJoinService {
    private final KakaoMemberJoin kakaoMemberJoinImpl;

    public KakaoMemberJoinServiceImpl(KakaoMemberJoin kakaoMemberJoinImpl) {
        this.kakaoMemberJoinImpl = kakaoMemberJoinImpl;
    }

    /**
     * <pre>
     *     {@link MemberJoinService#join(Object)}
     * </pre>
     *
     * @param joinEntity 전달 받은 객체를 {@link KakaoMemberJoinEntity}로 형변환.
     * @param <T> {@link KakaoMemberJoinEntity} 타입
     * @return 기본 회원가입 처리를 하는 {@link KakaoMemberJoinProcessImpl} 구현체 반환
     */
    @Override
    protected <T> MemberJoinProcess createMemberJoin(T joinEntity) {
        return new KakaoMemberJoinProcessImpl(this.kakaoMemberJoinImpl, (KakaoMemberJoinEntity) joinEntity);
    }
}
