/*
 * Copyright (C) 2017 derekgreene
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main_window {

    private JFrame main_window;
    private JTextField main_username_entry;
    private JPasswordField main_password_entry;
    public JFrame component_window;
    public JTable table;
    public JTextField component_window_search_entry;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main_window window = new main_window();
                    window.main_window.setVisible(true);
                    component_window window1 = new component_window();
                    window1.component_window.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public main_window() {
        initialize();
    }

    private void initialize() {
        component_window = new JFrame();
        component_window.setMinimumSize(new Dimension(800, 400));
        component_window.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        component_window.setTitle("The Greene's Library");
        component_window.setResizable(false);
        SpringLayout springLayout1 = new SpringLayout();
        component_window.getContentPane().setLayout(springLayout1);
        component_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        component_window.getContentPane().setBackground(new Color(51, 204, 204));
        component_window.pack();
        component_window.setLocationRelativeTo(null);

        JList list = new JList();
        springLayout1.putConstraint(SpringLayout.SOUTH, list, 346, SpringLayout.NORTH,
                component_window.getContentPane());
        list.setForeground(new Color(51, 204, 204));
        springLayout1.putConstraint(SpringLayout.NORTH, list, 0, SpringLayout.NORTH, component_window.getContentPane());
        springLayout1.putConstraint(SpringLayout.WEST, list, 5, SpringLayout.WEST, component_window.getContentPane());
        list.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        list.setModel(new AbstractListModel() {
            String[] values = new String[]{"Games", "Books", "Movies", "Devices"};

            public int getSize() {
                return values.length;
            }

            public Object getElementAt(int index) {
                return values[index];
            }
        });
        component_window.getContentPane().add(list);

        JMenuBar component_menubar = new JMenuBar();
        component_window.setJMenuBar(component_menubar);

        JMenu component_file = new JMenu("File");
        component_menubar.add(component_file);

        JMenuItem mntmNewEntry = new JMenuItem("New Entry");
        component_file.add(mntmNewEntry);

        JMenuItem mntmEditEntry = new JMenuItem("Edit Entry");
        component_file.add(mntmEditEntry);

        JMenuItem mntmSave = new JMenuItem("Save");
        component_file.add(mntmSave);

        JMenuItem component_file_gnupliclicense = new JMenuItem("GNU Public License");
        component_file.add(component_file_gnupliclicense);

        JMenuItem component_file_exit = new JMenuItem("Exit");
        component_file.add(component_file_exit);

        JMenu component_about = new JMenu("About");
        component_menubar.add(component_about);

        JMenuItem component_about_aboutthedeveloper = new JMenuItem("About the Developer");
        component_about.add(component_about_aboutthedeveloper);

        JMenuItem component_about_abouttheprogram = new JMenuItem("About the Program");
        component_about.add(component_about_abouttheprogram);

        String[] columnnames = {"Name of Item", "Location", "Borrower", "Date", "Time"};

        Object[][] data = {{"BookTest1", "Home", "Conner", "03/06/2017", "10:23", false},
        {"BookTest2", "Home", "NA", "03/13/2017", "NA", false},
        {"BookTest3", "School", "Lisa", "03/12/2017", "1:57", false},
        {"BookTest4", "Camping", "Jena", "03/13/2017", "15:04", false},
        {"BookTest5", "Home", "NA", "02/28/2017", "NA", true},
        {"BookTest6", "Home", "NA", "03/10/2017", "NA", false},
        {"BookTest7", "Home", "NA", "03/10/2017", "NA", false},
        {"BookTest8", "Home", "NA", "03/10/2017", "NA", false},
        {"BookTest9", "Home", "NA", "03/10/2017", "NA", false},
        {"BookTest10", "Home", "NA", "03/10/2017", "NA", false},
        {"BookTest11", "Home", "NA", "03/10/2017", "NA", false},
        {"BookTest12", "Home", "NA", "03/10/2017", "NA", false},
        {"BookTest13", "Home", "NA", "03/10/2017", "NA", false}};

        JScrollPane scrollPane = new JScrollPane();
        springLayout1.putConstraint(SpringLayout.WEST, scrollPane, 6, SpringLayout.EAST, list);
        springLayout1.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, list);
        springLayout1.putConstraint(SpringLayout.EAST, scrollPane, 674, SpringLayout.EAST, list);
        scrollPane.setPreferredSize(new Dimension(4, 8));
        scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setAutoscrolls(true);
        component_window.getContentPane().add(scrollPane);

        table = new JTable(data, columnnames);
        table.setRowMargin(5);
        table.setRowHeight(28);
        scrollPane.setViewportView(table);
        springLayout1.putConstraint(SpringLayout.NORTH, table, 44, SpringLayout.NORTH, list);
        springLayout1.putConstraint(SpringLayout.WEST, table, 28, SpringLayout.EAST, list);
        springLayout1.putConstraint(SpringLayout.EAST, table, 1052, SpringLayout.EAST, list);
        table.setAlignmentX(Component.RIGHT_ALIGNMENT);
        table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        table.setMinimumSize(new Dimension(75, 107));
        table.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        table.setSelectionBackground(new Color(0, 204, 204));
        table.setSelectionForeground(new Color(255, 255, 255));

        JButton component_window_checkin = new JButton("Check In");
        springLayout1.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, component_window_checkin);
        springLayout1.putConstraint(SpringLayout.NORTH, component_window_checkin, 15, SpringLayout.NORTH, list);
        springLayout1.putConstraint(SpringLayout.WEST, component_window_checkin, 6, SpringLayout.EAST, list);
        component_window_checkin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        component_window_checkin.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        component_window.getContentPane().add(component_window_checkin);

        JButton component_window_checkout = new JButton("Check Out");
        springLayout1.putConstraint(SpringLayout.NORTH, component_window_checkout, 15, SpringLayout.NORTH, list);
        springLayout1.putConstraint(SpringLayout.EAST, component_window_checkout, -449, SpringLayout.EAST,
                component_window.getContentPane());
        component_window_checkout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        component_window_checkout.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        component_window.getContentPane().add(component_window_checkout);

        component_window_search_entry = new JTextField();
        springLayout1.putConstraint(SpringLayout.NORTH, component_window_search_entry, 17, SpringLayout.NORTH, list);
        springLayout1.putConstraint(SpringLayout.WEST, component_window_search_entry, 6, SpringLayout.EAST,
                component_window_checkout);
        springLayout1.putConstraint(SpringLayout.EAST, component_window_search_entry, -212, SpringLayout.EAST,
                component_window.getContentPane());
        component_window.getContentPane().add(component_window_search_entry);
        component_window_search_entry.setColumns(10);

        JButton component_window_search = new JButton("Search");
        springLayout1.putConstraint(SpringLayout.NORTH, component_window_search, 15, SpringLayout.NORTH, list);
        springLayout1.putConstraint(SpringLayout.WEST, component_window_search, 0, SpringLayout.EAST,
                component_window_search_entry);
        component_window_search.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        component_window.getContentPane().add(component_window_search);

        main_window = new JFrame();
        main_window.setForeground(new Color(51, 204, 204));
        main_window.getContentPane().setBackground(new Color(72, 209, 204));
        main_window.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        main_window.setResizable(false);
        main_window.setTitle("The Greene's Library");
        main_window.setBounds(100, 100, 450, 300);
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        main_window.getContentPane().setLayout(springLayout);

        JLabel main_title = new JLabel("The Greene's Library");
        springLayout.putConstraint(SpringLayout.NORTH, main_title, 10, SpringLayout.NORTH,
                main_window.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, main_title, 62, SpringLayout.WEST, main_window.getContentPane());
        main_title.setHorizontalAlignment(SwingConstants.CENTER);
        main_title.setVerticalAlignment(SwingConstants.TOP);
        main_title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        main_window.getContentPane().add(main_title);

        JLabel main_username = new JLabel("Username");
        main_username.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        springLayout.putConstraint(SpringLayout.NORTH, main_username, 42, SpringLayout.SOUTH, main_title);
        springLayout.putConstraint(SpringLayout.WEST, main_username, 0, SpringLayout.WEST, main_title);
        springLayout.putConstraint(SpringLayout.SOUTH, main_username, 85, SpringLayout.SOUTH, main_title);
        springLayout.putConstraint(SpringLayout.EAST, main_username, 184, SpringLayout.WEST,
                main_window.getContentPane());
        main_window.getContentPane().add(main_username);

        JLabel main_password = new JLabel("Password");
        springLayout.putConstraint(SpringLayout.NORTH, main_password, 16, SpringLayout.SOUTH, main_username);
        springLayout.putConstraint(SpringLayout.WEST, main_password, 0, SpringLayout.WEST, main_title);
        springLayout.putConstraint(SpringLayout.EAST, main_password, 0, SpringLayout.EAST, main_username);
        main_password.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        main_window.getContentPane().add(main_password);

        main_username_entry = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, main_username_entry, 61, SpringLayout.SOUTH, main_title);
        springLayout.putConstraint(SpringLayout.WEST, main_username_entry, 6, SpringLayout.EAST, main_username);
        springLayout.putConstraint(SpringLayout.SOUTH, main_username_entry, 0, SpringLayout.SOUTH, main_username);
        springLayout.putConstraint(SpringLayout.EAST, main_username_entry, 0, SpringLayout.EAST, main_title);
        main_username_entry.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        main_window.getContentPane().add(main_username_entry);
        main_username_entry.setColumns(10);

        main_password_entry = new JPasswordField();
        springLayout.putConstraint(SpringLayout.NORTH, main_password_entry, 0, SpringLayout.NORTH, main_password);
        springLayout.putConstraint(SpringLayout.WEST, main_password_entry, 6, SpringLayout.EAST, main_password);
        springLayout.putConstraint(SpringLayout.SOUTH, main_password_entry, 3, SpringLayout.SOUTH, main_password);
        springLayout.putConstraint(SpringLayout.EAST, main_password_entry, 0, SpringLayout.EAST, main_title);
        main_window.getContentPane().add(main_password_entry);

        JLabel main_copyright = new JLabel("© 2017 Derek Greene");
        main_copyright.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        springLayout.putConstraint(SpringLayout.WEST, main_copyright, 10, SpringLayout.WEST,
                main_window.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, main_copyright, -10, SpringLayout.SOUTH,
                main_window.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, main_copyright, 0, SpringLayout.EAST, main_username);
        main_window.getContentPane().add(main_copyright);

        JButton main_submit = new JButton("Submit");
        springLayout.putConstraint(SpringLayout.NORTH, main_submit, 6, SpringLayout.SOUTH, main_password);
        springLayout.putConstraint(SpringLayout.WEST, main_submit, 160, SpringLayout.WEST,
                main_window.getContentPane());
        main_window.getContentPane().add(main_submit);

        String admin_username = "Lisa";
        String admin_password = "BreakAngel34";
        String username_conner = "Conner";
        String password_conner = "BookWorm";
        String username_jena = "Jena";
        String password_jena = "Greene";
        String username_fitzgerald = "Fitzgerald";
        String password_fitzgerald = "Rock";
        String root_username = "Derek Greene";
        String root_password = "Iox28680!";

        main_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aActionEvent) {
                String username = main_username_entry.getText();
                main_username_entry.selectAll();

                String password = main_password_entry.getText();
                main_password_entry.selectAll();

                if (username.equals(admin_username) && (password.equals(admin_password))) {
                    main_title.setText("Welcome Lisa");
                    main_username_entry.setText("");
                    main_password_entry.setText("");
                    main_window.setVisible(false);
                    component_window.setVisible(true);
                } else {
                    if (username.equals(username_conner) && (password.equals(password_conner))) {
                        main_title.setText("Welcome Conner");
                        main_username_entry.setText("");
                        main_password_entry.setText("");
                        main_window.setVisible(false);
                        component_window.setVisible(true);
                    } else {
                        if (username.equals(username_jena) && (password.equals(password_jena))) {
                            main_title.setText("Welcome Jena");
                            main_username_entry.setText("");
                            main_password_entry.setText("");
                            main_window.setVisible(false);
                            component_window.setVisible(true);
                        } else {
                            if (username.equals(username_fitzgerald) && (password.equals(password_fitzgerald))) {
                                main_title.setText("Welcome Fitzgerald");
                                main_username_entry.setText("");
                                main_password_entry.setText("");
                                main_window.setVisible(false);
                                component_window.setVisible(true);
                            } else {
                                if (username.equals(root_username) && (password.equals(root_password))) {
                                    main_title.setText("Welcome Derek");
                                    main_username_entry.setText("");
                                    main_password_entry.setText("");
                                    main_window.setVisible(false);
                                    component_window.setVisible(true);
                                } else {
                                    main_title.setText("Incorrect Password");
                                    main_username_entry.setText("");
                                    main_password_entry.setText("");
                                }

                            }
                        }
                    }
                }
            }
        });
    }

}
