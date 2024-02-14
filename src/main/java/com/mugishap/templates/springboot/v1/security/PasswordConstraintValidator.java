package com.mugishap.templates.springboot.v1.security;


import com.google.common.base.Joiner;
import com.mugishap.templates.springboot.v1.payload.ApiResponse;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        PasswordValidator validator = new PasswordValidator(
                Arrays.asList(new LengthRule(8, 30),
                        new AlphabeticalSequenceRule(3, false),
                        new NumericalSequenceRule(3, false),
                        new UppercaseCharacterRule(1),
                        new SpecialCharacterRule(1),
                        new DigitCharacterRule(1),
                        new QwertySequenceRule(3, false),
                        new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        System.out.println(validator.getMessages(result));
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(Joiner.on(",").join(validator.getMessages(result)))
                .addConstraintViolation();
        return false;
    }
}
