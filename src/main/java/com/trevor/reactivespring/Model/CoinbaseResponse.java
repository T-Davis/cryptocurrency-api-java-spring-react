package com.trevor.reactivespring.Model;

public class CoinbaseResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private String base;
        private String currency;
        private String amount;

        public String getBase() {
            return base;
        }

        public String getCurrency() {
            return currency;
        }

        public String getAmount() {
            return amount;
        }
    }
}
