package com.designPattern.creationalPattern.pattern.factory.repo;

import com.designPattern.creationalPattern.repo.KakaoMemberJoin;
import com.designPattern.creationalPattern.repo.MemberJoin;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <pre>
 *     회원가입 관련 Repo 팩토리 클래스
 * </pre>
 */
@Component
public class MemberJoinFactory {
    private static final Map<String, Object> instance = new HashMap<>();

    MemberJoinFactory(MemberJoin memberJoinImpl, KakaoMemberJoin kakaoMemberJoinImpl) {
        instance.put(memberJoinImpl.getClass().getSimpleName(), memberJoinImpl);
        instance.put(kakaoMemberJoinImpl.getClass().getSimpleName(), kakaoMemberJoinImpl);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz) {
        return Optional.ofNullable((T) instance.get(clazz.getSimpleName()))
                .orElseThrow(() -> new IllegalArgumentException("지원되지 않는 타입입니다."));
    }
}
