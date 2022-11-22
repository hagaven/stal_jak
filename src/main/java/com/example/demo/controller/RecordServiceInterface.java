package com.example.demo.controller;

import java.util.Date;
import java.util.List;

public interface RecordServiceInterface {
    public void addRecord(Record record);
    public Record findRecordById(Long id);
    public void deleteRecord(Record record);
    public List<Record> findAllRecords();
    public  List<Record> findByDate(Date date);
}
