package com.muhammet.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblturkitap")
public class TurKitap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long turid;
    Long kitapid;
}
