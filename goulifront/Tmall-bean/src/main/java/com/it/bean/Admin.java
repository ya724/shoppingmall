package com.it.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer admin_id;
    private String admin_name;
    private Integer admin_status;
    private String admin_nickname;
    private String admin_password;
    private String admin_profile_picture_src="http://172.81.235.217:8080/group1/M00/00/00/rBEACF-rTiaAcC05AAA-lfK-tcs736.jpg";
    private Integer admin_del;

    //角色信息
    private String roles;

}
