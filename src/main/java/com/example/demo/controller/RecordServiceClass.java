package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class RecordServiceClass implements RecordServiceInterface {
    @Autowired
    RecordRepository recordRepository;
    @PostConstruct
    public void init(){

    }

    @Override
    public void addRecord(Record record){
        recordRepository.save(record);
    }

    @Override
    public Record findRecordById(Long id){
        return recordRepository.getById(id);
    }

    @Override
    public void deleteRecord(Record record){
        recordRepository.delete(record);
    }

    @Override
    public List<Record> findAllRecords(){
        return recordRepository.findAll();
    }

    @Override
    public  List<Record> findByDate(Date date){
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
        String dateStr = dt.format(date);
        return recordRepository.findByDate(dateStr);
    }

}
