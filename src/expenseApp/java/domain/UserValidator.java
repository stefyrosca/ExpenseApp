package expenseApp.java.domain;

import expenseApp.java.exceptions.ValidatorException;
import utils.StringUtils;

public class UserValidator {

    public static boolean validate(User u) throws ValidatorException {
        if (StringUtils.isValid(u.getUsername()) && StringUtils.isValid(u.getPassword())) {
            return true;
        }
        throw new ValidatorException("User is not valid");
    }


}