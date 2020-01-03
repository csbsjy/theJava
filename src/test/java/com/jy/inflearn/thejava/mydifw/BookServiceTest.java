package com.jy.inflearn.thejava.mydifw;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest {

    BookService bookService = ContainerService.getObject(BookService.class);

    @Test
    public void di(){
        bookService.buy(new Book());
    }
}