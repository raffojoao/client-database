package localhost.clientdb.util;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GridModel extends AbstractTableModel {

    private List<String> columns;
    private List<List<Object>> rows;

    public GridModel(){
        columns = new ArrayList<String>();
        rows = new ArrayList<List<Object>>();
    }

    public GridModel(String[] titles){
        columns = new ArrayList<String>();
        for(int i =0; i<titles.length; i++)
            columns.add(titles[i]);

        rows = new ArrayList<List<Object>>();
    }

    public GridModel(ResultSet resultSet, String[] titles){
        columns = new ArrayList<String>();
        rows = new ArrayList<List<Object>>();
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            if(titles != null){
                for(int i=0; i<titles.length;i++)
                    columns.add(titles[i]);
            } else {
                for(int i=1; i<=resultSetMetaData.getColumnCount();i++)
                    columns.add(resultSetMetaData.getColumnLabel(i));
            }

            while (resultSet.next()){
                ArrayList<Object> row = new ArrayList<Object>();
                for(int i=1; i<=resultSetMetaData.getColumnCount();i++)
                    row.add(resultSet.getObject(i));
                rows.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).get(columnIndex);
    }

    public List<List<Object>> getRows(){
        return rows;
    }

    public void deleteRow(int row){
        rows.remove(row);
    }

    public void insertRow(List<Object> row){
        rows.add(row);
    }

    public void clear(){
        rows.clear();
    }

    public String getColumnName(int index){
        return columns.get(index);
    }
}
