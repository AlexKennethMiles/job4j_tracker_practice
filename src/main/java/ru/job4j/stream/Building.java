package ru.job4j.stream;

public class Building {
    private int id;
    private String location;
    private String type;
    private double square;
    private int capacity;
    private String architect;
    private String customer;

    static class Builder {
        private int id;
        private String location;
        private String type;
        private double square;
        private int capacity;
        private String architect;
        private String customer;

        Builder buildID(int id) {
            this.id = id;
            return this;
        }

        Builder buildLocation(String location) {
            this.location = location;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildSquare(double square) {
            this.square = square;
            return this;
        }

        Builder buildCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        Builder buildArchitect(String architect) {
            this.architect = architect;
            return this;
        }

        Builder buildCustomer(String customer) {
            this.customer = customer;
            return this;
        }

        Building build() {
            Building building = new Building();
            building.id = id;
            building.location = location;
            building.type = type;
            building.square = square;
            building.capacity = capacity;
            building.architect = architect;
            building.customer = customer;
            return building;
        }
    }

    @Override
    public String toString() {
        return "Building{"
                + " id=" + id
                + ", location='" + location + '\''
                + ", type='" + type + '\''
                + ", square=" + square
                + ", capacity=" + capacity
                + ", architect='" + architect + '\''
                + ", customer='" + customer + '\''
                + '}';
    }

    public static void main(String[] args) {
        Building building = new Builder()
                .buildID(1)
                .buildLocation("Russia, Moscow, Kosygin street, 15")
                .buildType("Headquarters")
                .buildSquare(1200D)
                .buildCapacity(4500)
                .buildArchitect("Lee Polisano")
                .buildCustomer("Yandex")
                .build();
        System.out.println(building);
    }
}
