package com.example.letschat.Model;

public class Chat {
    private String sender,receiver,message;
    Boolean isSeen;

    public Chat(String sender, String receiver, String message,Boolean isSeen) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.isSeen=isSeen;
    }
    public Chat(){

    }

    public Boolean getIsSeen() {
        return isSeen;
    }

    public void isSeen(Boolean isSeen) {
        this.isSeen = isSeen;
    }



    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
