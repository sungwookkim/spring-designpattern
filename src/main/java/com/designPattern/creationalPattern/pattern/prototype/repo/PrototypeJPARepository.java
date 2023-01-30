package com.designPattern.creationalPattern.pattern.prototype.repo;


import com.designPattern.creationalPattern.pattern.prototype.entity.PrototypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrototypeJPARepository extends JpaRepository<PrototypeEntity, String>, PrototypeRepository {

}
