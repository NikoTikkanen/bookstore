package fi.haagahelia.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
		@Bean
		public CommandLineRunner booksDemo (BookRepository brepository, CategoryRepository crepository) {
			return (args) -> {
				log.info("save a couble of books");
				crepository.save(new Category("Fantasy"));
				crepository.save(new Category("Crime"));
				crepository.save(new Category("Horror"));
				
				
				
				brepository.save(new Book("kirja", "kirjailija", 2022, "123",20.00, crepository.findByName("Fantasy").get(0)));
				brepository.save(new Book("kaksi tornia", "bilbo baggings", 1999, "222",59.99, crepository.findByName("Crime").get(0)));
				brepository.save(new Book("kolme tornia", "frodo baggings", 1800, "333",69.99, crepository.findByName("Fantasy").get(0)));
				brepository.save(new Book("neljä tornia", "sam baggings", 1222, "44",79.99, crepository.findByName("Fantasy").get(0)));
				brepository.save(new Book("viisi ritaria", "bilbo", 102, "22",89.99, crepository.findByName("Horror").get(0)));
				brepository.save(new Book("kolme koiraa", "gimli hobitti", 2002, "77",99.99, crepository.findByName("Crime").get(0)));
				brepository.save(new Book("kaksi sormusta", "bilbo baggings", 1995, "55",159.99, crepository.findByName("Fantasy").get(0)));
				brepository.save(new Book("kuusi donitsia", "aragorn", 1999, "78",129.99, crepository.findByName("Horror").get(0)));
				
				
				log.info("fetch all books");
				for (Book book : brepository.findAll()) {
					log.info(book.toString());
				}
			
		};
	}

}
