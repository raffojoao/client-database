package localhost.clientdb.tests;

import localhost.clientdb.model.beans.Client;
import localhost.clientdb.model.dao.DAOClient;

import javax.swing.*;
import java.util.List;

public class AddTest {
    public static void main(String[] args) {
        Client c = new Client();
        c.setName("Ana Carolina");
        c.setPhone("(41)98854-0189");
        c.setAddress("Rua Frederico Wendler 49");
        c.setCity("Curitiba");
        c.setState("PR");
        c.setEmail("raffo.joao@gmail.com");
        c.setCep("82220-327");
        c.setCpf("073.727.389-54");

        DAOClient daoClient = new DAOClient();
        daoClient.add(c);
        JOptionPane.showMessageDialog(null,
                "Client has been successfully added",
                "Client added",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
