package com.folkart.folkart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students" )
public class students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "nameIni")
    private String nameIni;
    @Column(name = "email")
    private  String email;

    public students(String fullName, String nameIni, String email) {
        this.fullName = fullName;
        this.nameIni = nameIni;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNameIni() {
        return nameIni;
    }

    public void setNameIni(String nameIni) {
        this.nameIni = nameIni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "students{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", nameIni='" + nameIni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
