package com.it.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permisson {

    private Integer id;
    private String title;
    private String icon;
    private String link;
    private String type;
    private String code;
}
