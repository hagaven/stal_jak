package com.example.demo.controller;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RecordRepository extends JpaRepository<Record, Long> {
    @Query(value = "SELECT * FROM stal_jak WHERE datai >= ?1 AND datai < ?1", nativeQuery = true)
    public List<Record> findByDate(String date);
}
