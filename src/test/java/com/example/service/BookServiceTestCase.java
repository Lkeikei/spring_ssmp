package com.example.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    void testSave()
    {
        Book book = new Book();
        book.setType("悬疑");
        book.setDescription("magic");
        book.setName("fayi");
        bookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(12);
        book.setType("love");
        book.setName("gorgeous");
        book.setDescription("so romantic");
        bookService.update(book);
    }
    @Test
    void testDelete(){
        bookService.delete(13);
    }
    @Test
    void testGetAll(){
        bookService.getAll();
    }
    @Test
    void testGetPage(){

       IPage<Book> page = bookService.getPage(2,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }


}
