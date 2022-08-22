package com.SMS.SMSCenter.Repository;

import com.SMS.SMSCenter.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Integer>, CustomUserRepository {

}
