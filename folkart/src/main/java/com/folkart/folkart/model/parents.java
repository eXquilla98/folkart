package com.folkart.folkart.model;

import jakarta.persistence.*;

@Entity
@Table(name="Parents")

public class parents {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private long id;
@Column(name = "parentName")
private String parentName;
@Column(name = "parentEmail")
private String parentEmail;
@Column(name = "parentPhoneNum")
private String parentPhoneNum;
@Column(name = "job")
private String job;

    public parents(String parentName, String parentEmail, String parentPhoneNum, String job) {
        this.parentName = parentName;
        this.parentEmail = parentEmail;
        this.parentPhoneNum = parentPhoneNum;
        this.job = job;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getParentPhoneNum() {
        return parentPhoneNum;
    }

    public void setParentPhoneNum(String parentPhoneNum) {
        this.parentPhoneNum = parentPhoneNum;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "parents{" +
                "id=" + id +
                ", parentName='" + parentName + '\'' +
                ", parentEmail='" + parentEmail + '\'' +
                ", parentPhoneNum='" + parentPhoneNum + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
