package drawing.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import drawing.controller.ArtController;

public class DrawingPanel extends JPanel
{
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	private ArtController baseController;
	private SpringLayout baseLayout;
	private JButton rectangleButton;
	private JButton ellipseButton;
	private JButton circleButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JButton resetButton;
	private JButton graphButton;
	
	
	public DrawingPanel(ArtController baseController)
	{
		shapePanel = new ShapePanel(baseController);
		graphPanel = new GraphPanel(new int[]{829,500,9001, 50, 42, 743, 222, 546, 102, 647
				});
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 250, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -10, SpringLayout.EAST, this);
		circleButton = new JButton("Draw Circles");
		
		ellipseButton = new JButton("Draw Ellipses");
		
		triangleButton = new JButton("Draw Triangles");
		
		polygonButton = new JButton("Draw Polygons");
		
		resetButton = new JButton("Reset");
		
		graphButton = new JButton("Draw Graph");
		
		
		
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
		this.add(graphButton);
		this.add(graphPanel);
		rectangleButton = new JButton("Draw Rectangles");
		
		add(rectangleButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 42, SpringLayout.SOUTH, circleButton);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 0, SpringLayout.WEST, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 250, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 0, SpringLayout.NORTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 0, SpringLayout.WEST, triangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 80, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, triangleButton, -6, SpringLayout.NORTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, graphButton, 6, SpringLayout.SOUTH, circleButton);
		baseLayout.putConstraint(SpringLayout.WEST, graphButton, 0, SpringLayout.WEST, triangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, ellipseButton, 6, SpringLayout.SOUTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 0, SpringLayout.WEST, this);
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
		
		graphButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						graphPanel.sortData();
					}
				});
	}
}
