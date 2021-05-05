package com.example.demo.repository;

import com.example.demo.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociateRepo extends JpaRepository<Associate,Integer> {
    @Query
    public Associate findByAssociateName(String name);
    @Query
    public Associate findByAssociateMail(String mail);
    @Query
    public Associate findByAssociatePhone(String phone );
    @Query
    public Associate findByAssociateId(Integer id);
    @Query
    public List<Associate> findBySkills(String skill);
    @Query
    public void deleteByAssociateId(Integer id);
   @Query(value="select * from ASSOCIATE_DETAILS  a where a.associateName like %:keyword% or  a.associateMail like %:keyword%",nativeQuery = true)
    List<Associate> findByKeyword(@Param("keyword") String keyword);



}
