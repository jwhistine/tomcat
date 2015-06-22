/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threadpost;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mormon
 */
public class PostDataHandler {
    public List<Post> getPosts() {
        List<Post> myList = new ArrayList<Post>();
        
        //String path = "C:\\Users\\mormon\\Documents\\NetBeansProjects\\threadPost\\src\\main\\java\\com\\mycompany\\threadpost\\posts.txt";
        String dir = System.getenv("OPENSHIFT_DATA_DIR");
        String path = "/posts.txt";
        String fullPath = dir + path;
        try {
            FileReader file = new FileReader(fullPath);
            BufferedReader read = new BufferedReader(file);
            String line  = null;
            while ((line = read.readLine()) != null) {
                String string[] = line.split(",");
                Post post = new Post(string[0], string[1], string[2]);
                myList.add(post);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return myList;
    }
}
