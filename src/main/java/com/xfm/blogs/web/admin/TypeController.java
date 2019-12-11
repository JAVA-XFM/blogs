package com.xfm.blogs.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @GetMapping("/types")
    public String types(){

        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input() {

        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput() {
        return "admin/types-input";
    }


    @PostMapping("/types")
    public String post() {

        return "redirect:/admin/types";
    }


    @PostMapping("/types/{id}")
    public String editPost() {

        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete() {

        return "redirect:/admin/types";
    }

}
