package com.muhammet.dto.response;

import com.muhammet.repository.entity.Kitap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FindByYazarAdiResponseDto {
    String yazarAdi;
    List<Kitap> kitapList;
}
