package com.designPattern.creationalPattern.repo.event.write.test;

import com.designPattern.creationalPattern.entity.EventCouponEntity;
import com.designPattern.creationalPattern.repo.event.write.MemberJoinEventWrite;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberJoinEventWriteImpl implements MemberJoinEventWrite {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final List<EventCouponEntity> eventCouponEntities = new ArrayList<>();

    @Override
    public void saveMemberJoinEvent(EventCouponEntity eventCouponEntity) {
        this.eventCouponEntities.add(eventCouponEntity);
        this.logger.info("Save Event Coupon : {}", this);
    }

    public List<EventCouponEntity> getEventCouponEntities() {
        return eventCouponEntities;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(this.eventCouponEntities);
        } catch (Exception e) {
            return this.eventCouponEntities.toString();
        }
    }
}
