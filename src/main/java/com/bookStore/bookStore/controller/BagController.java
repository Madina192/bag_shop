package com.bookStore.bookStore.controller;
import com.bookStore.bookStore.entity.Bag;
import com.bookStore.bookStore.entity.MyBagList;
import com.bookStore.bookStore.service.BagService;
import com.bookStore.bookStore.service.MyBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller

public class BagController {
    @Autowired
    private BagService service;

    @Autowired
    private MyBagService myBookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister() {
        return "BagRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Bag>list=service.getAllBook();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BagList");
        modelAndView.addObject("book", list);
        return modelAndView;
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBagList>list = myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "MyBags";
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Bag book) {
        service.save(book);
        return "redirect:/available_books";
    }
    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Bag b=service.getBookById(id);
        MyBagList mb = new MyBagList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Bag b = service.getBookById(id);
        model.addAttribute("book",b);
        return "BagEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }
}
