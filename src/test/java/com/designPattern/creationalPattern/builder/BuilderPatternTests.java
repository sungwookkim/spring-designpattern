package com.designPattern.creationalPattern.builder;

import com.designPattern.creationalPattern.entity.EventCouponEntity;
import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.builder.process.MemberJoinBuilder;
import com.designPattern.creationalPattern.pattern.builder.process.event.MemberJoinEventBuilderProcess;
import com.designPattern.creationalPattern.pattern.builder.process.event.impl.KakaoMemberJoinEventBuilderProcessImpl;
import com.designPattern.creationalPattern.pattern.builder.process.join.MemberJoinBuilderProcess;
import com.designPattern.creationalPattern.pattern.builder.process.join.impl.KakaoMemberJoinBuilderProcessImpl;
import com.designPattern.creationalPattern.pattern.builder.process.join.impl.MemberJoinBuilderProcessImpl;
import com.designPattern.creationalPattern.pattern.builder.process.validate.MemberJoinValidateBuilderProcess;
import com.designPattern.creationalPattern.pattern.builder.process.validate.impl.KakaoMemberJoinValidateBuilderProcessImpl;
import com.designPattern.creationalPattern.pattern.builder.process.validate.impl.MemberJoinValidateBuilderProcessImpl;
import com.designPattern.creationalPattern.pattern.builder.service.MemberJoinBuilderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class BuilderPatternTests {

    @Autowired
    MemberJoinBuilderServiceImpl memberJoinBuilderServiceImpl;

    @Test
    void 카카오톡_회원가입() {
        KakaoMemberJoinEntity kakaoMemberJoinEntity = new KakaoMemberJoinEntity(13248627872L
                , LocalDateTime.now()
                , true
                , false
                , true
                , true
                , "test@kakao.com"
        );

        MemberJoinBuilderProcess kakaoMemberJoinBuilderProcessImpl = new KakaoMemberJoinBuilderProcessImpl(kakaoMemberJoinEntity);
        MemberJoinValidateBuilderProcess kakaoMemberJoinValidateBuilderProcessImpl = new KakaoMemberJoinValidateBuilderProcessImpl(kakaoMemberJoinEntity);
        MemberJoinEventBuilderProcess kakaoMemberJoinEventBuilderProcessImpl = new KakaoMemberJoinEventBuilderProcessImpl(EventCouponEntity.testEventCoupon(String.valueOf(kakaoMemberJoinEntity.getId())));

        MemberJoinBuilder memberJoinBuilder = new MemberJoinBuilder.Builder(kakaoMemberJoinBuilderProcessImpl
                    , kakaoMemberJoinValidateBuilderProcessImpl)
                .memberJoinEventProcess(kakaoMemberJoinEventBuilderProcessImpl)
                .builder();

        this.memberJoinBuilderServiceImpl.join(memberJoinBuilder);
    }


    @Test
    void 일반_회원가입() {
        MemberJoinEntity memberJoinEntity = new MemberJoinEntity(UUID.randomUUID().toString().replace("-", "").substring(0, 5)
                , UUID.randomUUID().toString().replace("-", "").substring(0, 10)
                , MemberJoinEntity.MemberJoinType.DEFAULT);

        MemberJoinBuilderProcess memberJoinBuilderProcessImpl = new MemberJoinBuilderProcessImpl(memberJoinEntity);
        MemberJoinValidateBuilderProcess memberJoinValidateBuilderProcessImpl = new MemberJoinValidateBuilderProcessImpl(memberJoinEntity);

        MemberJoinBuilder memberJoinBuilder = new MemberJoinBuilder.Builder(memberJoinBuilderProcessImpl
                    , memberJoinValidateBuilderProcessImpl)
                .builder();

        this.memberJoinBuilderServiceImpl.join(memberJoinBuilder);
    }
}

