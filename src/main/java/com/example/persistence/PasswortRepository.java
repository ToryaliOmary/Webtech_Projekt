package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswortRepository extends JpaRepository<PasswortEntity, Long> {

    List<PasswortEntity> findAllByWebsite(String website);

}