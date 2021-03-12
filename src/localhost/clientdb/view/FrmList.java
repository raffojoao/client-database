package localhost.clientdb.view;

import localhost.clientdb.model.dao.DAOClient;
import localhost.clientdb.util.GridModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FrmList extends JFrame{
    private JPanel contentPane;
    private JButton searchButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTable table1;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton exitButton;
    private JPanel tablePanel;


    public FrmList(String title){
        super(title);
        createWindow();
//        createTable();
    }

    public void createWindow(){

        this.setContentPane(contentPane);
        this.pack();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getID());
            }
        };
        addButton.addActionListener(listener);
        updateButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        viewButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        searchButton.addActionListener(listener);
    }



    public static void main(String[] args) {
        JFrame frame = new FrmList("Client Database");
        frame.setVisible(true);
    }


    private void createUIComponents() {
          tablePanel = new JPanel();
          createTable();
//        updateGrid();

    }

    private void createTable(){
        table1 = new JTable();
        JScrollPane jScrollPane = new JScrollPane(table1);
        tablePanel.add(jScrollPane);
        updateGrid();
    }

    private void updateGrid(){
        ResultSet rs = new DAOClient().loadGrid();
        table1.setModel(new GridModel(rs, new String[]{"ID", "Name", "CPF", "Address"
        , "CEP", "City", "State", "Phone", "E-mail"}));
        table1.setAutoResizeMode(1);
//        table1.getCo
    }
}
