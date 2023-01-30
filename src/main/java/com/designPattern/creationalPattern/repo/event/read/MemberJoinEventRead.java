package com.designPattern.creationalPattern.repo.event.read;

import com.designPattern.creationalPattern.entity.EventCouponEntity;

import java.util.List;

public interface MemberJoinEventRead {
    List<EventCouponEntity> findMemberJoinEvents(String id);

    EventCouponEntity findMemberJoinEvent(String id, String eventCode);
}
