package com.zeropoints.ensoulomancy.gui.spiritguide;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class GuiTextArea extends Gui {

	public int left = 0;
	public int top = 0;
	public int width = 0;
	public int height = 0;
	public int padding = 4;
	public String textArea = "";
	
	
	public GuiTextArea(int leftIn, int topIn, int widthIn, int heightIn, String textAreaIn) {
		left = leftIn;
		top = topIn;
		width = widthIn;
		height = heightIn;
		textArea = textAreaIn;        
	}
	
	
	public void DrawTextArea(FontRenderer fontRenderer) {
		int boxLeft = left - padding;
		int boxRight = boxLeft + width + (padding * 2);
		int boxTop = top - padding;
		int boxBottom = top + height + (padding * 2);
		
		drawRect(boxLeft , boxTop, boxRight, boxBottom, 0xFF695234);
		drawRect(boxLeft+2 , boxTop+2, boxRight-2, boxBottom-2, 0xFF180f05);
		
		//getWordWrappedHeight
		fontRenderer.drawSplitString(textArea, left, top, width, 0xDDDDDD);
	}
	
	@Override
	public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
		// TODO Auto-generated method stub
		super.drawTexturedModalRect(x, y, textureX, textureY, width, height);
	}
	
}
