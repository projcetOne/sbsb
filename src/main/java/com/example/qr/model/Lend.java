package com.example.qr.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "lend")
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant startOn;
    private Instant dueOn;

    @Enumerated(EnumType.ORDINAL)
    private LendStatus status;

    @ManyToOne //OneToMany의 반대 관계인 N:1 관계 매핑 어노테이션입니다.
    @JoinColumn(name = "book_id")
    @JsonManagedReference
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id") //외래키를 매핑할때 사용합니다. name에는 참조하는 테이블의 기본키 칼럼명이 들어갑니다.
    @JsonManagedReference
//    JPA로 연관관계 작업시 연관관계간에 서로를 무한으로 호출하는 현상이 생깁니다. 순환참조를 방어하기 위한 어노테이션입니다.
//    부모 클래스에 @JsonManagedReference, 자식 클래스에 @JsonBackReference 어노테이션을 추가하면됩니다.
    private Member member;
}