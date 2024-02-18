package com.testing.projectspring.repository;

import com.testing.projectspring.model.entity.MataKuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MataKuliahRepository extends JpaRepository<MataKuliah, String> {

    @Query(
            value = "SELECT * FROM mata_kuliah WHERE nid = :nid",
            nativeQuery = true
    )
    List<MataKuliah> findByNid(@Param("nid") String nid);
}
