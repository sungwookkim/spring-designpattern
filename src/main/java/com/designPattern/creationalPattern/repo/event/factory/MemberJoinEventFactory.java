package com.designPattern.creationalPattern.repo.event.factory;

import com.designPattern.creationalPattern.repo.event.read.MemberJoinEventRead;
import com.designPattern.creationalPattern.repo.event.read.test.MemberJoinEventReadImpl;
import com.designPattern.creationalPattern.repo.event.write.MemberJoinEventWrite;
import com.designPattern.creationalPattern.repo.event.write.test.MemberJoinEventWriteImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class MemberJoinEventFactory {
    private static final Map<String, Object> instance = new HashMap<>();

    MemberJoinEventFactory(MemberJoinEventWrite memberJoinEventWriteImpl
            , MemberJoinEventRead memberJoinEventReadImpl) {

        instance.put(MemberJoinEventWriteImpl.class.getSimpleName(), memberJoinEventWriteImpl);
        instance.put(MemberJoinEventReadImpl.class.getSimpleName(), memberJoinEventReadImpl);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz) {
        return Optional.ofNullable((T) instance.get(clazz.getSimpleName()))
                .orElseThrow(() -> new IllegalArgumentException("지원되지 않는 타입입니다."));
    }
}
