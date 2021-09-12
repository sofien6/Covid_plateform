/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashbord;

/**
 *
 * @author Click
 */
public class ModelTable {
    String fullname,age,address,gender,email,phone; 
    public ModelTable(String fullname,String age, String gender,String address, String email, String phone){
        this.fullname = fullname;
        this.age = age; 
        this.email = email;  
        this.gender = gender; 
        this.phone = phone; 
        this.address = address;
    }
    public String getFullName(){
        return this.fullname;
    }
    public String getAge(){
        return this.age;
    }
    public String getEmail(){
        return this.email;
    }
    public String getGender(){
        return this.gender;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setId(String fullname){
        this.fullname = fullname; 
    }
}
