package com.groupe4.backoffice.service;
import com.groupe4.backoffice.dao.AdminDao;
import com.groupe4.backoffice.model.Admin;

public class AdminService {
    public static Admin findByCredentials(String email, String password) {return new AdminDao().findByCredentials(email, password);}
}
