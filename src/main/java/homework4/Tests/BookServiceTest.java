package homework4.Tests;

import homework4.Book.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    BookRepository bookRepository;
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = mock(InMemoryBookRepository.class);
        bookService = new BookService(bookRepository);

    }

    @Test
    void testBookServiceFindBookById() {
        when(bookRepository.findById("1")).thenReturn(new Book("1", "1984", "George Orwell"));
        when(bookRepository.findById("2")).thenReturn(new Book("2", "Harry Potter and the Sorcerer’s Stone", "J.K. Rowling"));
        when(bookRepository.findById("3")).thenReturn(new Book("3", "Atlas shrugged", "Ayn Rand"));

        Book book1 = bookService.findBookById("1");
        Book book2 = bookService.findBookById("2");
        Book book3 = bookService.findBookById("3");

        List<String> book1ref = List.of(new String[]{"1", "1984", "George Orwell"});
        List<String> book2ref = List.of(new String[]{"2", "Harry Potter and the Sorcerer’s Stone", "J.K. Rowling"});
        List<String> book3ref = List.of(new String[]{"3", "Atlas shrugged", "Ayn Rand"});
        List<String> book1act = List.of(new String[]{book1.getId(), book1.getTitle(), book1.getAuthor()});
        List<String> book2act = List.of(new String[]{book2.getId(), book2.getTitle(), book2.getAuthor()});
        List<String> book3act = List.of(new String[]{book3.getId(), book3.getTitle(), book3.getAuthor()});

        for (int i = 0, len = book1ref.toArray().length; i < len; i++) {
            assertEquals(book1ref.get(i), book1act.get(i));
        }
        for (int i = 0, len = book2ref.toArray().length; i < len; i++) {
            assertEquals(book2ref.get(i), book2act.get(i));
        }
        for (int i = 0, len = book3ref.toArray().length; i < len; i++) {
            assertEquals(book3ref.get(i), book3act.get(i));
        }
    }

    @Test
    void testBookServiceFindAllBooks() {
        Book book1 = new Book("1", "1984", "George Orwell");
        Book book2 = new Book("2", "Harry Potter and the Sorcerer’s Stone", "J.K. Rowling");
        Book book3 = new Book("3", "Atlas shrugged", "Ayn Rand");

        List<Book> books = List.of(new Book[]{book1, book2, book3});

        when(bookRepository.findAll()).thenReturn(books);

        assertEquals(1, bookService.findAllBooks().size());
        assertEquals("George Orwell", bookService.findAllBooks().get(1).getAuthor());

    }
}
