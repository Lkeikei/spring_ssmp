package com.example.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
//娄须强
    @GetMapping
    public R getAll(){
        return  new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
       if(book.getName().equals("132")) throw new IOException();
        boolean flag = bookService.save(book);
        return  new R(flag, flag ? "添加成功^_^":"添加失败-_-!" );
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return  new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable int id){
        return  new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable int id){
        return  new R(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage,pageSize,book);

        if( currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pageSize,book);
        }
        return  new R(true,page);
    }
}
