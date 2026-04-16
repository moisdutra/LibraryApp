package dev.moisdutra.LibraryApp.service;

import dev.moisdutra.LibraryApp.model.BookModel;
import dev.moisdutra.LibraryApp.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<BookModel> listBooks() {
        return booksRepository.findAll();
    }

}
