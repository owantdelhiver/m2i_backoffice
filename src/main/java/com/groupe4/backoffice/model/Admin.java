package com.groupe4.backoffice.model;

import com.groupe4.backoffice.dto.AdminDto;

public class Admin {

        private int adminId;
        private String firstname;
        private String lastname;
        private String email;
        private String password;


        public Admin(int id, String firstname, String lastname, String email, String password) {
            this.adminId = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.password = password;

        }

        public Admin(String firstname, String lastname, String email, String password) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.password = password;

        }

    public Admin(int adminId, String firstname, String lastname, String email) {
        this.adminId = adminId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public AdminDto toDto(){
        AdminDto dto = new AdminDto();
        dto.setAdminId(this.getAdminId());
        dto.setFirstname(this.getFirstname());
        dto.setLastname(this.getLastname());
        dto.setEmail(this.getEmail());
        return dto;
    }

    public int getAdminId() {
            return adminId;
        }

        public void setAdminId(int userId) {
            this.adminId = userId;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }




    }


