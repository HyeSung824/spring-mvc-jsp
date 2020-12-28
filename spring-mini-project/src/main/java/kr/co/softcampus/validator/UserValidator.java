package kr.co.softcampus.validator;

import kr.co.softcampus.beans.UserBean;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by 김홍준
 * Date: 2020-12-28
 * Time: 오전 11:37
 */
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserBean.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserBean userBean = (UserBean)target;
        String user_pw = userBean.getUser_pw();
        String user_pw2 = userBean.getUser_pw2();

        if(!user_pw.equals(user_pw2)){
            errors.rejectValue("user_pw", "NotEquals");
            errors.rejectValue("user_pw2", "NotEquals");
        }

        if(!userBean.isUserIdExist()){
            errors.rejectValue("user_id", "DontCheckUserIdExist");
        }
    }
}
