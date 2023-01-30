package com.designPattern.creationalPattern.repo.memberJoin.write.test;

import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.repo.memberJoin.write.KakaoMemberJoinWrite;
import com.designPattern.creationalPattern.repo.memberJoin.write.MemberJoinWrite;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     카카오톡으로 가입하는 회원 정보를 테스트 용으로 다루기 위한 클래스
 *     해당 클래스는 테스트이기 때문에 변수에 저장
 * </pre>
 */
@Repository
public class KakaoMemberJoinWriteImpl implements KakaoMemberJoinWrite {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final List<KakaoMemberJoinEntity> memberJoinEntities = new ArrayList<>();
    private final MemberJoinWrite memberJoinWriteImpl;

    public KakaoMemberJoinWriteImpl(MemberJoinWrite memberJoinWriteImpl) {
        this.memberJoinWriteImpl = memberJoinWriteImpl;
    }

    /**
     * <pre>
     *     {@link KakaoMemberJoinWrite#kakaoJoin(KakaoMemberJoinEntity)}
     * </pre>
     *
     * @param kakaoMemberJoinEntity 카카오톡 회원정보 엔티티
     */
    @Override
    public void kakaoJoin(KakaoMemberJoinEntity kakaoMemberJoinEntity) {
        this.memberJoinEntities.add(kakaoMemberJoinEntity);
        logger.info("kakaoJoin : {}", this);
    }

    /**
     * <pre>
     *     {@link MemberJoinWrite#join(MemberJoinEntity)}
     * </pre>
     *
     * @param memberJoinEntity 기본 회원정보 엔티티
     */
    @Override
    public void join(MemberJoinEntity memberJoinEntity) {
        this.memberJoinWriteImpl.join(memberJoinEntity);
    }

    public List<KakaoMemberJoinEntity> getMemberJoinEntities() {
        return memberJoinEntities;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(this.memberJoinEntities);
        } catch (Exception e) {
            return this.memberJoinEntities.toString();
        }
    }
}
