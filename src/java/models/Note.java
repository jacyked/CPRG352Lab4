/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Matt
 */
public class Note implements Serializable {
    private String title;
    private String content;
    
    public Note(String t, String c){
        this.title = t;
        this.content = c;
    }
    public Note(){
        this.title = "";
        this.content = "";
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public void setTitle(String t){
        this.title = t;
    }
    public void setContent(String c){
        this.content = c;
    }
    
}
