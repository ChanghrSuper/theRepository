package com.chr.service;


import com.chr.entity.Admin;

public interface AdminService {

    Admin findByUsernamePassword(Admin admin);

    void addAdmin(Admin admin);

    Boolean isUsernameExist(String username);
}
