package com.mobilepark.airtalk.repository;

import java.util.List;

import com.mobilepark.airtalk.data.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.PageRequest;

@Repository
public interface CodeRepository extends JpaRepository<Code , String> , JpaSpecificationExecutor<Code>  {

    int countByCodeContaining(String keyword);
    int countByCodeNameContaining(String keyword);
    List<Code> findByCodeContaining(String keyword, PageRequest pageRequest);

    @Query(value = "SELECT COUNT(*) FROM TBL_SERVICE_CODE", nativeQuery = true)
   int countByAll();
}