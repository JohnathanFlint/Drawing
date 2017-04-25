package drawing.controller;

import drawing.view.ArtFrame;

public class ArtController
{
	private ArtFrame appFrame;
	
	public ArtController()
	{
		this.appFrame = new ArtFrame(this);
	}
}
