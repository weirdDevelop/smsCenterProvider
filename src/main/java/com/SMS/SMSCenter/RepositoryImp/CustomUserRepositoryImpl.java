package com.SMS.SMSCenter.RepositoryImp;

import com.SMS.SMSCenter.Repository.CustomUserRepository;
import com.SMS.SMSCenter.Model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Transactional
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findUser(int id) {

        try {
            User user = entityManager.find(User.class, id);
            return user;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkValidation(User user) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        if(user.getExpireDate().isAfter(now)) {
            if(user.isLimit())
            {
                if(checkLimit(user))
                    return true;
                else
                    return false;

            }else
                return true;
        }
        return false;
    }

    @Override
    public boolean checkLimit(User user) {

        if(user.getLimitNumber()>0)
        {
            long Limit=user.getLimitNumber();
            --Limit;
            user.setLimitNumber(Limit);
            return true;
        }else
            return false;
    }
}
