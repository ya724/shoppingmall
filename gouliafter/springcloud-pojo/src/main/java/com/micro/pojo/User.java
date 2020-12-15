package com.micro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.pojo
 * @CreateTime: 2020-11-19 15:38
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer user_id;
    private String user_name;
    private String user_nickname;
    private Integer user_status;
    private String user_password;
    private String user_realname;
    private String user_gender;
    private String user_address;
    private String user_birthday;
    private String user_homeplace;
    private String user_profile_picture_src;
    private String user_phone;
}
