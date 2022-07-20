package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(int id);
    Book getById(int id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage,int pageSize);

}
