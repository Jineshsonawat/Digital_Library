package com.learning.digitalLibrary.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

@Entity
@Table(name = "book_issue")
public class BookIssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIdentityReference(alwaysAsId = true) // show only ID
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIdentityReference(alwaysAsId = true) // show only ID
    private BookEntity bookEntity;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate = LocalDate.now();

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Override
    public String toString() {
        return "BookIssueEntity{" +
                "id=" + id +
                ", userEntity=" + userEntity +
                ", bookEntity=" + bookEntity +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
