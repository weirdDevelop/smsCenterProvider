package com.SMS.SMSCenter.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private int id;
    private String receiverNumber;
    private String message;
    private boolean isFlash;
    private boolean isUnicode;
    @JsonIgnore
    private HttpStatus httpStatus;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_id", nullable=false)
    private User user;



    public Message() {
        isFlash=false;
        isUnicode=true;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlash() {
        return isFlash;
    }

    public void setFlash(boolean flash) {
        isFlash = flash;
    }

    public boolean isUnicode() {
        return isUnicode;
    }

    public void setUnicode(boolean unicode) {
        isUnicode = unicode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", receiverNumber='" + receiverNumber + '\'' +
                ", message='" + message + '\'' +
                ", isFlash=" + isFlash +
                ", isUnicode=" + isUnicode +
                ", httpStatus=" + httpStatus +
                ", user=" + user +
                '}';
    }
}
