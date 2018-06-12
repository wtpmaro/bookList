package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @GetMapping("/add")
    public String add(Model model){
//        Person person = new Person();
//        person.setLogin("test1");
//        person.setPassword("test1");
//
//        personDao.save(person);
//
//        return "User added at id= " + person.getId();

        model.addAttribute("person", new Person());
        return "personForm";
    }

//    @PostMapping("/add")
//    public String add(@RequestParam Long id, @RequestParam String login, @RequestParam String password, @RequestParam String email, Model model){
//
//        Person person = new Person();
//        person.setId(id);
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//
//        System.out.println(person.getLogin());
//
//        personDao.save(person);
//
//        model.addAttribute("person", person);
//        return "personForm";
//    }


    @PostMapping("/add")
    public String add(@ModelAttribute Person person){

        personDao.save(person);

        return "personForm";
    }

    @GetMapping("/all")
    @ResponseBody
    public String all(){
        List<Person> persons = personDao.allPerson();

        return "User added at id= " + persons;
    }

}
