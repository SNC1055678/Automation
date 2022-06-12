
package com.ybl.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

//@Data
@Getter @Setter
//@Jacksonized
//@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersPojoBuilder {


    public String name;
     public String job;
//    private int id;
//    private String createdAt;

/*

    public UsersPojo(String name, String job)
    {
        this.name = name;
        this.job = job;
//        this.createdAt= createdAt;
//        this.id = id;

    }

    public UsersPojo() {

    }

    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }


*/



}
