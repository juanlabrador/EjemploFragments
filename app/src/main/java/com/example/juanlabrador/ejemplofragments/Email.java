package com.example.juanlabrador.ejemplofragments;

/**
 * Created by juanlabrador on 06/10/14.
 */
public class Email {

    private String by;
    private String matter;
    private String text;

    public Email(String by, String matter, String text){
        this.by = by;
        this.matter = matter;
        this.text = text;
    }

    public String getBy(){
        return by;
    }

    public String getMatter(){
        return matter;
    }

    public String getText(){
        return text;
    }
}
