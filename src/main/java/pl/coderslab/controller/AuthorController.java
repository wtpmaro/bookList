package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    @GetMapping("/addForm")
    public String formAdd(Model model){
        model.addAttribute("author", new Author());
        return "authorForm";

    }

    @PostMapping("/addForm")
    public String formAdd(@Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "authorForm";
        }
        authorDao.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model){
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "authorForm";

    }

    @GetMapping("")
    public String getAll(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "authorList";
    }



    @RequestMapping("/add")
    @ResponseBody
    public	String	add(){
        Author author = new	Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        authorDao.save(author);
        return	"Id dodanego autora to:" + author.getId();
    }

    @RequestMapping("/update")
    @ResponseBody
    public	String	update(){
        Author author = new	Author();
        author.setId(1L);
        author.setFirstName("Bruce");
        author.setLastName("Wszechmogący");
        authorDao.save(author);
        return	"Id zaktualizowanego autora to:" + author.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){

        authorDao.delete(authorDao.findById(id));

        return "redirect:/authors";
    }

    @GetMapping("/find/{id}")
    public Author findId(@PathVariable long id){
        return authorDao.findById(id);
    }
}
