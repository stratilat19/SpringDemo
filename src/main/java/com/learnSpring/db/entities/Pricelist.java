package com.learnSpring.db.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pricelist {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private long price;

    @Lob
    private byte[] file;
    private String fileName;
    private String fileType;

    public Pricelist() {
    }

}
