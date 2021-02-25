package localhost.clientdb.model.beans;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
    private int id;
    private String name,
            address,
            city,
            state,
            email,
            phone,
            cep,
            cpf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String uf) {
        this.state = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && cep == client.cep && cpf == client.cpf && Objects.equals(name, client.name) &&
                Objects.equals(address, client.address) && Objects.equals(city, client.city) &&
                Objects.equals(state, client.state) && Objects.equals(email, client.email) &&
                Objects.equals(phone, client.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, cpf, name, address, city, state, email, phone);
    }

    @Override
    public String toString() {
        return this.getId() + "\t" +
                this.getName() + "\t" +
                this.getCpf() + "\t" +
                this.getAddress() + "\t" +
                this.getCep() + "\t" +
                this.getCity() + "\t" +
                this.getState() + "\t" +
                this.getPhone() + "\t" +
                this.getEmail();
    }
}
