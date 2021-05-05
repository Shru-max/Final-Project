package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name="SKILLS")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="skill_id")
    private Integer skillId;
    @Column(name="skill")
    private String skill;
   @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "associateId")
    private Associate associate;

    public Skill() {
    }

    public Skill(Integer skillId, String skill) {
        this.skillId = skillId;
        this.skill = skill;
    }

    public Skill(Integer skillId, String skill, Associate associate) {
        this.skillId = skillId;
        this.skill = skill;
       // this.associate = associate;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skill='" + skill + '\'' +
                ", associate=" + associate +
                '}';
    }
}
