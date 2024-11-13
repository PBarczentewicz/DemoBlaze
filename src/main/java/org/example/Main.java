package org.example;

import org.example.login.Login;

public class Main {
    public static void main(String[] args){
        Login login = new Login();
        login.logIn("admin", "admin");
    }
}