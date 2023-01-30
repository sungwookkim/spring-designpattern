package com.designPattern.creationalPattern.repo.memberJoin.read;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;

public interface MemberJoinRead {

    MemberJoinEntity findMember(String id);
}
