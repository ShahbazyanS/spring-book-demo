package authorbookspring.demo.controller;

import authorbookspring.demo.model.Author;
import authorbookspring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/")
    public String homePage(){
        return "home";
    }
    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute Author author){
        authorRepository.save(author);
        return "redirect:/";
    }

    @GetMapping("/authorsPage")
    public String allAuthors(ModelMap map){
        List<Author> authors = authorRepository.findAll();
        map.addAttribute("authors", authors);
        return "authorsPage";
    }

    @GetMapping("/allAuthors")
    public String alAuthors(ModelMap map){
        List<Author> authors = authorRepository.findAll();
        map.addAttribute("authors", authors);
        return "home";
    }
    @GetMapping("/author")
    public String alllAuthors(ModelMap map){
        List<Author> authors = authorRepository.findAll();
        map.addAttribute("authors", authors);
        return "changeBook";
    }


    @GetMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("id") int id){
        authorRepository.deleteById(id);
        return "redirect:/authorsPage";
    }
    @GetMapping("/authorById")
    public String authorByIde(@RequestParam("id") int id, ModelMap map){
        Author author = authorRepository.getOne(id);
        map.addAttribute("author", author);
        return "changeAuthor";
    }

    @PostMapping("/change")
    public String changeAuthor(@ModelAttribute Author author){
        authorRepository.save(author);
        return "redirect:/";
    }
}
