package com.testing.projectspring.repository;

import com.testing.projectspring.model.entity.Dosen;
import com.testing.projectspring.model.entity.MataKuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface DosenRepository extends JpaRepository<Dosen, String> {

    @Query(
            value = "SELECT d.*, mk.matkul_code, mk.matkul_name, mk.capacity FROM dosen d LEFT JOIN mata_kuliah mk ON mk.nid = d.nid WHERE d.nid = :nid",
            nativeQuery = true
    )
    List<Dosen> getDosenByNid(@Param("nid") String nid);
}
