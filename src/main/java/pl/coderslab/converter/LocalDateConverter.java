package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.time.LocalDate;

public class LocalDateConverter implements Converter<String, LocalDate> {


    @Override
    public LocalDate convert(String date) {
        return LocalDate.parse(date);
    }
}
