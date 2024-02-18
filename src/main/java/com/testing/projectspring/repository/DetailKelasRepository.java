package com.testing.projectspring.repository;

import com.testing.projectspring.model.entity.DetailKelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailKelasRepository extends JpaRepository<DetailKelas, Integer> {
}
