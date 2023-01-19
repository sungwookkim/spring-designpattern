package com.designPattern.creationalPattern.entity;

/**
 * <pre>
 *     기본 회원가입 엔티티
 * </pre>
 */
public class MemberJoinEntity {
    private final String memberId;
    private final String password;

    private final MemberJoinType memberJoinType;

    public MemberJoinEntity(String memberId, String password, MemberJoinType memberJoinType) {
        this.memberId = memberId;
        this.password = password;
        this.memberJoinType = memberJoinType;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getPassword() {
        return password;
    }

    public MemberJoinType getMemberJoinType() {
        return memberJoinType;
    }

    /**
     * <pre>
     *     회원 가입 종류 Enum
     * </pre>
     */
    public enum MemberJoinType {
        KAKAO("Kakao")
        , DEFAULT("Default");

        private final String type;

        MemberJoinType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
