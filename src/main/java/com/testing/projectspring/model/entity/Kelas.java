package com.testing.projectspring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "kelas")
public class Kelas implements Serializable {

    @Id
    @Column(name = "kelas_code", nullable = false, unique = true, length = 10)
    private String kelasCode;

    @Column(name = "gedung", nullable = false)
    private String gedung;

    @Column(name = "lantai", nullable = false)
    private String lantai;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date();
}
