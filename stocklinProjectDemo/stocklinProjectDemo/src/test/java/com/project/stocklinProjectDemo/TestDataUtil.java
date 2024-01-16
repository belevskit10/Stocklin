package com.project.stocklinProjectDemo;

import com.project.stocklinProjectDemo.domain.dto.AuthorDto;
import com.project.stocklinProjectDemo.domain.dto.BookDto;
import com.project.stocklinProjectDemo.domain.entities.AuthorEntity;
import com.project.stocklinProjectDemo.domain.entities.BookEntity;

public final class TestDataUtil {

    private TestDataUtil(){
    }

    public static AuthorEntity createTestAuthorEntityA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Connor Smith")
                .age(80)
                .build();
    }

    public static AuthorDto createTestAuthorDtoA() {
        return AuthorDto.builder()
                .id(1L)
                .name("Connor Smith")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorEntityB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Jimmy Fallon")
                .age(44)
                .build();
    }


    public static AuthorEntity createTestAuthorEntityC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Richard Brown")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookEntityA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("987-1-2345-6789-0")
                .title("The shadow in the Attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("987-1-2345-6789-0")
                .title("The shadow in the Attic")
                .author(authorDto)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("987-1-2345-6789-1")
                .title("Game of Thrones")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("987-1-2345-6789-2")
                .title("12 Rules of Life")
                .authorEntity(authorEntity)
                .build();
    }


}
