package com.project.stocklinProjectDemo.repositories;

import com.project.stocklinProjectDemo.TestDataUtil;
import com.project.stocklinProjectDemo.domain.entities.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorEntityRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorEntityRepositoryIntegrationTests(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntity);
        Optional<AuthorEntity> results = underTest.findById(authorEntity.getId());
        assertThat(results).isPresent();
        assertThat(results.get()).isEqualTo(authorEntity);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntityA);
        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorEntityB();
        underTest.save(authorEntityB);
        AuthorEntity authorEntityC = TestDataUtil.createTestAuthorEntityC();
        underTest.save(authorEntityC);

        Iterable<AuthorEntity> result = underTest.findAll();
        assertThat(result)
                .hasSize(3).
                contains(authorEntityA, authorEntityB, authorEntityC);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntityA);
        authorEntityA.setName("UPDATED");
        underTest.save(authorEntityA);
        Optional<AuthorEntity> result = underTest.findById(authorEntityA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntityA);
    }

    @Test
    public void testThatAuthorCanBeDeleted() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntity);
        underTest.deleteById(authorEntity.getId());
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAuthorsWithAgeLessThan() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntityA);
        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorEntityB();
        underTest.save(authorEntityB);
        AuthorEntity authorEntityC = TestDataUtil.createTestAuthorEntityC();
        underTest.save(authorEntityC);

        Iterable<AuthorEntity>results = underTest.ageLessThan(50);
        assertThat(results).containsExactly(authorEntityB, authorEntityC);
    }

    @Test
    public void testThatGetAuthorsWithAgeGreaterThan() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntityA);
        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorEntityB();
        underTest.save(authorEntityB);
        AuthorEntity authorEntityC = TestDataUtil.createTestAuthorEntityC();
        underTest.save(authorEntityC);

        Iterable<AuthorEntity> results = underTest.findAuthorsWithAgeGreaterThan(50);
        assertThat(results).containsExactly(authorEntityA);
    }
}
