package com.example.qr.repository;


import com.example.qr.model.Book;
import com.example.qr.model.Lend;
import com.example.qr.model.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}