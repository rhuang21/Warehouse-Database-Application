package ca.ubc.cs304.UI;

import ca.ubc.cs304.delegates.WorkerDelegate;
import ca.ubc.cs304.entities.WorkerEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class WorkerUI extends InterfaceUI {

    private JRadioButton workerID, clothingSize, name;
    private JButton showSelected;
    private JButton mainMenu;
    private InterfaceUI interfaceUI = this;

    public WorkerUI(WorkerDelegate delegate) {
        setTitle("Worker Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        add(inputPanel, BorderLayout.CENTER);

        workerID = new JRadioButton("Worker ID");
        clothingSize = new JRadioButton("Clothing Size");
        name = new JRadioButton("Name");
        showSelected = new JButton("Project Selected Worker Attributes");
        mainMenu = new JButton("Main Menu");
        inputPanel.add(mainMenu);
        inputPanel.add(workerID);
        inputPanel.add(clothingSize);
        inputPanel.add(name);
        inputPanel.add(showSelected);
        this.setSize(1000,700);
        setLocationRelativeTo(null);
        setVisible(true);

        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.returnToMainMenu(interfaceUI);
            }
        });
        showSelected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<WorkerEntity> listofWorkerAttributes = delegate.projectSelectedWorkerAttributes(workerID.isSelected(),clothingSize.isSelected(), name.isSelected());
                StringBuilder columns = new StringBuilder();
                if (workerID.isSelected()) {
                    columns.append("WORKERID, ");
                }
                if (clothingSize.isSelected()) {
                    columns.append("CLOTHINGSIZE, ");
                }
                if (name.isSelected()) {
                    columns.append("NAME, ");
                }
                if (columns.charAt(columns.length() - 1) == ' ') {
                    columns.delete(columns.length() - 2, columns.length());
                }
                String columnsString = columns.toString();
                String[] column = columnsString.split(", ");
                DefaultTableModel defaultTableModel = new DefaultTableModel(column, 0);
                JTable itemTable = new JTable(defaultTableModel);
                JScrollPane scrollPane = new JScrollPane(itemTable);

                JFrame frame = new JFrame("Workers Table");
                frame.add(scrollPane);

                for(WorkerEntity worker : listofWorkerAttributes){
                    int i = 0;
                    Object[] itemData = new Object[3];
                    if (workerID.isSelected()) {
                        itemData[i] = worker.getWorkerID();
                        i++;
                    }
                    if (clothingSize.isSelected()) {
                        itemData[i] = worker.getClothingSize();
                        i++;
                    }
                    if (name.isSelected()) {
                        itemData[i] = worker.getName();
                    }
                    defaultTableModel.addRow(itemData);
                }

                frame.setSize(1200,500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
