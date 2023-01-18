package com.designPattern.creationalPattern.factoryMethod.entity;

import java.time.LocalDateTime;

/**
 *  <pre>
 *      카카오톡 회원가입 엔티티
 *  </pre>
 */
public class KakaoMemberJoinEntity {
    private final long id;
    private final LocalDateTime connectedAt;
    private final boolean kakaoAccountHasEmail;
    private final boolean kakaoAccountEmailNeedsAgreement;
    private final boolean kakaoAccountIsEmailValid;
    private final boolean kakaoAccountIsEmailVerified;
    private final String kakaoAccountEmail;

    public KakaoMemberJoinEntity(long id
            , LocalDateTime connectedAt
            , boolean kakaoAccountHasEmail
            , boolean kakaoAccountEmailNeedsAgreement
            , boolean kakaoAccountIsEmailValid
            , boolean kakaoAccountIsEmailVerified
            , String kakaoAccountEmail) {
        this.id = id;
        this.connectedAt = connectedAt;
        this.kakaoAccountHasEmail = kakaoAccountHasEmail;
        this.kakaoAccountEmailNeedsAgreement = kakaoAccountEmailNeedsAgreement;
        this.kakaoAccountIsEmailValid = kakaoAccountIsEmailValid;
        this.kakaoAccountIsEmailVerified = kakaoAccountIsEmailVerified;
        this.kakaoAccountEmail = kakaoAccountEmail;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getConnectedAt() {
        return connectedAt;
    }

    public boolean isKakaoAccountHasEmail() {
        return kakaoAccountHasEmail;
    }

    public boolean isKakaoAccountEmailNeedsAgreement() {
        return kakaoAccountEmailNeedsAgreement;
    }

    public boolean isKakaoAccountIsEmailValid() {
        return kakaoAccountIsEmailValid;
    }

    public boolean isKakaoAccountIsEmailVerified() {
        return kakaoAccountIsEmailVerified;
    }

    public String getKakaoAccountEmail() {
        return kakaoAccountEmail;
    }
}
