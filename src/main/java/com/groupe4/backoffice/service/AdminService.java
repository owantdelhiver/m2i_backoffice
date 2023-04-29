package com.groupe4.backoffice.service;
import com.groupe4.backoffice.dao.AdminDao;
import com.groupe4.backoffice.dto.AdminDto;
import com.groupe4.backoffice.model.Admin;

import java.util.List;
import java.util.stream.Collectors;

public class AdminService {

    public static Admin findByCredentials(String email, String password) {return new AdminDao().findByCredentials(email, password);}

    public List<AdminDto> findAll() {
        return AdminDao.findAll().stream()
                .map(admin -> admin.toDto())
                .collect(Collectors.toList());
    }

}
