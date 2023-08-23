package ca.ubc.cs304.UI;

import ca.ubc.cs304.delegates.MainMenuDelegate;
import ca.ubc.cs304.delegates.SelectionDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends InterfaceUI {
    private JButton itemUI;
    private JButton aggregationUI;
    private JButton selectionUI;
    private JButton workerUI;
    public MainMenuUI(MainMenuDelegate delegate) {
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        add(inputPanel, BorderLayout.CENTER);
        itemUI = new JButton("Items");
        aggregationUI = new JButton("Aggregate");
        selectionUI = new JButton("Queries");
        workerUI = new JButton("Workers");
        inputPanel.add(itemUI);
        inputPanel.add(aggregationUI);
        inputPanel.add(selectionUI);
        inputPanel.add(workerUI);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        itemUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.chooseUI("item");
            }
        });
        aggregationUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.chooseUI("aggregation");
            }
        });
        selectionUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.chooseUI("selection");
            }
        });
        workerUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.chooseUI("worker");
            }
        });
    }
}
