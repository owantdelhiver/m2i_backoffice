package com.groupe4.backoffice.model.ticket;
public class Ticket {

        private int id;
        private String email;
        private String message;

        public Ticket() {
        }

        public Ticket(String email, String message) {
            this.email = email;
            this.message = message;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


