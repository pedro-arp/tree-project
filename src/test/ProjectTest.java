package test;


import model.Customer;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class ProjectTest {
    private static boolean isDuplicateCPF(Customer customer, Set<Customer> customersSet) {
        return customersSet.stream().anyMatch(existingCustomer -> existingCustomer.getCpf().equals(customer.getCpf()));
    }

    public static Customer findCustomerByCPF(String cpf, List<Customer> customerList) {
        for (Customer customer : customerList) {
            if (customer.getCpf().equals(cpf)) {
                return customer;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        NavigableSet<Customer> customersSet = new TreeSet<>();
        NavigableMap<String, Customer> customersMap = new TreeMap<>();
        List<Customer> customersList = new ArrayList<>();

        LocalDate customer1Birth = LocalDate.of(2002, Month.FEBRUARY, 24);
        Customer customer1 = new Customer("Pedro", customer1Birth, "1199999-0001", "rm95989@fiap.com.br", "FIAP - Lins", "123.456.789-01");
        LocalDate customer2Birth = LocalDate.of(2002, Month.JULY, 6);
        Customer customer2 = new Customer("Bianca", customer2Birth, "1199999-0002", "rm2@fiap.com.br", "FIAP - Paulista", "123.456.789-02");
        LocalDate customer3Birth = LocalDate.of(1997, Month.JANUARY, 14);
        Customer customer3 = new Customer("Rafael", customer3Birth, "1199999-0003", "rm3@fiap.com.br", "FIAP - Modulo", "123.456.789-03");

        customersList.add(customer1);
        customersList.add(customer2);
        customersList.add(customer3);

        for (Customer customer : customersList) {
            if (isDuplicateCPF(customer, customersSet)) {
                System.out.println("Erro: CPF duplicado - " + customer.getCpf());
            } else {
                customersSet.add(customer);
                customersMap.put(customer.getCpf(), customer);
            }
        }
        String cpfToFind = "123.456.789-01";
        Customer foundCustomer = findCustomerByCPF(cpfToFind, customersList);

        if (foundCustomer != null) {
            System.out.println("Cliente encontrado: " + foundCustomer);
        } else {
            System.out.println("Cliente com CPF " + cpfToFind + " não encontrado.");
        }
        System.out.println("-");
        for (Map.Entry<String, Customer> entry : customersMap.entrySet()) {
            System.out.println("Cpf: " + entry.getKey() + " | " + entry.getValue());
        }
        System.out.println("-");
        for (Customer customer : customersSet) {
            System.out.println(customer);
        }


    }
}

