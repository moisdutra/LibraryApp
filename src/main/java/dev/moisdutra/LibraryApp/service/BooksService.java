package dev.moisdutra.LibraryApp.service;

import dev.moisdutra.LibraryApp.model.BookModel;
import dev.moisdutra.LibraryApp.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    // Create book
    public BookModel createBook(BookModel bookModel) {
        return booksRepository.save(bookModel);
    }

    // List all books
    public List<BookModel> listBooks() {
        return booksRepository.findAll();
    }

    // List bok by ID
    public BookModel listBookById(Long id) {
        Optional<BookModel> book = booksRepository.findById(id);
        return book.orElse(null);
    }

    // Update book
    public BookModel updateBook(Long id, BookModel bookModel) {
        BookModel book = listBookById(id);
        if (book != null) {
            if(bookModel.getTitle() != null) book.setTitle(bookModel.getTitle());
            if(bookModel.getAuthor() != null) book.setAuthor(bookModel.getAuthor());
            if(bookModel.getCategory() != null) book.setCategory(bookModel.getCategory());

            return booksRepository.save(book);
        }  else {
            return null;
        }
    }

    // Delete book
    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }

}
