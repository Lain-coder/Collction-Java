package com.list;

public class Book {



        String name;
        String author;
        int price;

        public Book() {}

        public Book(String name, String author, int price) {
            this.name = name;
            this.author = author;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "名称:"+ name + "\t\t作者:" + author +"\t\t价格:" + price;
        }

}
