package com.mobilepark.airtalk.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mobilepark.airtalk.data.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer>{
    
}
