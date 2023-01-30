package com.designPattern.creationalPattern.repo.memberJoin.factory;

import com.designPattern.creationalPattern.repo.memberJoin.KakaoMemberJoin;
import com.designPattern.creationalPattern.repo.memberJoin.MemberJoin;
import com.designPattern.creationalPattern.repo.memberJoin.read.KakaoMemberJoinRead;
import com.designPattern.creationalPattern.repo.memberJoin.read.MemberJoinRead;
import com.designPattern.creationalPattern.repo.memberJoin.read.test.KakaoMemberJoinReadImpl;
import com.designPattern.creationalPattern.repo.memberJoin.read.test.MemberJoinReadImpl;
import com.designPattern.creationalPattern.repo.memberJoin.test.KakaoMemberJoinImpl;
import com.designPattern.creationalPattern.repo.memberJoin.test.MemberJoinImpl;
import com.designPattern.creationalPattern.repo.memberJoin.write.KakaoMemberJoinWrite;
import com.designPattern.creationalPattern.repo.memberJoin.write.MemberJoinWrite;
import com.designPattern.creationalPattern.repo.memberJoin.write.test.KakaoMemberJoinWriteImpl;
import com.designPattern.creationalPattern.repo.memberJoin.write.test.MemberJoinWriteImpl;
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

    MemberJoinFactory(MemberJoin memberJoinImpl
            , MemberJoinWrite memberJoinWriteImpl
            , MemberJoinRead memberJoinReadImpl
            , KakaoMemberJoin kakaoMemberJoinImpl
            , KakaoMemberJoinWrite kakaoMemberJoinWriteImpl
            , KakaoMemberJoinRead kakaoMemberJoinReadImpl) {

        instance.put(MemberJoinImpl.class.getSimpleName(), memberJoinImpl);
        instance.put(MemberJoinWriteImpl.class.getSimpleName(), memberJoinWriteImpl);
        instance.put(MemberJoinReadImpl.class.getSimpleName(), memberJoinReadImpl);

        instance.put(KakaoMemberJoinImpl.class.getSimpleName(), kakaoMemberJoinImpl);
        instance.put(KakaoMemberJoinWriteImpl.class.getSimpleName(), kakaoMemberJoinWriteImpl);
        instance.put(KakaoMemberJoinReadImpl.class.getSimpleName(), kakaoMemberJoinReadImpl);

    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz) {
        return Optional.ofNullable((T) instance.get(clazz.getSimpleName()))
                .orElseThrow(() -> new IllegalArgumentException("지원되지 않는 타입입니다."));
    }
}
