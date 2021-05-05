package com.example.demo.controller;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repository.AssociateRepo;
import com.example.demo.repository.SkillRepo;
import com.example.demo.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/associate/")
public class AssociateController {
    AssociateService associateService;
    AssociateRepo associateRepo;
    SkillRepo skillRepo;
@Autowired
    public AssociateController(AssociateService associateService, AssociateRepo associateRepo, SkillRepo skillRepo) {
        this.associateService = associateService;
        this.associateRepo = associateRepo;
        this.skillRepo = skillRepo;
    }

    //As a microservice(For postman) ***
/* @PostMapping("/add")
    //public ResponseEntity<Associate> addassociate(@RequestBody Associate associate)
    public String addassociate(@ModelAttribute("associate") Associate associate)
    {
        //return ResponseEntity.ok(associateService.addAssociate(associate));
        associateService.addAssociate(associate);
        return "redirect:/associate/display";
    }


   @GetMapping("/display")
    public ResponseEntity<List<Associate>> displayassociates()
    {
        return ResponseEntity.ok(associateService.displayAssociate());
    }
@GetMapping("/fname/{name}")
    public ResponseEntity<Associate> getbyfirstname(@PathVariable String name)
    {
        return ResponseEntity.ok(associateService.findByAssociateName(name));
    }
    @GetMapping("/byid/{aid}")
    public ResponseEntity<Optional<Associate>> getbyid(@PathVariable Integer aid)
    {
        return ResponseEntity.ok(associateService.findByid(aid));

    }
    @GetMapping("/bymail/{mail}")
    public ResponseEntity<Associate> getbyemail(@PathVariable String mail)
    {
        return ResponseEntity.ok(associateService.findByAssociateMail(mail));

    }
    @GetMapping("/byphone/{phone}")
    public ResponseEntity<Associate> getbyphone(@PathVariable String phone)
    {
        return ResponseEntity.ok(associateService.findByAssociatePhone(phone));

    }
    @GetMapping("/byskills/{skill}")
    public ResponseEntity<List<Associate>> getbyskill(@PathVariable String skill)
    {
        return ResponseEntity.ok(associateService.findBySkills(skill));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Associate> updateassociate(@PathVariable Integer id,@RequestBody Associate associate)
    {
        return ResponseEntity.ok(associateService.updateAssociate(id,associate));
    }
    @DeleteMapping("/delete/{id}")
    public void deletebyid(@PathVariable Integer id)
    {
        associateService.deleteByAssociateId(id);
    }
    @DeleteMapping("/deleteall")
    public void deleteall()
    {
        associateService.deleteall();
    } */


   //Testing through postman(for front end purpose)
   /* @PostMapping("adddemo")
    public ResponseEntity<Associate> postman(@RequestBody Associate associate)
    {
      return  ResponseEntity.ok(associateService.addAssociate(associate));

    } ***  */

    //For front end purposes *
   @GetMapping("signup")
   public String showSignUpForm(Associate associate) {
       return "new-associate";
   }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("associates", associateService.displayAssociate());
        return "index";
    }

    @PostMapping("add")
    public String addStudent(@Valid Associate associate, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-associate";
        }

        associateService.addAssociate(associate);
        return "redirect:list";
    }
    @PostMapping("save/skills")
    public String saveAssociate(@ModelAttribute("associate") Associate theAssociate, @ModelAttribute("skill") Skill theSkill) {

        associateService.addAssociate(theAssociate);
       skillRepo.save(theSkill);
        return "redirect:/associate/list";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
       Associate associate = associateRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid associate Id:" + id));
       model.addAttribute("associate", associate);
        return "update-associate";
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("associate") Associate associate) {
        // save the employee
        associateService.addAssociate(associate);
        // use a redirect to prevent duplicate submissions
        return "redirect:/associate/list";
    }

    @GetMapping("delete/{id}")
    @Transactional
    public String deleteStudent(@PathVariable("id") Integer id, Model model) {
     Associate associate=associateRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        associateService.deleteByAssociateId(id);
        model.addAttribute("associates", associateService.displayAssociate());
        return "index";
    }

    @GetMapping("assosearch")
    public List<Associate> getAssociates(Model model, String keyword)
    {
        List<Associate> list=associateService.displayAssociate();
        if(keyword!=null){
            model.addAttribute("associates", associateService.findByKeyword(keyword));
        }
        else {
            model.addAttribute("associates", list);
        }
        return list;
    }

    /*@GetMapping("search")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Associate> list = associateService.listAll(keyword);
        model.addAttribute("associates", list);
        model.addAttribute("keyword", keyword);

        return "index";
    } */
//*




}
