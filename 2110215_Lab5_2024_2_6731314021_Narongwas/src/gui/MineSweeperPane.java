package gui;

import java.util.ArrayList;
import javax.swing.text.Position;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MineSweeperPane extends GridPane{
	ArrayList<MineSweeperSquare> allCells;
	
	public MineSweeperPane() {
		allCells = new ArrayList<MineSweeperSquare>();
		setHgap(8);
		setVgap(8);
		setPadding(new Insets(8));
		setPrefWidth(500);
		setAlignment(Pos.CENTER);
		setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY)));
		setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		for(int i = 0;i < 5;i++) {
			for(int j = 0;j < 5;j++) {
				MineSweeperSquare square = new MineSweeperSquare(i,j);
				add(square, i, j);
				allCells.add(square);
			}
		}
	}

	public ArrayList<MineSweeperSquare> getAllCells() {
		return allCells;
	}
	
	
}
