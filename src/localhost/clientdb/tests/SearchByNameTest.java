package localhost.clientdb.tests;

import localhost.clientdb.model.beans.Client;
import localhost.clientdb.model.dao.DAOClient;

import java.util.List;

public class SearchByNameTest {
    public static void main(String[] args) {

        DAOClient daoClient = new DAOClient();
        List<Client> lst = daoClient.searchByName("Ana");

        for (Client client : lst){
            System.out.println(client);
        }

    }
}
