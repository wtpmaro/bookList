package pl.coderslab.validation;

import pl.coderslab.entity.Author;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AdultValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Adult {

    String	message()	default	"{validation.Adult.error.message}";
    Class<?>[]	groups()	default	{};
    Class<?	extends Payload>[]	payload()	default	{};

}
