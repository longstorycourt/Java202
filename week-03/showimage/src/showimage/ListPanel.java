package showimage;

import java.awt.Graphics;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListPanel extends JPanel implements ListSelectionListener{
    JScrollPane phonesp;
    JList phonelist, source;
    int phoneprice[] = new int[6];
    String selected;
    ListModel lstmodel;
    int selectindex;
    String pic = "";
    public ListPanel(){
        String phonebrands[] = {"IPhone","Samsung","HTC","Sony","LG", "Nokia"};
        int price[]={650, 250, 310,200,310,120};
        for(int i= 0; i<price.length; i++)
            phoneprice[i] = price[i];
        phonelist = new JList<>(phonebrands);
        phonelist.setVisibleRowCount(5);
        phonelist.addListSelectionListener(this);
        phonesp = new JScrollPane(phonelist);
        add(phonesp);
        lstmodel = phonelist.getModel();
    }
    public void valueChanged(ListSelectionEvent lse){
        source = (JList)lse.getSource();
        selected = (String)source.getSelectedValue();
        selectindex = source.getSelectedIndex();
        repaint();
    }
    public void paintComponent(Graphics gp){
        super.paintComponent(gp);
        gp.drawString("size of list: "+ lstmodel.getSize(),20,130);
        if(selected != null){
            gp.drawString("Selected Phone: "+ selected, 20,150);
            gp.drawString("Price of this phone: "+ phoneprice[selectindex], 20,170);
            gp.drawString("Selected Phone: "+ selectindex, 20,190);

        }
    }


}
