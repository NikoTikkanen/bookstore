package fi.haagahelia.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.haagahelia.bookstore.BookstoreApplication;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

	
	@Autowired BookRepository repository;
	
	@Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("kaksi tornia");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("bilbo baggings");
    }
	
	@Test
    public void createNewBook() {
    	Book book = new Book("Mickey", "Mouse", 1999, "mm@mouse.com", 20.00, new Category("BITE"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
	 
}
