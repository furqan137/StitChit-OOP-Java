/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stichit;

public class Administrator extends User{
    private String adminID;

    public Administrator(String username, String password, String name, String email, String adminID) {
        super(username, password, name, email);
        this.adminID = adminID;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Admin Info: " + name + ", " + email + ", ID: " + adminID);
    }
}
    

