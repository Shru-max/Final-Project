package com.example.demo.service;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    SkillRepo skillRepo;
@Autowired
    public SkillServiceImpl(SkillRepo skillRepo) {
        this.skillRepo = skillRepo;
    }

    @Override
    public Skill addSkill(Skill skill) {
       return skillRepo.save(skill);
    }

    @Override
    public List<Skill> displaySkill() {
        return skillRepo.findAll();
    }
}
