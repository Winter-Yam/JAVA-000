package com.example.testhibernate.entity;

import java.sql.Blob;
import java.util.Arrays;

/**
 * @author Winter
 * @Project test-hibernate
 * @Package com.example.testhibernate.entity
 * @Title User.java
 * @Email yanwt@vastdata.com.cn
 * @modified
 * @date 2020年12月25 15:26:03
 * @Copyright 广州云图数据技术有限公司
 * @Description 此处添加该类的详细说明
 */
public class User implements java.io.Serializable {
    private Integer id;
    private String username;

    private Blob fileEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Blob getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(Blob fileEntity) {
        this.fileEntity = fileEntity;
    }
}
