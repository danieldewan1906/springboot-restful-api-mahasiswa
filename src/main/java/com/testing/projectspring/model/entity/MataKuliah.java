package com.testing.projectspring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "mata_kuliah")
public class MataKuliah implements Serializable {

    @Id
    @Column(name = "matkul_code", nullable = false, unique = true, length = 10)
    private String matkulCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nid")
    private Dosen nid;

    @Column(name = "matkul_name", nullable = false)
    private String matkulName;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "capacity", nullable = false)
    private Integer capacity = 1;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date();
}
