package com.project.stocklinProjectDemo.repositories;

import com.project.stocklinProjectDemo.TestDataUtil;
import com.project.stocklinProjectDemo.domain.entities.AuthorEntity;
import com.project.stocklinProjectDemo.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookEntityRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    public BookEntityRepositoryIntegrationTests(BookRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
        BookEntity bookEntity = TestDataUtil.createTestBookEntityA(authorEntity);
        underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();

        BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntityA);
        underTest.save(bookEntityA);

        BookEntity bookEntityB = TestDataUtil.createTestBookB(authorEntityA);
        underTest.save(bookEntityB);

        BookEntity bookEntityC = TestDataUtil.createTestBookC(authorEntityA);
        underTest.save(bookEntityC);

        Iterable<BookEntity> result = underTest.findAll();
        assertThat(result)
                .hasSize(3).
                containsExactly(bookEntityA, bookEntityB, bookEntityC);
    }

    @Test
    public void testThatBookCanBeUpdated(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();

        BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntityA);
        underTest.save(bookEntityA);

        bookEntityA.setTitle("UPDATED");
        underTest.save(bookEntityA);

        Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntityA);
    }

    @Test
    public void testThatBookCanBeDeleted(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();

        BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntityA);
        underTest.save(bookEntityA);

        underTest.deleteById(bookEntityA.getIsbn());

        Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
        assertThat(result).isEmpty();
    }
}
