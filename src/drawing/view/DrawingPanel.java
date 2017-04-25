package drawing.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import drawing.controller.ArtController;

public class DrawingPanel extends JPanel
{
	private ShapePanel shapePanel;
	private ArtController baseController;
	private SpringLayout baseLayout;
	private JButton rectangleButton;
	private JButton ellipseButton;
	private JButton circleButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JButton resetButton;
	
	
	public DrawingPanel(ArtController baseController)
	{
		shapePanel = new ShapePanel(baseController);
		baseLayout = new SpringLayout();
		circleButton = new JButton("Draw Circles");
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 0, SpringLayout.WEST, this);
		ellipseButton = new JButton("Draw Ellipses");
		baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 0, SpringLayout.WEST, this);
		triangleButton = new JButton("Draw Triangles");
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 0, SpringLayout.WEST, this);
		polygonButton = new JButton("Draw Polygons");
		baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 80, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, triangleButton, -6, SpringLayout.NORTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 0, SpringLayout.WEST, this);
		resetButton = new JButton("Reset");
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 7, SpringLayout.SOUTH, circleButton);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 0, SpringLayout.WEST, triangleButton);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);;
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(600, 600));
		this.add(triangleButton);
		this.add(polygonButton);
		this.add(circleButton);
		this.add(ellipseButton);
		this.add(shapePanel);
		this.add(resetButton);
		rectangleButton = new JButton("Draw Rectangles");
		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 0, SpringLayout.NORTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 0, SpringLayout.WEST, triangleButton);
		add(rectangleButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 250, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, ellipseButton, 6, SpringLayout.SOUTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 6, SpringLayout.SOUTH, ellipseButton);
	}
	
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						shapePanel.addRectangles();
					}
					
				});
		
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircles();
			}
			
		});
		
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipses();
			}
			
		});
		
		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangles();
			}
			
		});
		
		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygons();
			}
			
		});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.reset();
			}
			
		});
	}
}
