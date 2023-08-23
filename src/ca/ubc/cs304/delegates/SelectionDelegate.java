package ca.ubc.cs304.delegates;

import ca.ubc.cs304.UI.InterfaceUI;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public interface SelectionDelegate {
    void returnToMainMenu(InterfaceUI ui);
    DefaultTableModel doSelection(List<String> attributes, String table, String field1, String var1, String type1, String field2, String var2, String type2);
}
