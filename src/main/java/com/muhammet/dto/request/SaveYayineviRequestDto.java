package com.muhammet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaveYayineviRequestDto {

    @NotEmpty(message = "Yayınevi adı boş olamaz")
    @Size(min=3, max = 350, message = "Yayınevi adı 350 karakterden fazla olamaz")
    String ad;
    String adres;
    String telefon;
}
