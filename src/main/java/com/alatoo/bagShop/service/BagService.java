package com.alatoo.bagShop.service;

import com.alatoo.bagShop.entity.Bag;
import com.alatoo.bagShop.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BagService {
    @Autowired
    private BagRepository bRepo;
    public void save(Bag book) {
        bRepo.save(book);
    }

    public List<Bag> getAllBook(){
        return bRepo.findAll();
    }

    public Bag getBookById(int id){
        return bRepo.findById((id)).get();
    }

    public void deleteById(int id) {
        bRepo.deleteById(id);
    }
}
