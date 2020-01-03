package com.jy.inflearn.thejava.mydifw;

public class BookService {

    @Inject
    BookRepository bookRepository;

    public void buy(Book book){
        System.out.println("책을 구매합니다.");
        bookRepository.save(book);
    }

}
