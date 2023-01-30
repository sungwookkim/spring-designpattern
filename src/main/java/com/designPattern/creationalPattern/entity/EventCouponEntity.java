package com.designPattern.creationalPattern.entity;

import java.time.LocalDateTime;

public class EventCouponEntity {
    private final String id;
    private final String eventCode;
    private final LocalDateTime eventStartDate;
    private final LocalDateTime eventEndDate;

    public EventCouponEntity(String id, String eventCode, LocalDateTime eventStartDate, LocalDateTime eventEndDate) {
        this.id = id;
        this.eventCode = eventCode;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }

    public static EventCouponEntity defaultEventCoupon(String id) {
        LocalDateTime now = LocalDateTime.now();

        return new EventCouponEntity(id, "", now, now);
    }

    public static EventCouponEntity testEventCoupon(String id) {
        LocalDateTime now = LocalDateTime.now();

        return new EventCouponEntity(id, "TEST", now, now);
    }

    public String getId() {
        return id;
    }

    public String getEventCode() {
        return eventCode;
    }

    public LocalDateTime getEventStartDate() {
        return eventStartDate;
    }

    public LocalDateTime getEventEndDate() {
        return eventEndDate;
    }
}
