package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String name;
    private LocalDate birth;
    private String phone;
    private String mail;
    private String address;
    private String cpf;

    public Customer(String name, LocalDate birth, String phone, String mail, String address, String cpf) {
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente: " + "Nome = " + name + ", Data de Nascimento = " + birth + ", Telefone = " + phone + ", E-Mail = " + mail + ", Endereço = " + address + ", CPF = " + cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;

        return Objects.equals(cpf, customer.cpf);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.getName());
    }
}
