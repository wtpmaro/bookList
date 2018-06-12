package pl.coderslab.validation;

import sun.util.resources.LocaleData;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdultValidation implements ConstraintValidator<Adult, LocalDate> {

    @Override
    public void initialize(Adult adult) {

    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext constraintValidatorContext) {
      return LocalDate.now().isAfter(birthDate.plusYears(18));
    }
}
