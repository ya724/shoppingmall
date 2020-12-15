package com.micro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.pojo
 * @CreateTime: 2020-11-20 09:10
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String address_areaId;
    private String address_name;
    private String address_regionId;
}
