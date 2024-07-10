package org.example.test_template_2.controllers;

import jakarta.validation.Valid;
import org.example.test_template_2.entities.LoaiPhong;
import org.example.test_template_2.entities.Phong;
import org.example.test_template_2.repositories.LoaiPhongRepository;
import org.example.test_template_2.repositories.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/phong")
public class PhongController {

    @Autowired
    PhongRepository phongRepository;

    @Autowired
    LoaiPhongRepository loaiPhongRepository;

    @ModelAttribute("listLoaiPhong")
    public List<LoaiPhong> listLoaiPhong() {
        return loaiPhongRepository.findAll();
    }

    @RequestMapping
    public String phong(@ModelAttribute("p") Phong p, Model model,
                        @RequestParam(defaultValue = "0") int page
                        ) {
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Phong> phongs = phongRepository.findAll(pageRequest);

        model.addAttribute("phongs", phongs);
        List<LoaiPhong> loaiPhongs = loaiPhongRepository.findAll();
        Map<Integer, String> loaiPhongMap = new HashMap<>();
        for (LoaiPhong loaiPhong : loaiPhongs) {
            loaiPhongMap.put(loaiPhong.getId(), loaiPhong.getTenLoaiPhong());
        }
        model.addAttribute("loaiPhongMap", loaiPhongMap);
        return "index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("p") Phong p, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }
        phongRepository.save(p);
        return "redirect:/phong";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") int id, Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("p", phongRepository.findById(id));
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Phong> phongs = phongRepository.findAll(pageRequest);

        model.addAttribute("phongs", phongs);
        List<LoaiPhong> loaiPhongs = loaiPhongRepository.findAll();
        Map<Integer, String> loaiPhongMap = new HashMap<>();
        for (LoaiPhong loaiPhong : loaiPhongs) {
            loaiPhongMap.put(loaiPhong.getId(), loaiPhong.getTenLoaiPhong());
        }
        model.addAttribute("loaiPhongMap", loaiPhongMap);
        model.addAttribute("idUpdate", id);
        return "index";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,
            @Valid @ModelAttribute("p") Phong p, BindingResult result
                         ){
        if (result.hasErrors()) {
            return "index";
        }
        if (phongRepository.findById(id).get()!=null){
            phongRepository.save(p);
        }

        return "redirect:/phong";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        phongRepository.delete(phongRepository.findById(id).get());
        return "redirect:/phong";
    }

}
