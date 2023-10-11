package com.implodingduck.batch.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface SumandproductRepository extends JpaRepository<Sumandproduct, Long>{
    @Query(
        value = "SELECT id, v1, v2, sum, product FROM sumandproduct WHERE sum IS NULL OR sum = 0",
        countQuery = "SELECT count(*) FROM sumandproduct WHERE sum IS NULL OR sum = 0",
        nativeQuery = true
    )
    Page<Sumandproduct> findAllNullSum(Pageable pageable);
}
