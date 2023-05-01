package com.bookStore.bookStore.repository;

import com.bookStore.bookStore.entity.MyBagList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBagRepository extends JpaRepository<MyBagList,Integer> {

}
