package com.designPattern.creationalPattern.pattern.prototype.repo;


import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 *     JPA 사용 코드 인터페이스
 * </pre>
 */
@Repository
public interface PrototypeJPARepository extends JpaRepository<PrototypeEntity, String>, PrototypeRepository {

}
