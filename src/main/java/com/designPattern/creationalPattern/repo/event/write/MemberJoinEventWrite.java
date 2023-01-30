package com.designPattern.creationalPattern.repo.event.write;

import com.designPattern.creationalPattern.entity.EventCouponEntity;

public interface MemberJoinEventWrite {
    void saveMemberJoinEvent(EventCouponEntity eventCouponEntity);
}
