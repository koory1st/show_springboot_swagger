package com.koory1st.spring_boot_swagger.controller;

import com.koory1st.spring_boot_swagger.dto.PetDto;
import com.koory1st.spring_boot_swagger.vo.PetVo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {
    @GetMapping
    public PetVo getInfoList(String filter, Integer pageNum, Integer pageSize) {
        return new PetVo();
    }

    @GetMapping("/{id}")
    public PetVo getInfo(@PathVariable Long id) {
        return new PetVo();
    }

    @PostMapping
    public PetVo saveInfo(PetDto info) {
        return new PetVo();
    }

    @PutMapping("/{id}")
    public PetVo updateInfo(Long id, PetDto info) {
        return new PetVo();
    }

    @DeleteMapping("/{id}")
    public void deleteInfo(Long id) {
    }
}
