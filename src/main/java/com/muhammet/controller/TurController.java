package com.muhammet.controller;

import com.muhammet.repository.entity.Tur;
import com.muhammet.service.TurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * http://localhost:9090/tur
 */
@RestController
@RequestMapping("/tur")
@RequiredArgsConstructor
public class TurController {
    private final TurService turService;

    /**
     * http://localhost:9090/tur/save
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<Void> save(String turAdi){
        turService.save(turAdi);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Tur>> findAll(){
        return ResponseEntity.ok(turService.findAll());
    }
}
