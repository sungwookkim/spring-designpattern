package com.designPattern.creationalPattern.pattern.builder.service;

import com.designPattern.creationalPattern.pattern.builder.process.MemberJoinBuilder;
import com.designPattern.creationalPattern.pattern.builder.process.event.MemberJoinEventBuilderProcess;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <pre>
 *     빌더 패턴을 활용한 회원가입 프로세스 클래스
 * </pre>
 */
@Service
public class MemberJoinBuilderServiceImpl {

    /**
     * <pre>
     *     회원가입 프로세스 트랜잭션 처리 메서드
     * </pre>
     *
     * @param memberJoinBuilder 회원가입 프로세스 빌더 클래스
     */
    public void join(MemberJoinBuilder memberJoinBuilder) {

        memberJoinBuilder.getMemberJoinValidateBuilderProcess().validate();
        memberJoinBuilder.getMemberJoinBuilderProcess().join();

        Optional.ofNullable(memberJoinBuilder.getMemberJoinEventBuilderProcess())
                .ifPresent(MemberJoinEventBuilderProcess::event);
    }
}
