package homework4.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository{
    private final Map<String, Book> books;

    public InMemoryBookRepository() {
        this.books = new HashMap<>();
        books.put("1", new Book("1", "1984", "George Orwell"));
        books.put("2", new Book("2", "Harry Potter and the Sorcerer’s Stone", "J.K. Rowling"));
        books.put("3", new Book("3", "Atlas shrugged", "Ayn Rand"));
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
