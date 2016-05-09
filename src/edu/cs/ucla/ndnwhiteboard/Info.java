package edu.cs.ucla.ndnwhiteboard;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sumit on 5/17/15.
 */
public class Info {
    private JPanel pane;
    private JTextField usernameField;
    private JTextField whiteboardField;
    private JButton nextButton;
    private JTextField prefixField;
    private static JLabel lblname, lblwhiteboard, lblndnprefix;
    
    
    public void show() {
        final JFrame frame = new JFrame("NDN Whiteboard");
        
                
		
		
		frame.setSize (250,250);
		frame.setResizable(false);
		pane =  new JPanel(); 
	    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		//Create controls
	   
	   
	    JPanel content = new JPanel();  
	    content.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		lblname = new JLabel ("Name");
		usernameField = new JTextField (10);
		content.add(lblname); 
		content.add(usernameField);
		
		
		JPanel content2 = new JPanel();  
	    content2.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		lblwhiteboard = new JLabel ("Whiteboard");
		whiteboardField = new JTextField  (10);
		content2.add(lblwhiteboard); 
		content2.add(whiteboardField);
		
		
		JPanel content3 = new JPanel();  
	    content3.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblndnprefix = new JLabel ("NDN Prefitx");
		prefixField = new JTextField  (10);
		content3.add(lblndnprefix); 
		content3.add(prefixField);
		
		nextButton = new JButton ("Submit");

		
		pane.add(content);
		pane.add(content2);
		pane.add(content3);
		pane.add(nextButton); 
		 		//Set frame visible
		frame.add(pane);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	frame.setVisible (true);
		frame.pack();
    	
        usernameField.setText(Utils.generateRandomName());
        whiteboardField.setText(Utils.genWhiteboardName());

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String whiteboard = whiteboardField.getText();
                String prefix = prefixField.getText();

                Whiteboard whiteboardForm = new Whiteboard(username, whiteboard, prefix);
                whiteboardForm.show();
                frame.dispose();
            }
        });
    }
}
