package com.testing.projectspring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "dosen")
public class Dosen implements Serializable {

    @Id
    @Column(name = "nid", nullable = false, unique = true, length = 10)
    private String nid;

    @Column(name = "name", nullable = false, unique = true)
    private String dosenName;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date createdAt = new Date();

    @OneToMany(fetch = FetchType.LAZY)
    private List<MataKuliah> mataKuliahList = new ArrayList<>();

}
