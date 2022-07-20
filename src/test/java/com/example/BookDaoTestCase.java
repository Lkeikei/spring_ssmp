package com.example;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
   private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(10));
    }
    @Test
    void testGetPage(){
        IPage page = new Page(1,5);

        bookDao.selectPage(page,null);

    }
    @Test
    void testSave()
    {
        Book book = new Book();
        book.setType("悬疑");
        book.setDescription("magic");
        book.setName("fayi");
        bookDao.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(12);
        book.setType("love");
        book.setName("gorgeous");
        book.setDescription("so romantic");
        bookDao.updateById(book);
    }
    @Test
    void testDelete(){
        bookDao.deleteById(12);
    }
    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }
    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }
    @Test
    void testGetBy2(){
        String name = "Spring";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null,Book::getName,name);

        bookDao.selectList(lqw);

    }



    }

