package com.SMS.SMSCenter.Repository;

import com.SMS.SMSCenter.Model.User;

public interface CustomUserRepository {

    User findUser(int id);
    boolean checkValidation(User user);

    boolean checkLimit(User user);



}
