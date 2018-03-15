package models;

import javax.persistence.*;


    public class Cakes {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long cakes_id;
        private String cakes_name;
        private String cakes_bagasy;
        private int srok_g;
        private Client client;


        public Cakes() {
        }
        public Cakes(String cakes_name, String cakes_bagasy, int srok_g) {
            this.cakes_name = cakes_name;
            this.cakes_bagasy = cakes_bagasy;
            this.srok_g = srok_g;
        }

        public long getCakes_id() { return cakes_id;
        }

        public void setCakes_id(long cakes_id) {
            this.cakes_id = cakes_id;
        }

        public String getCakes_name() {
            return cakes_name;
        }

        public void setCakes_name(String cakes_name) {
            this.cakes_name = cakes_name;
        }

        public String getCakes_bagasy() {
            return cakes_bagasy;
        }

        public void setCakes_bagasy(String cakes_bagasy) { this.cakes_bagasy = cakes_bagasy;
        }

        public int getSrok_g() {
            return srok_g;
        }

        public void setSrok_g(int srok_g) {
            this.srok_g = srok_g;
        }

        @ManyToOne
        @JoinColumn(name = "id")
        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

    }


