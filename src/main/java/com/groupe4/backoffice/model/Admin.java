package com.groupe4.backoffice.model;

public class Admin {

        private int userId;
        private String firstname;
        private String lastname;
        private String email;
        private String password;


        public Admin(int id, String firstname, String lastname, String email, String password) {
            this.userId = id;
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

        public int getAdminId() {
            return userId;
        }

        public void setAdminId(int userId) {
            this.userId = userId;
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


