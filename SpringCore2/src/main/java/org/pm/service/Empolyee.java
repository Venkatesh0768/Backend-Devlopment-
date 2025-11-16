package org.pm.service;

public class Empolyee {
    private Integer id;
    private String name;
    private String city;
    private Integer salary;

    public Empolyee(Integer id, String name, String city, Integer salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
    }

    public void empolyeeTask(){
        System.out.println("The Productive is feel of begin productive");
    }

    @Override
    public String toString() {
        return "Empolyee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }
}
