package com.project.stocklinProjectDemo.domain.dto;

import com.project.stocklinProjectDemo.domain.entities.AuthorEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDto {


    private String isbn;

    private String title;

    private AuthorDto author;
}
