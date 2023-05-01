package com.bookStore.bookStore.service;

import com.bookStore.bookStore.entity.MyBagList;
import com.bookStore.bookStore.repository.MyBagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBagService {
    @Autowired
    private MyBagRepository mybook;

    public void saveMyBooks(MyBagList book){
        mybook.save(book);
    }

    public List<MyBagList> getAllMyBooks(){
        return mybook.findAll();
    }

    public void deleteById(int id) {
        mybook.deleteById(id);
    }
}
