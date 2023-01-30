package com.designPattern.creationalPattern.repo.event.read.test;

import com.designPattern.creationalPattern.entity.EventCouponEntity;
import com.designPattern.creationalPattern.repo.event.read.MemberJoinEventRead;
import com.designPattern.creationalPattern.repo.event.write.test.MemberJoinEventWriteImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemberJoinEventReadImpl implements MemberJoinEventRead {
    private final MemberJoinEventWriteImpl memberJoinEventWriteImpl;

    public MemberJoinEventReadImpl(MemberJoinEventWriteImpl memberJoinEventWriteImpl) {
        this.memberJoinEventWriteImpl = memberJoinEventWriteImpl;
    }

    @Override
    public List<EventCouponEntity> findMemberJoinEvents(String id) {
        return this.memberJoinEventWriteImpl.getEventCouponEntities().stream()
                .filter(v -> id.equals(v.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public EventCouponEntity findMemberJoinEvent(String id, String eventCode) {
        return this.memberJoinEventWriteImpl.getEventCouponEntities().stream()
                .filter(v -> id.equals(v.getId()) && eventCode.equals(v.getEventCode()))
                .findAny().orElse(EventCouponEntity.defaultEventCoupon(id));
    }
}
