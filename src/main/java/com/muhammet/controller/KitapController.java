package com.muhammet.controller;

import com.muhammet.dto.request.SaveKitapRequestDto;
import com.muhammet.dto.response.FindByYazarAdiResponseDto;
import com.muhammet.mapper.IKitapMapper;
import com.muhammet.repository.entity.Kitap;
import com.muhammet.service.KitapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.muhammet.constants.EndPointList.*;
@RestController
@RequestMapping(KITAP)
@RequiredArgsConstructor
public class KitapController {
    private final KitapService kitapService;

    /**
     * ÖDEV
     * Kitap adı verildiğinde yazar listesi gelsin.
     * Yazar adı verildiğinde kitap listesi gelsin.
     * Tür adı verildiğinde kitap listesi gelsin.
     */

    @PostMapping(SAVE)
    public ResponseEntity<Kitap> saveKitap(@Valid SaveKitapRequestDto dto){
      return ResponseEntity.ok(kitapService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Kitap>> findAll(){
        return ResponseEntity.ok(kitapService.findAll());
    }

    /**
     * Controller katmanında alınan ve iletilen tüm datalar
     * DTO (Data Transfer Object) olarak kullanılmalıdır.
     * RequestDTO ve ResponseDTO
     *
     * Repository ile bir veritananından bilgi çekiliyor ise bu çekilen bilgilerde
     * entity dışında belli bir özellikle bütünü olarak çekilecek ise
     * View kullanılmalıdır.
     *
     * @param yazarAdi
     * @return
     */
    @GetMapping(FIND_BY_YAZARADI)
    public ResponseEntity<List<FindByYazarAdiResponseDto>> findByYazarAdi(String yazarAdi){
        List<FindByYazarAdiResponseDto> result = kitapService.findByYazarAdi(yazarAdi);
        return ResponseEntity.ok(result);
    }
}
