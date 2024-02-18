package com.testing.projectspring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "detail_kelas")
public class DetailKelas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kelas_code")
    private Kelas kelas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matkul_code")
    private MataKuliah mataKuliah;

    @Column(name = "time", nullable = false)
    private String time;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date();

}
