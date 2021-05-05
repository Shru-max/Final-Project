package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ASSOCIATE_DETAILS")
public class Associate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="associate_id")
    private Integer associateId;
    @Column(name="Name")
    private String associateName;
    @Column(name="Email")
    private String associateMail;
    @Column(name="Phone")
    private String associatePhone;
   @OneToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;
   /*@OneToMany(cascade=CascadeType.ALL)
   @JoinColumn(name = "a_id",referencedColumnName ="associateId" )
   private List<Skill> skills;*/
   /*@OneToMany(mappedBy="associate",
           cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                   CascadeType.DETACH, CascadeType.REFRESH})
   private List<Skill> skills;*/


    public Associate() {
    }

    public Associate(Integer associateId, String associateName, String associateMail, String associatePhone, List<Skill> skills) {
        this.associateId = associateId;
        this.associateName = associateName;
        this.associateMail = associateMail;
        this.associatePhone = associatePhone;
        this.skills = skills;
    }

    public Integer getAssociateId() {
        return associateId;
    }

    public void setAssociateId(Integer associateId) {
        this.associateId = associateId;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getAssociateMail() {
        return associateMail;
    }

    public void setAssociateMail(String associateMail) {
        this.associateMail = associateMail;
    }

    public String getAssociatePhone() {
        return associatePhone;
    }

    public void setAssociatePhone(String associatePhone) {
        this.associatePhone = associatePhone;
    }


    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Associate{" +
                "associateId=" + associateId +
                ", associateName='" + associateName + '\'' +
                ", associateMail='" + associateMail + '\'' +
                ", associatePhone='" + associatePhone + '\'' +
                ", skills=" + skills +
                '}';
    }
}
