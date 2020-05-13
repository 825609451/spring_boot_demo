package com.example.spring_boot_demo.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 *
 * @ClassName : User
 * @Description : 用户类
 * @Author : sky
 * @Date: 2020-05-10 21:24
 */
@Data
//@Entity
@Document("user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String phone;
    private String userName;
    private String remark;

    @GeoSpatialIndexed(type= GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint loc;
   //GeoJsonPoint loc = new GeoJsonPoint(lon, lat);
}
