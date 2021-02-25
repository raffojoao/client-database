package localhost.clientdb.model.dao;

import localhost.clientdb.model.beans.Client;
import localhost.clientdb.util.DBConnection;
import org.jetbrains.annotations.NotNull;

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

    public DAOClient(){
        this.con = new DBConnection().getConnection();
    }

    public void add(Client client){
        String sql = "INSERT INTO clients (\"name\", cpf, address, cep, city, \"state\", " +
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

    public void change(Client client){
        String sql = "UPDATE clients SET \"name\" = ?, cpf = ?, address = ?, cep = ?, " +
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
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    };

    public void delete(int id){
        try {
            stmt = con.prepareStatement("DELETE FROM clients WHERE \"id\" = ?");
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    };

    public List<Client> list(){
        List <Client> lst = new ArrayList<>();
        try {
            stmt = con.prepareStatement("Select * from clients");
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
        return lst;};
}
