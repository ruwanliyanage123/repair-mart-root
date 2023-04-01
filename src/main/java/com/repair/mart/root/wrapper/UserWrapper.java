package com.repair.mart.root.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWrapper {
    private Integer id;
    private String name;
    private String email;
    private String contact;
    private String status;

    public UserWrapper(Integer id, String name, String contact, String email,  String status) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.status = status;
    }
}
