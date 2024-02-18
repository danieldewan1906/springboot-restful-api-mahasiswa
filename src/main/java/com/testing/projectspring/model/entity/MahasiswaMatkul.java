package com.testing.projectspring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "mahasiswa_matkul")
public class MahasiswaMatkul implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nim")
    private Mahasiswa mahasiswa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matkul_code")
    private MataKuliah mataKuliah;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date();
}
