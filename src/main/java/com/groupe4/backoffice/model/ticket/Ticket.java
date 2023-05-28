package com.groupe4.backoffice.model.ticket;
public class Ticket {

        private int id;
        private String email;
        private int adminId;
        private String message;

        public Ticket() {
        }

        public Ticket(String email,int adminId, String message) {
            this.email = email;
            this.adminId = adminId;
            this.message = message;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAdminId() {
            return adminId;
        }

        public void setAdminId(int adminId) {
            this.adminId = adminId;
        }

        public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }


