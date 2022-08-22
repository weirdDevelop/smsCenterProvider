package com.SMS.SMSCenter.Repository;

import com.SMS.SMSCenter.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {

}
