package localhost.clientdb.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Window();
    }

    public void Window(){

        this.setContentPane(contentPane);
        this.pack();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
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
        // TODO: place custom component creation code here
        String[] columns = {"ID", "Name", "Phone", "E-mail"};
        Object[][] data = {
                {"1","João","99999999","joao@joao.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"2","Ana","888888","ana@ana.com"},
                {"3","Luli","77777777","luli@cachorro.com.br"}
        };
        table1 = new JTable(data, columns);
        JScrollPane jScrollPane = new JScrollPane(table1);
        tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(1,1));
        tablePanel.add(jScrollPane);
    }
}
