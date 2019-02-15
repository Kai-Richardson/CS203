
/**
 * Class Logo 
 * 
 * @author Kai Richardson
 * @version 1/30/19
 * 
 * --------------------------
 * CS203
 * Starter Code Last Updated:  Spring 2019
 * --------------------------
 */
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Logo extends Application {
	// instance variables
	//
	// Define your variables here if you want to assign them in the main()
	// method and use them in start() method
	//
	int numLines = 0; // number of lines to generate
	Color[] colorList; // Color array for each line's color

	public static void main(String[] args) {
		// launching the JavaFx program and the start method
		launch(args);
	}

	public void initialize() {
		while (numLines <= 0) { // makes sure numLines is >0
			String question = "How many lines do you want?";
			String numLinesString = JOptionPane.showInputDialog(question);
			numLines = Integer.parseInt(numLinesString);
		}

		colorList = new Color[numLines];

		for (int i = 0; i < numLines; i++) {
			String question = "What color do you want line " + (i + 1) + " to be?";
			String lineColorString = JOptionPane.showInputDialog(question);
			colorList[i] = stringToColor(lineColorString);
		}

	}

	public void drawLine(GraphicsContext gc, int x, int y, int iteration) {
		// simple tree
		// gc.setFill(colorList[iteration]);
		System.out.println("Yeet Color Ln #" + iteration + ": " + colorList[iteration]);
		Line line = new Line(x, y, x + (5 * (int) Math.random()), y + (5 * (int) Math.random()));
		line.setStroke(colorList[iteration]);
		// gc.fillRect(x,y,10 * (int)Math.random(),20 * (int)Math.random());

	}// drawTree

	@Override
	public void start(Stage primaryStage) throws Exception {
		initialize();
		// set up a canvas on a scene to draw something
		Group root = new Group();
		Scene scene = new Scene(root);

		Canvas canvas = new Canvas(600, 600);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// check to see if we need to draw a second tree
		for (int i = 0; i < numLines; i++) {
			drawLine(gc, (int) Math.random() * 10, (int) Math.random() * 10, i);
		}

		// setup an event and a handler for the close button. this will exit the
		// application when the window is closed
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});

		// set up the title and display the window
		root.getChildren().add(canvas);
		primaryStage.setTitle("Logo Generator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Converts a given string into a color.
	 * 
	 * By David Gilbert, part of PaintUtilities.java, modified by Kai Richardson
	 * 
	 * @param value
	 *            - the string, either a name or a hex-string.
	 * 
	 * @return the color.
	 */
	public static Color stringToColor(final String value) {
		if (value == null) {
			return Color.BLACK;
		}

		try {
			// try to get a color by name
			Color exact = Color.valueOf(value);

			return exact;
		} catch (Exception ce) {
			try {
				// get color by hex or octal value
				return Color.web(value);
			} catch (Exception ex) {
				// if we can't get any color return black
				return Color.BLACK;
			}
		}
	}
}
