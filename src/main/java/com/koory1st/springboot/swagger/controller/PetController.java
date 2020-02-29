package com.koory1st.springboot.swagger.controller;

import com.koory1st.springboot.swagger.dto.PetDto;
import com.koory1st.springboot.swagger.exception.MyException;
import com.koory1st.springboot.swagger.vo.PetVo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    PetVo rt = new PetVo();

    rt.setId(id);
    return rt;
  }


  @PostMapping
  public PetVo saveInfo(@RequestBody PetDto info) {
    if (Objects.equals(info.getId(), 3L)) {
      throw new MyException("id is three");
    }
    PetVo rt = new PetVo();

    return rt;
  }

  @PutMapping("/{id}")
  public PetVo updateInfo(Long id, @RequestBody PetDto info) {
    return new PetVo();
  }

  @DeleteMapping("/{id}")
  public void deleteInfo(Long id) {
  }
}
