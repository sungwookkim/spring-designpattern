package com.designPattern.creationalPattern.factory;

import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.factory.service.MemberJoinFactoryExampleService;
import com.designPattern.creationalPattern.pattern.factoryMethod.service.MemberJoinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class FactoryPatternTests {
	@Autowired
	MemberJoinFactoryExampleService memberJoinFactoryExampleServiceImpl;

	@Autowired
	MemberJoinFactoryExampleService kakaoMemberJoinFactoryExampleServiceImpl;

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

		this.kakaoMemberJoinFactoryExampleServiceImpl.join(kakaoMemberJoinEntity);
	}

	@Test
	void 카카오톡_회원가입_다중() {
		for(int i = 0; i < 3; i++) {
			this.카카오톡_회원가입();
		}
	}

	@Test
	void 일반_회원가입() {
		MemberJoinEntity memberJoinEntity = new MemberJoinEntity(UUID.randomUUID().toString().replace("-", "").substring(0, 5)
				, UUID.randomUUID().toString().replace("-", "").substring(0, 10)
				, MemberJoinEntity.MemberJoinType.DEFAULT);

		this.memberJoinFactoryExampleServiceImpl.join(memberJoinEntity);
	}

	@Test
	void 일반_회원가입_다중() {
		for(int i = 0; i < 3; i++) {
			this.일반_회원가입();
		}
	}
}
