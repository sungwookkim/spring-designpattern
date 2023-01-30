package com.designPattern.creationalPattern.repo.memberJoin.read.test;

import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;
import com.designPattern.creationalPattern.repo.memberJoin.read.KakaoMemberJoinRead;
import com.designPattern.creationalPattern.repo.memberJoin.write.test.KakaoMemberJoinWriteImpl;
import org.springframework.stereotype.Repository;

@Repository
public class KakaoMemberJoinReadImpl implements KakaoMemberJoinRead {
    private final KakaoMemberJoinWriteImpl kakaoMemberJoinWriteImpl;

    public KakaoMemberJoinReadImpl(KakaoMemberJoinWriteImpl kakaoMemberJoinWriteImpl) {
        this.kakaoMemberJoinWriteImpl = kakaoMemberJoinWriteImpl;
    }

    @Override
    public KakaoMemberJoinEntity findKakaoMember(String email) {
        return this.kakaoMemberJoinWriteImpl.getMemberJoinEntities().stream()
                .filter(v -> email.equals(v.getKakaoAccountEmail()))
                .findAny()
                .orElse(KakaoMemberJoinEntity.defaultEntity());
    }
}
