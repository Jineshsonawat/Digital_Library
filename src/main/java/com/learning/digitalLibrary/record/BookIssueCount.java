package com.learning.digitalLibrary.record;

import com.learning.digitalLibrary.entity.BookEntity;
//import lombok.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Getter
//@Setter
//public class BookIssueCount{
//
//private BookEntity bookEntity;
//private Long issueCount;
//}

public record BookIssueCount(BookEntity bookEntity , Long issueCount){}
