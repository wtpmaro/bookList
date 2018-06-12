package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    @GetMapping("/addForm")
    public String formAdd(Model model){
        model.addAttribute("publisher", new Publisher());
        return "publisherForm";

    }

    @PostMapping("/addForm")
    public String formAdd(@Valid Publisher publisher, BindingResult result){
            if(result.hasErrors()){
                return "publisherForm";
            }
        publisherDao.save(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model){
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "publisherForm";

    }

    @GetMapping("")
    public String getAll(Model model){
        model.addAttribute("publishers", publisherDao.findAll());
        return "publisherList";
    }



    @GetMapping("/add")
    @ResponseBody
    public	String	add(){
        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherDao.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Helion");
        publisherDao.save(publisher);
        return	"Id dodanego wydawcy to:" + publisher.getId();
    }

    @RequestMapping("/update")
    @ResponseBody
    public	String	update(){
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("wwwwwwwww");
        publisherDao.save(publisher);
        return	"Id zaktualizowanego wydawcy to:" + publisher.getId();
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable long id){

        publisherDao.delete(publisherDao.findById(id));
        return "redirect:/publishers";
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Publisher findId(@PathVariable long id){

        return publisherDao.findById(id);
    }
}
