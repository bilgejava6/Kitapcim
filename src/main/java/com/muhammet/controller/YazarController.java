package com.muhammet.controller;

import com.muhammet.dto.request.SaveYazarRequestDto;
import com.muhammet.repository.entity.Yazar;
import com.muhammet.service.YazarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/yazar")
@RequiredArgsConstructor
public class YazarController {
    private final YazarService yazarService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody @Valid SaveYazarRequestDto dto){
        yazarService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Yazar>> findAll(){
        return ResponseEntity.ok(yazarService.findAll());
    }
}
