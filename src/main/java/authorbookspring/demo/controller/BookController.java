package authorbookspring.demo.controller;

import authorbookspring.demo.model.Book;
import authorbookspring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String addAuthor(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/books")
    public String allBooks(ModelMap map) {
        List<Book> books = bookRepository.findAll();
        map.addAttribute("books", books);
        return "booksPage";
    }
    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
    @GetMapping("/BookById")
    public String bookByIde(@RequestParam("id") int id, ModelMap map){
        Book book = bookRepository.getOne(id);
        map.addAttribute("book", book);
        return "changeBook";
    }
    @PostMapping("/changeB")
    public String changeAuthor(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/";
    }
}
