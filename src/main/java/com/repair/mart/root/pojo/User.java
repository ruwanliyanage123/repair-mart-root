package com.repair.mart.root.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQuery(name = "User.findByEmailId", query = "SELECT u FROM User u WHERE u.email=:email")//note:u.email mean the @Column(name = "email")
@NamedQuery(name = "User.getAllUser", query = "SELECT new com.repair.mart.root.wrapper.UserWrapper(u.id, u.name, u.contact, u.email, u.status) from User u where u.role='user'")//note:u.email mean the @Column(name = "email")
@NamedQuery(name = "User.getAllAdmin", query = "SELECT u.email from User u where u.role='admin'")//note:u.email mean the @Column(name = "email")
@NamedQuery(name = "User.updateStatus", query = "UPDATE User u SET u.status = :status WHERE u.id = :id")

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "role")
    private String role;
}




