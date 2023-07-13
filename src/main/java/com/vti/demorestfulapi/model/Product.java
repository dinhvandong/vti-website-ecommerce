package com.vti.demorestfulapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    private String category;
    private Date createdDate;
    private long userID;
    private Date deleteTime; // NULL chua xoa != NULL xoa  - Thoi gian xoa
//    private boolean delete; // true = xoa false chua xoa
}
