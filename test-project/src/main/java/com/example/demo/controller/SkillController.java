package com.example.demo.controller;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/skill")
public class SkillController {
    SkillService skillService;
@Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }
    @PostMapping("/add")
    public ResponseEntity<Skill> addskill(@RequestBody Skill skill)
    {
        return ResponseEntity.ok(skillService.addSkill(skill));
    }
    @GetMapping("/display")
    public ResponseEntity<List<Skill>> displayskills()
    {
        return ResponseEntity.ok(skillService.displaySkill());
    }
}
