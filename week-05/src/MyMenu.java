import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;

import java.awt.BorderLayout;

public class MyMenu extends JFrame {
    MyMenu(){
        //Set title and set size for frame
        super("Menu Demo");
        setSize(450,120);
        //add a menu bar to the frame
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
        menuBar.setBorderPainted(true);
        add(menuBar, BorderLayout.NORTH);
        //Add the file menu and its menu items
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        //add the submenus to the file menu
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.add(new JMenuItem("Save As"));
        fileMenu.addSeparator();
        fileMenu.addSeparator();
        //add the submenus to the edit menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        //add the submenus to the edit menu
        editMenu.add(new JMenuItem("Undo"));
        editMenu.addSeparator();
        editMenu.add(new JMenuItem("Cut"));
        editMenu.add(new JMenuItem("Copy"));
        editMenu.add(new JMenuItem("Paste"));
        //create and add the options menu and submenus and their items
        JMenu optionsMenu = new JMenu("Option");
        menuBar.add(optionsMenu);
        //add the submenu to the options menu
        JMenu bookMarksMenu = new JMenu("Bookmarks");
        optionsMenu.add(bookMarksMenu);
        //add the submenus to the Books marks menu
        JMenuItem addMI = new JMenuItem("Add Alt-K");
        bookMarksMenu.add(addMI);
        JMenuItem editMI = new JMenuItem("Add Alt-B");
        bookMarksMenu.add(editMI);
        JMenu guideMenu = new JMenu("Guide");
        bookMarksMenu.add(guideMenu);
        //Add the submenus to the guide menu
        JMenuItem whatIsNewMI = new JMenuItem("What's New");
        whatIsNewMI.setMnemonic('N');
        guideMenu.add(whatIsNewMI);
        JMenuItem whatIsCoolMI = new JMenuItem("What's Cool");
        whatIsNewMI.setMnemonic('C');
        guideMenu.add(whatIsCoolMI);
        //finally, add two more submenus to the options menu
        JMenuItem addressBookMI = new JMenuItem("Address Book");
        optionsMenu.add(addressBookMI);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new MyMenu();        
    }
}
