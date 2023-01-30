package com.designPattern.creationalPattern.abstractFactory;

import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.DefaultMemberJoinAbsFactory;
import com.designPattern.creationalPattern.pattern.abstractFactory.process.KakaoMemberJoinAbsFactory;
import com.designPattern.creationalPattern.pattern.abstractFactory.service.MemberJoinAbsFactoryServiceImpl;
import com.designPattern.creationalPattern.pattern.factory.service.MemberJoinFactoryExampleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class AbstractFactoryPatternTests {
	@Autowired
	MemberJoinAbsFactoryServiceImpl memberJoinAbsFactoryServiceImpl;

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

		this.memberJoinAbsFactoryServiceImpl.join(new KakaoMemberJoinAbsFactory(), kakaoMemberJoinEntity);
	}

	@Test
	void 카카오톡_회원가입_예외() {
		KakaoMemberJoinEntity kakaoMemberJoinEntity = new KakaoMemberJoinEntity(13248627872L
				, LocalDateTime.now()
				, true
				, false
				, true
				, true
				, "test@kakao.com"
		);

		this.memberJoinAbsFactoryServiceImpl.join(new KakaoMemberJoinAbsFactory(), kakaoMemberJoinEntity);

		Assertions.assertThrows(IllegalStateException.class, () -> {
			this.memberJoinAbsFactoryServiceImpl.join(new KakaoMemberJoinAbsFactory(), kakaoMemberJoinEntity);
		});
	}

	@Test
	void 일반_회원가입() {
		MemberJoinEntity memberJoinEntity = new MemberJoinEntity(UUID.randomUUID().toString().replace("-", "").substring(0, 5)
				, UUID.randomUUID().toString().replace("-", "").substring(0, 10)
				, MemberJoinEntity.MemberJoinType.DEFAULT);

		this.memberJoinAbsFactoryServiceImpl.join(new DefaultMemberJoinAbsFactory(), memberJoinEntity);
	}

	@Test
	void 일반_회원가입_예외() {
		MemberJoinEntity memberJoinEntity = new MemberJoinEntity(UUID.randomUUID().toString().replace("-", "").substring(0, 5)
				, UUID.randomUUID().toString().replace("-", "").substring(0, 10)
				, MemberJoinEntity.MemberJoinType.DEFAULT);

		this.memberJoinAbsFactoryServiceImpl.join(new DefaultMemberJoinAbsFactory(), memberJoinEntity);

		Assertions.assertThrows(IllegalStateException.class, () -> {
			this.memberJoinAbsFactoryServiceImpl.join(new DefaultMemberJoinAbsFactory(), memberJoinEntity);
		});
	}
}
