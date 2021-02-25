package localhost.clientdb.tests;

import localhost.clientdb.model.beans.Client;
import localhost.clientdb.model.dao.DAOClient;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        DAOClient daoClient = new DAOClient();
        List<Client> lst = daoClient.list();

        System.out.println("ID \t\tNAME \tCPF \tADDRESS \tCEP \tCITY \tSTATE \tPHONE \tE-MAIL");
        for (Client client : lst){
            System.out.println(client);
        }

    }
}
