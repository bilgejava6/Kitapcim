package com.muhammet.controller;

import com.muhammet.dto.request.SaveYazarRequestDto;
import com.muhammet.mapper.IYazarMapper;
import com.muhammet.repository.entity.Yazar;
import com.muhammet.service.YazarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.muhammet.constants.EndPointList.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(YAZAR)
@RequiredArgsConstructor
public class YazarController {
    private final YazarService yazarService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SaveYazarRequestDto dto){
        yazarService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Yazar>> findAll(){
        return ResponseEntity.ok(yazarService.findAll());
    }
}
