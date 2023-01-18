package com.designPattern.creationalPattern.factoryMethod.repo.test;

import com.designPattern.creationalPattern.factoryMethod.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.factoryMethod.repo.MemberJoin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     기본으로 회원가입 정보를 테스트 용으로 다루기 위한 클래스
 *     해당 클래스는 테스트이기 때문에 변수에 저장
 * </pre>
 */
@Repository
public class MemberJoinImpl implements MemberJoin {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final List<MemberJoinEntity> memberJoinEntities = new ArrayList<>();

    /**
     * <pre>
     *     {@link MemberJoin#join(MemberJoinEntity)}
     * </pre>
     *
     * @param memberJoinEntity 기본 회원정보 엔티티
     */
    @Override
    public void join(MemberJoinEntity memberJoinEntity) {
        this.memberJoinEntities.add(memberJoinEntity);
        this.logger.info("defaultJoin : {}", this);
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this.memberJoinEntities);
        } catch (Exception e) {
            return this.memberJoinEntities.toString();
        }
    }
}
