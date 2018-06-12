package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;


@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate")
    public String validate(Model model){

        Book book = new Book();
        book.setTitle("tggggt");

//        StringBuffer resultText = new StringBuffer();

        Set<ConstraintViolation<Book>> violations	=	validator.validate(book);
        if(!violations.isEmpty()){
            model.addAttribute("validations", violations);
//            for(ConstraintViolation<Book> error : violations){
//                resultText.append(error.getPropertyPath() + " " + error.getMessage() );
//            }
        }

        return "validate";
    }

    @GetMapping("/validAuthor")
    @ResponseBody
    public String validAuthor(){
        Author author = new Author();
        author.setFirstName("Grzegorz");
        author.setLastName("Brzęczyszczykiewicz");
        author.setBirthDay(LocalDate.now().minusYears(10));

        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        StringBuffer resultText = new StringBuffer();
        if(!violations.isEmpty()){
            for(ConstraintViolation<Author> error : violations){
                resultText.append(error.getPropertyPath() + " " + error.getMessage() );
            }
        }else{
            resultText.append("No errors");
        }
        return resultText.toString();
    }

}

