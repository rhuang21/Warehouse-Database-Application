package ca.ubc.cs304.Util;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class buildTableModel {
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        String[] columnNames = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = metaData.getColumnLabel(i + 1);
        }

        Object[][] data = new Object[50][columnCount];

        int rowIndex = 0;
        while (resultSet.next() && rowIndex < data.length) {
            for (int i = 0; i < columnCount; i++) {
                data[rowIndex][i] = resultSet.getObject(i + 1);
            }
            rowIndex++;
        }

        return new DefaultTableModel(data, columnNames);
    }
}
