package com.muhammet.controller;

import com.muhammet.dto.request.SaveKitapRequestDto;
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

    @PostMapping(SAVE)
    public ResponseEntity<Kitap> saveKitap(@RequestBody @Valid SaveKitapRequestDto dto){
      return ResponseEntity.ok(kitapService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Kitap>> findAll(){
        return ResponseEntity.ok(kitapService.findAll());
    }
}
