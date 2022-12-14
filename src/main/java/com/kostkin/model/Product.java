package com.kostkin.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double cost;
    @ManyToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Customer customer;
}