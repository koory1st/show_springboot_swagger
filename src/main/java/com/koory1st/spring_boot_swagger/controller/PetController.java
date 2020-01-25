package com.koory1st.spring_boot_swagger.controller;

import com.koory1st.spring_boot_swagger.dto.PetDto;
import com.koory1st.spring_boot_swagger.vo.PetVo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    @GetMapping
    public List<PetVo> getInfoList(String filter, Integer pageNum, Integer pageSize) {

        ArrayList<PetVo> list = new ArrayList<>();
        list.add(new PetVo());
        return list;
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
