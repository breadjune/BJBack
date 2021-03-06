package com.mobilepark.airtalk.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mobilepark.airtalk.data.BoardFile;

@Repository
public interface BoardFileRepository extends JpaRepository<BoardFile, Integer>{
    
}
