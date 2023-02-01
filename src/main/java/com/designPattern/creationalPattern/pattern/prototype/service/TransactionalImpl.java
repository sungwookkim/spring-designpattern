package com.designPattern.creationalPattern.pattern.prototype.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

/**
 * <pre>
 *     트랜잭션을 관리하는 클래스
 * </pre>
 */
@Component
public class TransactionalImpl {

    /**
     * <pre>
     *     반환이 없는 트랜잭션 처리
     * </pre>
     *
     * @param runnable 트랜잭션 처리를 위한 프로세스
     */
    @Transactional(rollbackFor = Exception.class)
    public void exec(Runnable runnable) {
        runnable.run();
    }

    /**
     * <pre>
     *     반환이 있는 트랜잭션 처리
     * </pre>
     *
     * @param supplier 반환 값이 존재하는 프로세스
     * @return 프로세스에서 반환 하는 값
     * @param <T> 프로세스마다 반환 하는 값이 다르므로 제네릭 타입으로 선언
     */
    @Transactional(rollbackFor = Exception.class)
    public <T> T exec(Supplier<T> supplier) {
        return supplier.get();
    }

    /**
     * <pre>
     *     {@link TransactionalImpl}선언을 최소화 하기 위한 편의 싱글톤 클래스
     * </pre>
     */
    @Component
    public static class Singleton {
        private static TransactionalImpl TRANSACTIONAL_IMPL;

        Singleton(TransactionalImpl transactionalImpl) {
            TRANSACTIONAL_IMPL = transactionalImpl;
        }

        public static void exec(Runnable runnable) {
            TRANSACTIONAL_IMPL.exec(runnable);
        }

        public static <T> T exec(Supplier<T> supplier) {
            return TRANSACTIONAL_IMPL.exec(supplier);
        }
    }
}
