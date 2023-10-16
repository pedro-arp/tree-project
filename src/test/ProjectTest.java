package test;


import model.Customer;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;



public class ProjectTest {

    public static void main(String[] args) {
        NavigableSet<Customer> customersSet = new TreeSet<>();
        NavigableMap<String, Customer> customersMap = new TreeMap<>();

        LocalDate customer1Birth = LocalDate.of(2002, Month.FEBRUARY, 24);
        Customer customer1 = new Customer("Pedro", customer1Birth, "1199999-0000", "rm95989@fiap.com.br", "FIAP - Lins de Vasconcelos", "123.456.789-10");

        LocalDate customer2Birth = LocalDate.of(2002, Month.JULY, 6);
        Customer customer2 = new Customer("Bianca", customer2Birth, "1199999-0000", "rm@fiap.com.br", "FIAP - Paulista", "123.456.789-11");

        customersSet.add(customer1);
        customersSet.add(customer2);

        for (Customer customer : customersSet) {
            System.out.println(customer);
        }

        System.out.println("-----");

        customersMap.put(customer1.getCpf(), customer1);
        customersMap.put(customer2.getCpf(), customer2);

        for (Map.Entry<String, Customer> entry : customersMap.entrySet()) {
            System.out.println("Cpf: " + entry.getKey() + " " + entry.getValue());
        }


    }
}
