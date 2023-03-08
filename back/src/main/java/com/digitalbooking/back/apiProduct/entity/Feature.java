package com.digitalbooking.back.apiProduct.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;

@Entity
@Table(name = "FEATURE")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEATURE_ID")
    private Long id;

    @Column(name = "NAME")
    private String title;

    @Column(name = "ICON")
    private String Icon;

}
