package com.example.qr.repository;

import com.example.qr.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
//    Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로,
//    참조하더라도 NPE가 발생하지 않도록 도와준다. Optional 클래스는 아래와 같은 value에 값을 저장하기 때문에
//    값이 null이더라도 바로 NPE가 발생하지 않으며, 클래스이기 때문에 각종 메소드를 제공해준다.

    Optional<Book> findByIsbn(String isbn);


}