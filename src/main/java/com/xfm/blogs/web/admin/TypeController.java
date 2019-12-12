package com.xfm.blogs.web.admin;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.xfm.blogs.po.Type;
import com.xfm.blogs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(Model model){
        /*Type type = new Type();
        type.setName("mysql");
        Type type1 = typeService.save(type);
        System.out.println("=============type1============" + type1.toString());*/
        try{
            Pageable pageable = new PageRequest(0,10, Sort.Direction.DESC,"id");
            Page<Type> page = typeService.findAll(pageable);
            //List<Type> typeList = page.getContent();
            model.addAttribute("page", page);
            if(page.getContent().size() == 0){
                model.addAttribute("message","没有任何类型哦！！快去添加一些类型吧！");
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("message","系统异常");
        }
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input() {

        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        Type type = typeService.findOne(id);
        if(type == null){
            model.addAttribute("message", "该类型不存在了");
        }else{
            model.addAttribute("name", type.getName());
        }
        return "admin/types-input";
    }


    @PostMapping("/types")
    public String post(@RequestParam String name, Model model) {
        Type type = new Type();
        type.setName(name);
        try{
            Type returnType = typeService.save(type);
            if (returnType == null){
                model.addAttribute("name",name);
                model.addAttribute("message","添加失败");
                return  "admin/types-input";
            }
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("name", name);
            model.addAttribute("message", "系统异常");
            return  "admin/types-input";
        }

        return "redirect:/admin/types";
    }


    @PostMapping("/types/{id}")
    public String editPost(@PathVariable Long id, @RequestParam String name, Model model) {
        Type type = new Type();
        type.setName(name);
        type.setId(id);
        try{
            Type returnType = typeService.save(type);
            if(returnType == null){
                model.addAttribute("id", id);
                model.addAttribute("name", name);
                model.addAttribute("message", "修改失败");
                return  "admin/types-input";
            }
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("id", id);
            model.addAttribute("name", name);
            model.addAttribute("message", "系统异常");
            return  "admin/types-input";
        }

        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete() {

        return "redirect:/admin/types";
    }

}
