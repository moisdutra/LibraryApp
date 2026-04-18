package dev.moisdutra.LibraryApp.controller;

import dev.moisdutra.LibraryApp.model.BookModel;
import dev.moisdutra.LibraryApp.service.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping("/addbook")
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {
        BookModel book = booksService.createBook(bookModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(book);
    }

    @GetMapping("/listbooks")
    public ResponseEntity<List<BookModel>> listBooks() {
        List<BookModel> books = booksService.listBooks();
        return ResponseEntity.status(HttpStatus.OK)
                .body(books);
    }

    @GetMapping("/listbooks/{id}")
    public ResponseEntity<?> listBookById(@PathVariable Long id) {
        BookModel book = booksService.listBookById(id);
        if (book != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book not found.");
        }
    }

    @PatchMapping("/updatebook/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookModel bookModel) {
        if (booksService.listBookById(id) != null) {
            BookModel book = booksService.updateBook(id, bookModel);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book not found.");
        }
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (booksService.listBookById(id) != null) {
            booksService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Book deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book not found.");
        }
    }


}
