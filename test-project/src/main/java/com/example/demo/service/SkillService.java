package com.example.demo.service;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;

import java.util.List;

public interface SkillService {
    public Skill addSkill(Skill skill);
    public List<Skill> displaySkill();
}
