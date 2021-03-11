package localhost.clientdb.model.dao;

import localhost.clientdb.model.beans.Client;
import localhost.clientdb.util.DBConnection;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClient {
    private Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;

    public DAOClient(){
        this.con = new DBConnection().getConnection();
    }

    public void add(Client client){
        sql = "INSERT INTO clients (\"name\", cpf, address, cep, city, \"state\", " +
                "phone, email) values (?,?,?,?,?,?,?,?)";
        try {
            int i = 0;
            stmt = con.prepareStatement(sql);
            stmt.setString(++i, client.getName());
            stmt.setString(++i, client.getCpf());
            stmt.setString(++i, client.getAddress());
            stmt.setString(++i, client.getCep());
            stmt.setString(++i, client.getCity());
            stmt.setString(++i, client.getState());
            stmt.setString(++i, client.getPhone());
            stmt.setString(++i, client.getEmail());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Client client){
        sql = "UPDATE clients SET \"name\" = ?, cpf = ?, address = ?, cep = ?, " +
                "city = ?, \"state\" = ?, phone = ?, email = ? where \"id\" = ?";
        try {
            int i = 0;
            stmt = con.prepareStatement(sql);
            stmt.setString(++i, client.getName());
            stmt.setString(++i, client.getCpf());
            stmt.setString(++i, client.getAddress());
            stmt.setString(++i, client.getCep());
            stmt.setString(++i, client.getCity());
            stmt.setString(++i, client.getState());
            stmt.setString(++i, client.getPhone());
            stmt.setString(++i, client.getEmail());
            stmt.setInt(++i, client.getId());
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void delete(int id){
        sql = "DELETE FROM clients WHERE \"id\" = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Client> list(){
        List <Client> lst = new ArrayList<>();
        sql = "Select * from clients";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()){
                Client client = new Client();
                client.setId(rs.getInt(1));
                client.setName(rs.getString(2));
                client.setCpf(rs.getString(3));
                client.setAddress(rs.getString(4));
                client.setCep(rs.getString(5));
                client.setCity(rs.getString(6));
                client.setState(rs.getString(7));
                client.setPhone(rs.getString(8));
                client.setEmail(rs.getString(9));

                lst.add(client);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lst;}

    public Client searchById(int id){
        Client client = new Client();
        sql = "SELECT * FROM clients WHERE \"id\" = ?";
        try {
            stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.first();

            client.setId(rs.getInt(1));
            client.setName(rs.getString(2));
            client.setCpf(rs.getString(3));
            client.setAddress(rs.getString(4));
            client.setCep(rs.getString(5));
            client.setCity(rs.getString(6));
            client.setState(rs.getString(7));
            client.setPhone(rs.getString(8));
            client.setEmail(rs.getString(9));

            stmt.execute();
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Client not found",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return client;

    }

    public List<Client> searchByName(String name){
        Client client = new Client();
        List <Client> lst = new ArrayList<>();
        sql = "SELECT * FROM clients WHERE \"name\" like ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + name + '%');
            rs = stmt.executeQuery();

            while (rs.next()){
                client.setId(rs.getInt(1));
                client.setName(rs.getString(2));
                client.setCpf(rs.getString(3));
                client.setAddress(rs.getString(4));
                client.setCep(rs.getString(5));
                client.setCity(rs.getString(6));
                client.setState(rs.getString(7));
                client.setPhone(rs.getString(8));
                client.setEmail(rs.getString(9));

                lst.add(client);
            }

            stmt.execute();
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Client not found",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            //throwables.printStackTrace();
        }
        return lst;

    }
}
