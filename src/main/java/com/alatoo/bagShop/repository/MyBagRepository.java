package com.alatoo.bagShop.repository;

import com.alatoo.bagShop.entity.MyBagList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBagRepository extends JpaRepository<MyBagList,Integer> {

}
