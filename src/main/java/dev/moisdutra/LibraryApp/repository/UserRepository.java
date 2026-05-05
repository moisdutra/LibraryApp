package dev.moisdutra.LibraryApp.repository;

import dev.moisdutra.LibraryApp.model.BookModel;
import dev.moisdutra.LibraryApp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
