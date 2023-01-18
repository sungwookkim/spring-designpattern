package com.designPattern.creationalPattern;

import com.designPattern.creationalPattern.factoryMethod.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.factoryMethod.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.factoryMethod.service.MemberJoinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class CreationalPatternTests {

	@Autowired
	MemberJoinService kakaoMemberJoinServiceImpl;

	@Autowired
	MemberJoinService memberJoinServiceImpl;

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

		this.kakaoMemberJoinServiceImpl.join(kakaoMemberJoinEntity);
	}

	@Test
	void 일반_회원가입() {
		MemberJoinEntity memberJoinEntity = new MemberJoinEntity(UUID.randomUUID().toString().replace("-", "").substring(0, 5)
			, UUID.randomUUID().toString().replace("-", "").substring(0, 10)
			, MemberJoinEntity.MemberJoinType.DEFAULT);

		this.memberJoinServiceImpl.join(memberJoinEntity);
	}
}
