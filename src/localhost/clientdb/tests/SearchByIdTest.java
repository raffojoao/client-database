package localhost.clientdb.tests;

import localhost.clientdb.model.beans.Client;
import localhost.clientdb.model.dao.DAOClient;

public class SearchByIdTest {
    public static void main(String[] args) {
        DAOClient daoClient = new DAOClient();

        Client c = daoClient.searchById(4);
        System.out.println(c);
    }
}
