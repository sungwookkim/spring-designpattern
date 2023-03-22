package com.designPattern.creationalPattern.pattern.builder.process;

import com.designPattern.creationalPattern.pattern.builder.process.event.MemberJoinEventBuilderProcess;
import com.designPattern.creationalPattern.pattern.builder.process.join.MemberJoinBuilderProcess;
import com.designPattern.creationalPattern.pattern.builder.process.validate.MemberJoinValidateBuilderProcess;

/**
 * <pre>
 *     회원가입 프로세스 빌더 패턴 클래스
 * </pre>
 */
public class MemberJoinBuilder {

    private final MemberJoinBuilderProcess memberJoinBuilderProcess;

    private final MemberJoinValidateBuilderProcess memberJoinValidateBuilderProcess;

    private final MemberJoinEventBuilderProcess memberJoinEventBuilderProcess;

    MemberJoinBuilder(MemberJoinBuilder.Builder builder) {
        this.memberJoinBuilderProcess = builder.memberJoinBuilderProcess;
        this.memberJoinValidateBuilderProcess = builder.memberJoinValidateBuilderProcess;
        this.memberJoinEventBuilderProcess = builder.memberJoinEventBuilderProcess;
    }

    public MemberJoinBuilderProcess getMemberJoinBuilderProcess() {
        return memberJoinBuilderProcess;
    }

    public MemberJoinValidateBuilderProcess getMemberJoinValidateBuilderProcess() {
        return memberJoinValidateBuilderProcess;
    }

    public MemberJoinEventBuilderProcess getMemberJoinEventBuilderProcess() {
        return memberJoinEventBuilderProcess;
    }

    /**
     * <pre>
     *     회원가입과 관련된 프로세스 구현체를 담당하는 빌더 패턴 클래스
     * </pre>
     */
    public static class Builder {
        // 이벤트 객체 미 초기화 시 기본으로 사용할 객체 설정 용도.
        private final static MemberJoinEventBuilderProcess DEFAULT_EVENT_CALL = () -> {};

        private final MemberJoinBuilderProcess memberJoinBuilderProcess;

        private final MemberJoinValidateBuilderProcess memberJoinValidateBuilderProcess;

        private MemberJoinEventBuilderProcess memberJoinEventBuilderProcess = DEFAULT_EVENT_CALL;

        public Builder(MemberJoinBuilderProcess memberJoinBuilderProcess
                , MemberJoinValidateBuilderProcess memberJoinValidateBuilderProcess) {

            this.memberJoinBuilderProcess = memberJoinBuilderProcess;
            this.memberJoinValidateBuilderProcess = memberJoinValidateBuilderProcess;
        }

        public MemberJoinBuilder.Builder memberJoinEventProcess(MemberJoinEventBuilderProcess memberJoinEventBuilderProcess) {
            this.memberJoinEventBuilderProcess = memberJoinEventBuilderProcess;

            return this;
        }

        public MemberJoinBuilder builder() {
            return new MemberJoinBuilder(this);
        }
    }
}
