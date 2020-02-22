package com.koory1st.spring_boot_swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-reuse")
public class TestReuseController {
    @GetMapping("/add-a")
    public String addA(String input) {
        return input + "a";
    }

    @GetMapping("add-b")
    public String addB(String input) {
        return input + "b";
    }

    @GetMapping("add-c")
    public String addC(String input) {
        return input + "c";
    }
}
