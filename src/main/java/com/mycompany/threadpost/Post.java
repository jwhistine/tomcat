/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threadpost;

/**
 *
 * @author mormon
 */
public class Post {
    public String user;
    public String date;
    public String post;

    public Post() {
        
    }
    
    public Post(String user, String date, String post) {
        this.user = user;
        this.date = date;
        this.post = post;
    }
   
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
