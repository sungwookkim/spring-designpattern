package com.designPattern.creationalPattern.pattern.builder.process.event.impl;

import com.designPattern.creationalPattern.entity.EventCouponEntity;
import com.designPattern.creationalPattern.pattern.builder.process.event.MemberJoinEventBuilderProcess;
import com.designPattern.creationalPattern.repo.event.factory.MemberJoinEventFactory;
import com.designPattern.creationalPattern.repo.event.read.test.MemberJoinEventReadImpl;
import com.designPattern.creationalPattern.repo.event.write.test.MemberJoinEventWriteImpl;

/**
 * <pre>
 *     카카오톡 회원가입 시 이벤트 프로세스 구현체
 * </pre>
 */
public class KakaoMemberJoinEventBuilderProcessImpl implements MemberJoinEventBuilderProcess {
    private final EventCouponEntity eventCouponEntity;

    public KakaoMemberJoinEventBuilderProcessImpl(EventCouponEntity eventCouponEntity) {
        this.eventCouponEntity = eventCouponEntity;
    }

    /**
     * <pre>
     *     {@link MemberJoinEventBuilderProcess#event()}
     *     카카오톡으로 회원가입 하는 경우 쿠폰 발급
     * </pre>
     */
    @Override
    public void event() {
        EventCouponEntity findEventCouponEntity = MemberJoinEventFactory.getInstance(MemberJoinEventReadImpl.class)
                .findMemberJoinEvent(this.eventCouponEntity.getId(), this.eventCouponEntity.getEventCode());

        if("".equals(findEventCouponEntity.getEventCode())) {
            MemberJoinEventFactory.getInstance(MemberJoinEventWriteImpl.class).saveMemberJoinEvent(this.eventCouponEntity);
        }
    }
}
