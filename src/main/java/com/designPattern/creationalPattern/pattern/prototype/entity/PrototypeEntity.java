package com.designPattern.creationalPattern.pattern.prototype.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "prototype")
public class PrototypeEntity {
    @Id
    private String code;

    public PrototypeEntity() {
    }

    public PrototypeEntity(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
