package drawing.view;

import javax.swing.*;
import drawing.controller.ArtController;

public class ArtFrame extends JFrame
{
	private ArtController baseController;
	private DrawingPanel appPanel;
	
	public ArtFrame(ArtController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("HIHJGN");
		this.setResizable(true);
		this.setSize(400, 600);
		this.setVisible(true);
	}
}
