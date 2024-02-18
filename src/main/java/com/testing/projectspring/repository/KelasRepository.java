package com.testing.projectspring.repository;

import com.testing.projectspring.model.entity.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, String> {
}
