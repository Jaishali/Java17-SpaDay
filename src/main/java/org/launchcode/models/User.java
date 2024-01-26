package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
    private static int nextId =1;
//    private final int id;

@Size(min=5, max=15, message ="Username must be 5-15 characters long." )
    private String username;
@Email(message = "Invalid email format.")
    private String email;
    @Size(min=6, message ="Password must be 6 characters long." )

    private String password;
    //private final LocalDate dateRegistered;
    @NotNull(message = "Passwords do not match .")
    private String verifyPassword;
    public User(){

    }

    public User(String username, String email, String password,String verifyPassword) {
       // this.id = nextId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
        //this.dateRegistered= LocalDate.now();
        nextId++;
    }

   /* public int getId() {
        return id;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
/* public LocalDate getDateRegistered() {
        return dateRegistered;
    }*/

    public void setPassword(String password)
    {
        this.password = password;
        checkPassword();
    }
    private void checkPassword(){
        if(password == null && verifyPassword == null && !password.equals(verifyPassword)){
            setVerifyPassword(null);
        }

    }
}
