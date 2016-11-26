import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class EditWindow implements ActionListener
{

	static JPanel EastJP,WestJP,NorthJP,SouthJP,CenterJP;
	
	public int center=0,north=0,south=0,west=0,east=0;
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() instanceof JButton)
		{
			JButton button = (JButton)e.getSource();
			Color selectedColor = Color.WHITE;
		
			if(button.getText().equals("Red"))
				selectedColor = Color.RED;
			else if(button.getText().equals("Blue"))
				selectedColor = Color.BLUE;
			else if(button.getText().equals("Yellow"))
				selectedColor = Color.YELLOW;
			else if(button.getText().equals("Pink"))
				selectedColor = Color.PINK;
			else if(button.getText().equals("Black"))
				selectedColor = Color.BLACK;	
				
			if(center == 1)
				CenterJP.setBackground(selectedColor);
			if(north == 1)
				NorthJP.setBackground(selectedColor);
			if(south == 1)
				SouthJP.setBackground(selectedColor);
			if(west == 1)
				WestJP.setBackground(selectedColor);
			if(east == 1)
				EastJP.setBackground(selectedColor);
		}
		else if(e.getSource() instanceof JCheckBox)
		{
			JCheckBox chk = (JCheckBox)e.getSource();
			if(chk.getName().equals("Center"))
			{
				if(chk.isSelected())
					center = 1;
				else
					center = 0;
			}
			if(chk.getName().equals("Left"))
			{
				if(chk.isSelected())
					west = 1;
				else
					west = 0;
			}
			if(chk.getName().equals("Right"))
			{
				if(chk.isSelected())
					east = 1;
				else
					east = 0;
			}
			if(chk.getName().equals("Top"))
			{
				if(chk.isSelected())
					north = 1;
				else
					north = 0;
			}
			if(chk.getName().equals("Down"))
			{
				if(chk.isSelected())
					south = 1;
				else
					south = 0;
			}
			
			
		}
	}
	
	EditWindow()
	{ 
		// The window object
		JFrame jf = new JFrame("Fill Colours"); 
		Toolkit theKit = jf.getToolkit();                				// Get the window toolkit 
		Dimension wndSize = theKit.getScreenSize();          			// Get screen size 

		jf.setBounds(0, 0, wndSize.width, wndSize.height-40);         	// Size 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		BorderLayout border = new BorderLayout();                 		// Create a layout manager 
		Container content = jf.getContentPane();             			// Get the content pane 
		content.setLayout(border);                             			// Set the container layout mgr 
		EtchedBorder edge = new EtchedBorder(EtchedBorder.RAISED);      // Button border 
		
		// Create Panels
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.PAGE_AXIS));
		jp1.add(Box.createRigidArea(new Dimension(10,155)));
		jp1.setBorder(BorderFactory.createLineBorder(Color.black));
		jp1.setPreferredSize(new Dimension(150,155));
		content.add(jp1,BorderLayout.WEST); 
		WestJP = jp1;
		
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.PAGE_AXIS));
		jp2.add(Box.createRigidArea(new Dimension(25,200)));
		jp2.setBorder(BorderFactory.createLineBorder(Color.black));
		jp2.setPreferredSize(new Dimension(150,155));
		content.add(jp2,BorderLayout.EAST);
		EastJP = jp2;
		
		jp3.setLayout(new BoxLayout(jp3, BoxLayout.PAGE_AXIS));
		jp3.add(Box.createRigidArea(new Dimension(150,50)));
		jp3.setBorder(BorderFactory.createLineBorder(Color.black));
		jp3.setPreferredSize(new Dimension(100,125));
		content.add(jp3,BorderLayout.NORTH);
		NorthJP = jp3;
		
		jp4.setLayout(new BoxLayout(jp4, BoxLayout.PAGE_AXIS));
		jp4.add(Box.createRigidArea(new Dimension(150,50)));
		jp4.setBorder(BorderFactory.createLineBorder(Color.black));
		jp4.setPreferredSize(new Dimension(100,125));
		content.add(jp4,BorderLayout.SOUTH);
		SouthJP = jp4;
		
		jp5.setLayout(new BoxLayout(jp5, BoxLayout.PAGE_AXIS));
		jp5.add(Box.createRigidArea(new Dimension(150,175)));
		jp5.setBorder(BorderFactory.createLineBorder(Color.black));
		content.add(jp5,BorderLayout.CENTER);
		CenterJP = jp5;

		// Create Buttons
		JButton button1 = new JButton("Red");
		button1.addActionListener(this);
		jp1.add(button1);
		
		JButton button2 = new JButton("Blue");
		button2.addActionListener(this);
		jp1.add(button2);		
		
		JButton button3 = new JButton("Yellow");
		button3.addActionListener(this);
		jp1.add(button3);
		
		JButton button4 = new JButton("Pink");
		button4.addActionListener(this);
		jp1.add(button4);
		
		JButton button5 = new JButton("Black");
		button5.addActionListener(this);
		jp1.add(button5);
		
		// Create checkboxes 
		JCheckBox checkbox1 = new JCheckBox("Left"); 
		JCheckBox checkbox2 = new JCheckBox("Right"); 
		JCheckBox checkbox3 = new JCheckBox("Top"); 
		JCheckBox checkbox4 = new JCheckBox("Down"); 
		JCheckBox checkbox5 = new JCheckBox("Center"); 
		
		checkbox1.setName("Left");
		checkbox2.setName("Right");
		checkbox3.setName("Top");
		checkbox4.setName("Down");
		checkbox5.setName("Center");
		
		checkbox1.addActionListener(this);
		checkbox2.addActionListener(this);
		checkbox3.addActionListener(this);
		checkbox4.addActionListener(this);
		checkbox5.addActionListener(this);
		
		jp1.add(checkbox1);
		jp2.add(checkbox2);
		jp3.add(checkbox3);
		jp4.add(checkbox4);
		jp5.add(checkbox5);
			
		jf.setVisible(true);			// Display the window 
	} 
}
