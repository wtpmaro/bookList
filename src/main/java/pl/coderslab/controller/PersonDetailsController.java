package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.dto.PersonDTO;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/persondetails")
public class PersonDetailsController {

    @Autowired
    private PersonDetailsDao personDetailsDao;

    @Autowired
    private PersonDao personDao;

    @ModelAttribute("country")
    public List<String> checkOptions() {
        String a[] = new String[] {"Poland", "USA", "Germany", "France"};
        return	Arrays.asList(a);
    }

    @ModelAttribute("hobbies")
    public Collection<String> hobbies()	{
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("Movies");
        hobbies.add("Books");
        hobbies.add("Games");
        hobbies.add("Sport");
        return	hobbies;
    }

    @ModelAttribute("programmingSkills")
    public	Collection<String>	skills()	{
        List<String>	skills	=	new	ArrayList<String>();
        skills.add("Java");
        skills.add("Php");
        skills.add("python");
        skills.add("ruby");
        return	skills;
    }
//    @ModelAttribute("skills")
//    public	List<String>	checkskills()	{
//        String	a[]	=	new	String[]	{"java",	"php",	"ruby",	"python"};
//        return	Arrays.asList(a);
//    }

    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("personDTO", new PersonDTO());
        return "personDTOForm";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@ModelAttribute PersonDTO person) {

        return "LOGIN:" + person.getLogin() + " PASSWORD:" + person.getPassword() + " EMAIL:" + person.getEmail()+ "\n" +
                " Notes: " + person.getNotes() + " Mailinglist email: "+ person.getEmail()+" Hobbies: " + person.getHobbies();
    }

    @GetMapping("/add/{id}")
    @ResponseBody
    public String add(@PathVariable long id) {

        Person person = personDao.findById(id);
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("ALeksy");
        personDetails.setLastName("Bondarczuk");
        personDetails.setPerson(person);

        personDetailsDao.save(personDetails);

        return "User added at id= " + personDetails.getId();
    }

    @GetMapping("/all")
    @ResponseBody
    public String all() {
        List<PersonDetails> personsDetails = personDetailsDao.allPerson();

        return "Persons details= " + personsDetails;
    }



}
