package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer user_id;
    private String user_name;
    private Integer user_status;
    private String user_nickname;
    private String user_password;
    private String user_realname;
    private String user_gender;
    private String user_address;
    private String user_birthday;
    private String user_homeplace;
    private String user_profile_picture_src;

}
