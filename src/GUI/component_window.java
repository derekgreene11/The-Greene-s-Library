package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.SpringLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import java.awt.ComponentOrientation;
import javax.swing.JEditorPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class component_window {

	public JFrame component_window;
	public JTable table;
	public JTextField component_window_search_entry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					component_window window = new component_window();
					window.component_window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public component_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		component_window = new JFrame();
		component_window.setMinimumSize(new Dimension(800, 400));
		component_window.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		component_window.setTitle("The Greene's Library");
		component_window.setResizable(false);
		SpringLayout springLayout = new SpringLayout();
		component_window.getContentPane().setLayout(springLayout);
		component_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		component_window.getContentPane().setBackground(new Color(51, 204, 204));
		component_window.pack();
		component_window.setLocationRelativeTo(null);

		JList list = new JList();
		springLayout.putConstraint(SpringLayout.SOUTH, list, 346, SpringLayout.NORTH, component_window.getContentPane());
		list.setForeground(new Color(51, 204, 204));
		springLayout.putConstraint(SpringLayout.NORTH, list, 0, SpringLayout.NORTH, component_window.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 5, SpringLayout.WEST, component_window.getContentPane());
		list.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Games", "Books", "Movies", "Devices" };

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
		
		Object[][] data = {
	            {"BookTest1", "Home", "Conner", "03/06/2017","10:23", false },
	            {"BookTest2", "Home", "NA", "03/13/2017", "NA", false },
	            {"BookTest3", "School", "Lisa", "03/12/2017", "1:57", false },
	            {"BookTest4", "Camping", "Jena", "03/13/2017", "15:04", false },
	            {"BookTest5", "Home", "NA", "02/28/2017", "NA", true },
	            {"BookTest6", "Home", "NA", "03/10/2017", "NA", false },
	            {"BookTest7", "Home", "NA", "03/10/2017", "NA", false },
	            {"BookTest8", "Home", "NA", "03/10/2017", "NA", false },
	            {"BookTest9", "Home", "NA", "03/10/2017", "NA", false },
	            {"BookTest10", "Home", "NA", "03/10/2017", "NA", false },
	            {"BookTest11", "Home", "NA", "03/10/2017", "NA", false },
	            {"BookTest12", "Home", "NA", "03/10/2017", "NA", false },
	            {"BookTest13", "Home", "NA", "03/10/2017", "NA", false }
	        };
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 6, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 674, SpringLayout.EAST, list);
		scrollPane.setPreferredSize(new Dimension(4, 8));
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		component_window.getContentPane().add(scrollPane);
		
		table = new JTable(data, columnnames);
		table.setRowMargin(5);
		table.setRowHeight(28);
		scrollPane.setViewportView(table);
		springLayout.putConstraint(SpringLayout.NORTH, table, 44, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.WEST, table, 28, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.EAST, table, 1052, SpringLayout.EAST, list);
		table.setAlignmentX(Component.RIGHT_ALIGNMENT);
		table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table.setMinimumSize(new Dimension(75, 107));
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		table.setSelectionBackground(new Color(0, 204, 204));
		table.setSelectionForeground(new Color(255, 255, 255));
		
		JButton component_window_checkin = new JButton("Check In");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, component_window_checkin);
		springLayout.putConstraint(SpringLayout.NORTH, component_window_checkin, 15, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.WEST, component_window_checkin, 6, SpringLayout.EAST, list);
		component_window_checkin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		component_window_checkin.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		component_window.getContentPane().add(component_window_checkin);
		
		JButton component_window_checkout = new JButton("Check Out");
		springLayout.putConstraint(SpringLayout.NORTH, component_window_checkout, 15, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.EAST, component_window_checkout, -449, SpringLayout.EAST, component_window.getContentPane());
		component_window_checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		component_window_checkout.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		component_window.getContentPane().add(component_window_checkout);
		
		component_window_search_entry = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, component_window_search_entry, 17, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.WEST, component_window_search_entry, 6, SpringLayout.EAST, component_window_checkout);
		springLayout.putConstraint(SpringLayout.EAST, component_window_search_entry, -212, SpringLayout.EAST, component_window.getContentPane());
		component_window.getContentPane().add(component_window_search_entry);
		component_window_search_entry.setColumns(10);
		
		JButton component_window_search = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, component_window_search, 15, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.WEST, component_window_search, 0, SpringLayout.EAST, component_window_search_entry);
		component_window_search.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		component_window.getContentPane().add(component_window_search);
	}
}
