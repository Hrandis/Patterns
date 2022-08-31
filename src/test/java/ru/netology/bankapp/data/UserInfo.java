package ru.netology.bankapp.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo{
    private  String city;
    private String firstDate;
    private String secondDate;
    private  String name;
    private  String phoneNumber;

  //  public UserInfo(String city, String firstDate, String secondDate, String name, String phoneNumber){}
}
