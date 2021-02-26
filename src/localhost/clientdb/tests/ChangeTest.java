package localhost.clientdb.tests;

import localhost.clientdb.model.beans.Client;
import localhost.clientdb.model.dao.DAOClient;

import javax.swing.*;

public class ChangeTest {
    public static void main(String[] args) {
        Client c = new Client();
        c.setName("Ana Carolina");
        c.setPhone("(41)98854-0189");
        c.setAddress("Rua Frederico Wendler 49");
        c.setCity("Curitiba");
        c.setState("PR");
        c.setEmail("anacarolina.bt@hotmail.com");
        c.setCep("82220-327");
        c.setCpf("073.727.389-54");
        c.setId(2);

        DAOClient daoClient = new DAOClient();
        daoClient.update(c);
        JOptionPane.showMessageDialog(null,
                "Client has been successfully updated",
                "Client added",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
