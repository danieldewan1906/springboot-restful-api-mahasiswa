package com.testing.projectspring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "mahasiswa")
public class Mahasiswa implements Serializable {

    @Id
    @Column(name = "nim", nullable = false, unique = true, length = 10)
    private String nim;

    @Column(name = "mahasiswa_name", nullable = false, unique = true)
    private String mahasiswaName;

    @Column(name = "semester", nullable = false, columnDefinition = "integer default 1")
    private Integer semester = 1;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date();
}
