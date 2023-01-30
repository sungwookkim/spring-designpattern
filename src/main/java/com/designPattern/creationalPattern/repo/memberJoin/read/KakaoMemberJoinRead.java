package com.designPattern.creationalPattern.repo.memberJoin.read;

import com.designPattern.creationalPattern.entity.KakaoMemberJoinEntity;

public interface KakaoMemberJoinRead {

    KakaoMemberJoinEntity findKakaoMember(String email);
}
