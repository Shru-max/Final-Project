package com.example.demo;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repository.AssociateRepo;
import com.example.demo.repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class TestProjectApplication implements CommandLineRunner{
    SkillRepo skillRepo;
    AssociateRepo associateRepo;

    public TestProjectApplication(SkillRepo skillRepo, AssociateRepo associateRepo) {
        this.skillRepo = skillRepo;
        this.associateRepo = associateRepo;
    }

    @Autowired





    public static void main(String[] args) {
        SpringApplication.run(TestProjectApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Skill s1=new Skill(1,"Java");
        Skill s2=new Skill(2,"Python");
        Skill s3=new Skill(3,"MySQL");
        Skill s4=new Skill(4,"JavaScript");
        skillRepo.save(s1);
        skillRepo.save(s2);
        skillRepo.save(s3);
        skillRepo.save(s4);
        associateRepo.save(new Associate(1,"shruthi","shru@mail", "9090909090", Arrays.asList(new Skill[]{s1,s2})));






    }
}
