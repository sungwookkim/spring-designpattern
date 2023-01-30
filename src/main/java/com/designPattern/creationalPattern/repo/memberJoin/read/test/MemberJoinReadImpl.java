package com.designPattern.creationalPattern.repo.memberJoin.read.test;

import com.designPattern.creationalPattern.entity.MemberJoinEntity;
import com.designPattern.creationalPattern.repo.memberJoin.read.MemberJoinRead;
import com.designPattern.creationalPattern.repo.memberJoin.write.test.MemberJoinWriteImpl;
import org.springframework.stereotype.Repository;

@Repository
public class MemberJoinReadImpl implements MemberJoinRead {
    private final MemberJoinWriteImpl memberJoinWriteImpl;

    public MemberJoinReadImpl(MemberJoinWriteImpl memberJoinWriteImpl) {
        this.memberJoinWriteImpl = memberJoinWriteImpl;
    }

    @Override
    public MemberJoinEntity findMember(String id) {
        return this.memberJoinWriteImpl.getMemberJoinEntities().stream()
                .filter(v -> id.equals(v.getMemberId()))
                .findAny().orElse(MemberJoinEntity.defaultEntity());
    }
}
