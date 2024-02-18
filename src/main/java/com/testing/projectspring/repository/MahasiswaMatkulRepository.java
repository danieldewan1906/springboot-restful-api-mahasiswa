package com.testing.projectspring.repository;

import com.testing.projectspring.model.entity.MahasiswaMatkul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaMatkulRepository extends JpaRepository<MahasiswaMatkul, Integer> {
}
