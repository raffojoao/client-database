package localhost.clientdb.tests;

import localhost.clientdb.model.dao.DAOClient;

import javax.swing.*;

public class DeleteTest {
    public static void main(String[] args) {
        DAOClient daoClient = new DAOClient();
        daoClient.delete(3);

        JOptionPane.showMessageDialog(null, "Client deleted");

    }
}
