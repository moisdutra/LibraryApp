package dev.moisdutra.LibraryApp.repository;

import dev.moisdutra.LibraryApp.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BookModel, Long> {
}
