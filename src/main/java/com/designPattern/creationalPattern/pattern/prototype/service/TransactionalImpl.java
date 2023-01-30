package com.designPattern.creationalPattern.pattern.prototype.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Component
public class TransactionalImpl {

    @Transactional(rollbackFor = Exception.class)
    public void exec(Runnable runnable) {
        runnable.run();
    }

    @Transactional(rollbackFor = Exception.class)
    public <T> T exec(Supplier<T> supplier) {
        return supplier.get();
    }

    @Component
    public static class Singleton {
        private static TransactionalImpl TRANSACTIONALIMPL;

        Singleton(TransactionalImpl transactionalImpl) {
            TRANSACTIONALIMPL = transactionalImpl;
        }

        public static void exec(Runnable runnable) {
            TRANSACTIONALIMPL.exec(runnable);
        }

        public static <T> T exec(Supplier<T> supplier) {
            return TRANSACTIONALIMPL.exec(supplier);
        }
    }
}
