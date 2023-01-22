package ru.netology;

import java.util.Objects;

public class Tickets implements Comparable<Tickets> { //класс для информации о билете

    private int id; //уникальный идектификатор билетв
    private int price; //стоимость билета
    private String depAirport; // аэропорт вылета
    private String arrAirport; // аэропорт прибытия
    private int travelTime; // время в пути в минутах


    public Tickets(int id, int price, String depAirport, String arrAirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Tickets o) {
        if (price < o.price) {
            return -1;
        }
        if (price > o.price) {
            return 1;
        }
        return 0;
    }

}
