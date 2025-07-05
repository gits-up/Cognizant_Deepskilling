// Exercise 1

//package com.library.service;
//
//import com.library.repository.BookRepository;
//
//public class BookService {
//    private BookRepository bookRepository;
//
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public void addBook() {
//        bookRepository.save();
//    }
//}

//Exercise 2
//package com.library.service;
//
//import com.library.repository.BookRepository;
//
//public class BookService {
//    private BookRepository bookRepository;
//
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public void addBook() {
//        if (bookRepository != null) {
//            System.out.println("Calling BookRepository...");
//            bookRepository.save();
//        } else {
//            System.out.println("BookRepository is not injected!");
//        }
//    }
//}


//Exercise 5
//package com.library.service;
//
//import com.library.repository.BookRepository;
//
//public class BookService {
//    private BookRepository bookRepository;
//
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public void addBook() {
//        System.out.println("Calling BookRepository...");
//        bookRepository.save();
//    }
//}


//Exercise 6
//package com.library.service;
//
//import com.library.repository.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BookService {
//    private BookRepository bookRepository;
//
//    @Autowired
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public void addBook() {
//        System.out.println("Calling BookRepository...");
//        bookRepository.save();
//    }
//}

//Exercise 7
package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        System.out.println("Constructor Injection used");
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Setter Injection used");
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("Calling BookRepository...");
        bookRepository.save();
    }
}

