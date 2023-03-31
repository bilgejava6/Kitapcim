package com.muhammet.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblyayinevi")
public class Yayinevi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 350, nullable = false)
    String ad;
    String adres;
    String telefon;
}
