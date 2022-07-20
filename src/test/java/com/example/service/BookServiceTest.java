package com.example.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService bookService;

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
        bookService.updateById(book);
    }
    @Test
    void testDelete(){
        bookService.removeById(13);
    }
    @Test
    void testGetAll(){
        bookService.list();
    }
    @Test
    void testGetPage(){
        IPage<Book> page = new Page<Book>(2,5);
        bookService.page(page);

    }


}
