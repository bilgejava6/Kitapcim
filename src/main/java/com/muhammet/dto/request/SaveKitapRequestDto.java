package com.muhammet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveKitapRequestDto {
    String ad;
    Integer sayfasayisi;
    Long basimtarihi;
    List<Long> yazarids;
    Long yayineviid;
    List<Long> turids;
}
