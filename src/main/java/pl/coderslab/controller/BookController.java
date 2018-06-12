package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @GetMapping("/addForm")
    public String formAdd(Model model){
        model.addAttribute("book", new Book());
        return "bookForm";

    }

    @PostMapping("/addForm")
    public String formAdd(@Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "bookForm";
        }
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "bookForm";

    }

    @GetMapping("")
    public String getAll(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "booksList";
    }

    @RequestMapping("/add")
    @ResponseBody
    public	String	add(){

        Publisher publisher = publisherDao.findById(1L);
        Author author = authorDao.findById(2L);
        List<Author> authorList = new ArrayList<>();
        authorList.add(author);

        Book book = new	Book();
        book.setTitle("JAVA BIBLE");
        book.setAuthors(authorList);
        book.setRating(10.0);
        book.setDescription(".. some description");
        book.setPublisher(publisher);
        bookDao.save(book);
        return	"Id	dodanej	książki	to:" + book.getId();
    }

    @RequestMapping("/update")
    @ResponseBody
    public	String	update(){
        Book book = new	Book();
        book.setId(3L);
        book.setTitle("Thinking	in Java");

        book.setDescription("description");
        book.setRating(9D);
        bookDao.save(book);
        return	"Id	zaktualizowanej książki	to:" + book.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){

        bookDao.deleteBook(bookDao.findById(id));
        return "redirect:/books";
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Book findId(@PathVariable long id){

        return bookDao.findById(id);
    }

    @GetMapping("/{rating}")
    @ResponseBody
    public List<Book> ratings(@PathVariable double rating){

        System.out.println(bookDao.getRatingList(rating));
        List<Book> list = bookDao.getRatingList(rating);
        return list;
    }



    @ModelAttribute("authorList")
    public List<Author> authorList(){
        return authorDao.findAll();
    }

    @ModelAttribute("publishersList")
    public List<Publisher> publishersList(){
        return publisherDao.findAll();
    }
}
