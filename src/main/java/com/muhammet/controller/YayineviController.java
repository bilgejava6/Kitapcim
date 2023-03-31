package com.muhammet.controller;

import com.muhammet.dto.request.SaveYayineviRequestDto;
import com.muhammet.dto.request.SaveYazarRequestDto;
import com.muhammet.repository.entity.Yayinevi;
import com.muhammet.service.YayineviService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.muhammet.constants.EndPointList.*;
@RestController
@RequestMapping(YAYINEVI)
@RequiredArgsConstructor
public class YayineviController {
    private final YayineviService yayineviService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid
                                         SaveYayineviRequestDto dto){
        yayineviService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Yayinevi>> findAll(){
        return ResponseEntity.ok(yayineviService.findAll());
    }
}
