package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;

import java.net.URL;

import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane{
	
	private boolean isDrawn;
	private Color baseColor;
	private int xPosition;
	private int yPosition;
	private final String oURL = "o.png";
	private final String oneURL = "one.png";
	private final String mineURL = "mine.png";
	private final String flagURL = "flag.png";
	
	public MineSweeperSquare(int x,int y) {
		setxPosition(x);
		setyPosition(y);
		setPrefWidth(100);
		setPrefHeight(100);
		setMinHeight(100);
		setMinWidth(100);
		setBaseColor(Color.MOCCASIN);
		initializeCellColor();
		setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				onClickHandler();
			}
			
		});
	}
	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(100,100,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
		setDrawn(true);
	}
	
	public void initializeCellColor() {
		this.setBackground(new Background(new BackgroundFill(baseColor,CornerRadii.EMPTY,Insets.EMPTY)));
		setDrawn(false);
	}
	
	private void onClickHandler() {
		if(!GameLogic.getInstance().isGameEnd()) {
			if(!GameLogic.getInstance().isSecureMode() && GameLogic.getInstance().getBoardState()[xPosition][yPosition] == SquareState.CONCEALED) {
				switch(GameLogic.getInstance().getBoardMark()[xPosition][yPosition]) {
					case ONE:
						URL oneStringURL = ClassLoader.getSystemResource(oneURL);
						draw(new Image(oneURL.toString()), Color.ORANGE);
						break;
					case NOTHING:
						URL oStringURL = ClassLoader.getSystemResource(oURL);
						draw(new Image(oURL), Color.YELLOW);
						break;
					case MINE:
						URL mineStringURL = ClassLoader.getSystemResource(mineURL);
						draw(new Image(mineURL), Color.RED);
						break;
					default:
						break;
				}
				GameLogic.getInstance().updateState(xPosition, yPosition,SquareState.REVEALED);
			} else if (GameLogic.getInstance().isSecureMode() && !isDrawn) {
				URL flagStringURL = ClassLoader.getSystemResource(flagURL);
				draw(new Image(flagURL.toString()),Color.GREEN);
				GameLogic.getInstance().updateState(xPosition, yPosition,SquareState.SECURED);
			}
		} 
	}
	
	
	public boolean isDrawn() {
		return isDrawn;
	}
	public Color getBaseColor() {
		return baseColor;
	}
	public int getxPosition() {
		return xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public String getoURL() {
		return oURL;
	}
	public void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}
	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
		
}
