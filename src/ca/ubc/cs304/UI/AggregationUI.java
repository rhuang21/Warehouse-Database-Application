package ca.ubc.cs304.UI;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import ca.ubc.cs304.delegates.AggregationDelegate;

import ca.ubc.cs304.database.DatabaseService;

import ca.ubc.cs304.entities.ItemCountEntity;
import ca.ubc.cs304.entities.DeliveryPeopleEntity;
import ca.ubc.cs304.entities.CustomerCountryEntity;

import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ca.ubc.cs304.controller.Warehouse;
import ca.ubc.cs304.database.DatabaseService;

public class AggregationUI extends InterfaceUI {

    private JTextField year;
    private JTextField month;
    private JTextField day;
    private InterfaceUI interfaceUI = this;
    private JButton mainMenu;
    private JPanel contentPane = new JPanel();

    public AggregationUI (AggregationDelegate delegate, DatabaseService ds) {
        JButton groupByButton = new JButton("See Item Count By Category");
        JButton havingButton = new JButton("See Most Common Customer Nationalities");
        JButton nestedButton = new JButton("See The Top Delivery People of The Day");
        JButton divisionButton = new JButton("See The Delivery People who has done a delivery from all warehouses");



        setContentPane(contentPane);

        // layout components using the GridBag layout manager
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        contentPane.setLayout(gb);
        contentPane.setBorder(BorderFactory.createEmptyBorder(155, 155, 155, 155));

        JLabel yearLabel = new JLabel("Enter year: ");
        JLabel monthLabel = new JLabel("Enter month (in number): ");
        JLabel dayLabel = new JLabel("Enter day: ");

        year = new JTextField("year (2023)",10);
        month = new JTextField("month (11)", 10);
        day = new JTextField("day (25)",10);


        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(10, 50, 10, 50);
        c.anchor = GridBagConstraints.CENTER;
        gb.setConstraints(groupByButton, c);
        contentPane.add(groupByButton);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(25, 50, 25, 50);
        c.anchor = GridBagConstraints.CENTER;
        gb.setConstraints(havingButton, c);
        contentPane.add(havingButton);


        c.insets = new Insets(35, 20, 45, 40);
        contentPane.add(yearLabel);

        c.insets = new Insets(35, 50, 45, 70);
        contentPane.add(year);
        year.setPreferredSize(new Dimension(5, 25));


        c.insets = new Insets(55, 20, 65, 40);
        contentPane.add(monthLabel);


        c.insets = new Insets(65, 20, 75, 40);
        contentPane.add(month);
        month.setPreferredSize(new Dimension(5, 25));


        c.insets = new Insets(75, 20, 85, 40);
        contentPane.add(dayLabel);

        c.insets = new Insets(85, 20, 95, 40);
        contentPane.add(day);
        day.setPreferredSize(new Dimension(5, 25));

        contentPane.add(Box.createVerticalStrut(5));

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(105, 50, 115, 50);
        c.anchor = GridBagConstraints.CENTER;
        gb.setConstraints(nestedButton, c);

        contentPane.add(nestedButton);

        mainMenu = new JButton("Main Menu");
        contentPane.add(mainMenu);

        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.returnToMainMenu(interfaceUI);
            }
        });

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(115, 50, 125, 50);
        c.anchor = GridBagConstraints.CENTER;
        gb.setConstraints(divisionButton, c);
        contentPane.add(divisionButton);

        groupByButton.addActionListener(new ActionListener() {
            ArrayList<ItemCountEntity> result = new ArrayList<ItemCountEntity>();
            public void actionPerformed(ActionEvent e) {
               DefaultTableModel defaultTableModel = ds.itemCountCategory();
                selectionPopulate(defaultTableModel, "Item Count Per Category");
            }

        });

        havingButton.addActionListener(new ActionListener() {
            ArrayList<CustomerCountryEntity> result = new ArrayList<CustomerCountryEntity>();

            public void actionPerformed(ActionEvent e) {
                DefaultTableModel defaultTableModel = ds.customerNationaities();
                selectionPopulate(defaultTableModel, "Most Common Customer Nationalities");
            }

        });

        nestedButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Boolean numbers = checkNumber(day.getText(), month.getText(), year.getText());

                if(numbers == true) {
                    DefaultTableModel defaultTableModel =ds.topDeliveryPersonOfTheDay(day.getText(), month.getText(), year.getText());
                    if (defaultTableModel == null) {
                        JOptionPane.showMessageDialog(contentPane, "No delivery person has delivered that day");

                    }

                    else {
                        selectionPopulate(defaultTableModel, "The Top Delivery People of The Day");
                    }
                }


            }

        });

        divisionButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DefaultTableModel defaultTableModel = ds.AllWareHousesDeliveryPeople();
                if(defaultTableModel == null) {
                    JOptionPane.showMessageDialog(contentPane, "No delivery person has delivered from all warehouses");
                }

                else {
                    selectionPopulate(defaultTableModel, "The Delivery People who has done a delivery from all warehouses");
                }
            }

        });

        pack();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void selectionPopulate(DefaultTableModel defaultTableModel, String tableName){
        JTable table = new JTable(defaultTableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame(tableName);
        frame.add(scrollPane);
        frame.setSize(1000,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public Boolean checkNumber (String day, String month, String year) {
        if (day == null) { JOptionPane.showMessageDialog(contentPane, "Please enter a valid day"); return false;}

        if (month == null) { JOptionPane.showMessageDialog(contentPane, "Please enter a valid month"); return false; }

        if (year == null) { JOptionPane.showMessageDialog(contentPane, "Please enter a valid year"); return false;}

        boolean yearIsNumeric = year.chars().allMatch( Character::isDigit );
        boolean monthIsNumeric = month.chars().allMatch( Character::isDigit );
        boolean dayINumeric = day.chars().allMatch( Character::isDigit );

        if (!(yearIsNumeric & monthIsNumeric & dayINumeric)) {
            JOptionPane.showMessageDialog(contentPane, "Please enter numbers");
            return false;
        }

        if ((Integer.parseInt(month) > 12) || (Integer.parseInt(month) < 1)) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid month");
            return null;
        }


        if (Integer.parseInt(month) == 2) {
            if ((Integer.parseInt(day) > 29) || (Integer.parseInt(day) < 1)) {
                JOptionPane.showMessageDialog(contentPane, "Please enter a valid day");
                return null;
            }
        }



        if (Integer.parseInt(month) == 2 || Integer.parseInt(month) == 6 || Integer.parseInt(month) == 9 || Integer.parseInt(month) == 11) {
            if ((Integer.parseInt(day) > 30) || (Integer.parseInt(day) < 1)) {
                JOptionPane.showMessageDialog(contentPane, "Please enter a valid day");
                return null;
            }
        }

        if (Integer.parseInt(month) == 1 || Integer.parseInt(month) == 3 || Integer.parseInt(month) == 5 ||  Integer.parseInt(month) == 7 ||
                Integer.parseInt(month) == 8 || Integer.parseInt(month) == 10 || Integer.parseInt(month) == 12) {
            if ((Integer.parseInt(day) > 31) || (Integer.parseInt(day) < 1)) {
                JOptionPane.showMessageDialog(contentPane, "Please enter a valid day");
                return null;
            }
        }
return true;
    }
}
