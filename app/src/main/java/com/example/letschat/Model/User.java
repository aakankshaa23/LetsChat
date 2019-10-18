package com.example.letschat.Model;

public class User {
    private String id,username,ImageURL,status;

    public User(String id, String username, String ImageURL,String status) {
        this.id = id;
        this.username = username;
        this.ImageURL = ImageURL;
        this.status=status;
    }
    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageurl() {
        return ImageURL;
    }

    public void setImageurl(String Image_url) {
        this.ImageURL = Image_url;
    }
}
