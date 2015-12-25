package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

import edu.iut.gui.listeners.*;
import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;

import java.sql.*;


public class SchedulerFrame extends JFrame {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;	
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;
	
	protected void setupUI() {
		
		JEditorPane jEditorPane = new JEditorPane();
		 jEditorPane.setEditable(false);
		 JScrollPane scrollPane = new JScrollPane(jEditorPane);
	        
		 // add an html editor kit
	        HTMLEditorKit kit = new HTMLEditorKit();
	        jEditorPane.setEditorKit(kit);
	        
	        
		contentPane = new JPanel();
		layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
		agendaPanelFactory = new AgendaPanelFactory();
		dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
		weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
		monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);
		
		contentPane.add(dayView,ActiveView.DAY_VIEW.name());
		contentPane.add(weekView,ActiveView.WEEK_VIEW.name());
		contentPane.add(monthView,ActiveView.MONTH_VIEW.name());
	
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
		this.setContentPane(splitPane);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;		
		JMenuItem menuItem;
		
		/* File Menu */
		menu = new JMenu("File");
		
		menuItem = new JMenuItem("Load");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Not yet implemented", "info", JOptionPane.INFORMATION_MESSAGE, null);		
			}			
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Not yet implemented", "info", JOptionPane.INFORMATION_MESSAGE, null);		
			}			
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Not yet implemented", "info", JOptionPane.INFORMATION_MESSAGE, null);		
			}			
		});
		menu.add(menuItem);		
		menuBar.add(menu);
		
		/* Edit Menu */
		menu = new JMenu("Edit");
		JMenu submenu = new JMenu("View");
		menuItem = new JMenuItem("Day");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane,ActiveView.DAY_VIEW.name());	
			}			
		});		
		submenu.add(menuItem);
		menuItem = new JMenuItem("Week");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane,ActiveView.WEEK_VIEW.name());		
			}			
		});		
		submenu.add(menuItem);
		menuItem = new JMenuItem("Month");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane,ActiveView.MONTH_VIEW.name());		
			}			
		});		
		submenu.add(menuItem);
		menu.add(submenu);
		menuBar.add(menu);
		
		/* Help Menu */
		//button = new JButton("<html><b><u>T</u>wo</b><br>lines</html>");
		menu = new JMenu("Help");
		menuItem = new JMenuItem("Display");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// EX 4 : ajouter l'aide
				JOptionPane.showMessageDialog(null, "Not yet implemented", "info", JOptionPane.INFORMATION_MESSAGE, null);		
			}			
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("About");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Not yet implemented", "info", JOptionPane.INFORMATION_MESSAGE, null);		
			}			
		});
		menu.add(menuItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		this.pack();
		layerLayout.next(contentPane);
		
		
		Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);
       
	}
	
	public SchedulerFrame() {
		super();
		
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		contentPane = null;
		dayView = null;
		weekView = null;
		monthView = null;
		agendaPanelFactory = null;
		setupUI();

	}

	
	public SchedulerFrame(String title) {
		super(title);
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		setupUI();
	}
	public void activerMenuHelp(JMenuItem menuItem){
		JMenu menu = null;		
		menu.add(menuItem);
		
	}
	public void activerMenuAbout(JMenuItem menuItem){
		JMenu menu = null;		
		menu.add(menuItem);
		
	}
	public void activerMenuSave(JMenuItem menuItem){
		JMenu menu = null;		
		menu.add(menuItem);
		
	}
	public void activerMenuLoad(JMenuItem menuItem){
		JMenu menu = null;		
		menu.add(menuItem);
		
	}
	
	public void baseDonnee(){
		 Connection c = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Opened database successfully");
	}
	
}
