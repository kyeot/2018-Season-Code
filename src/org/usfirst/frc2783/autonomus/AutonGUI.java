package org.usfirst.frc2783.autonomus;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

@SuppressWarnings("serial")
public class AutonGUI extends JFrame {

	JButton addButton, deleteButton, manipulateButton;
	JTextField coordinates, coord;
	JTextField coordText = new JTextField();

	// Going to be used to monitor what action to do
	int actionNumber = 1;

	// Default stroke and fill colors
	Color strokeColor = Color.BLACK, fillColor = Color.GREEN;

	// initiates GUI
	public static void main(String[] args) {
		new AutonGUI();
	}

	// Constructor for GUI
	public AutonGUI() {

		// Define the defaults for the JFrame
		this.setSize(1000, 700);
		this.setTitle("Autonomus Mapping");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Separate panel for buttons
		JPanel buttonPanel = new JPanel();

		// Separate panel for displaying info
		JPanel textPanel = new JPanel();

		// Swing box that will hold all the buttons
		Box menu = Box.createHorizontalBox();
		Box textArea = Box.createVerticalBox();

		// Make all the buttons in makeMeButtons by passing the button icon.
		addButton = createButton("./src/greenbox.png", 1);
		deleteButton = createButton("./src/delete.png", 2);
		manipulateButton = createButton("./src/manip.png", 3);

		// Add the buttons to the box
		menu.add(addButton);
		menu.add(deleteButton);
		menu.add(manipulateButton);

		// Add the box of buttons to the panel
		buttonPanel.add(menu);

		// Adds textbox to text panel
		textPanel.add(textArea);

		// Position the buttons in the bottom of the frame
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		// Make the drawing area take up the rest of the frame
		getContentPane().add(new DrawingBoard(), BorderLayout.CENTER);

		// makes pane west for text
		getContentPane().add(textPanel, BorderLayout.WEST);

		// makes textbox to display info
		textArea.add(coordText);
		coordText.setColumns(10);

		// makes window visible
		this.setVisible(true);

	} // end of GUI constructor

	// Spits out buttons based on the image supplied
	// actionNum represents each shape to be drawn
	public JButton createButton(String iconFile, int actionNum) {
		JButton newButton = new JButton();
		Icon buttonIcon = new ImageIcon(iconFile);
		newButton.setIcon(buttonIcon);

		// Make the proper actionPerformed method execute when the
		// specific button is pressed
		newButton.addActionListener(new ActionListener() {

			// method for button listening
			public void actionPerformed(ActionEvent e) {

				// sets action numbers
				actionNumber = actionNum;

			}

		}); // end of button listener

		return newButton;
	} // end of button making method

	// creates drawing board
	private class DrawingBoard extends JComponent {

		// ArrayLists that contain each shape drawn along with
		// that shapes stroke and fill
		ArrayList<Marker> markers = new ArrayList<Marker>();
		ArrayList<Color> shapeFill = new ArrayList<Color>();
		ArrayList<Color> shapeStroke = new ArrayList<Color>();
		Point pointClicked;

		// Monitors events on the drawing area of the frame
		public DrawingBoard() {

			this.addMouseListener(new MouseAdapter() {

				// Listens for mouse being pressed
				public void mousePressed(MouseEvent e) {

					// Action number 1 when mouse is pressed (add)
					if (actionNumber == 1) {
						pointClicked = new Point(e.getX(), e.getY());
						// When the mouse is pressed get x & y position

						// Make marker at the point
						Marker marker = drawMarker(pointClicked.x + 3, pointClicked.y + 3, pointClicked.x - 3,
								pointClicked.y - 3);

						// Add shapes, fills and colors to their ArrayLists
						markers.add(marker);
						shapeFill.add(fillColor);
						shapeStroke.add(strokeColor);

						// Shows coordinates in textbox
						coordText.setText((char) (markers.indexOf(marker) + 65) + " ("
										+ (int) marker.getLocation().getX() + ", "
										+ (int) marker.getLocation().getY() + ")");

						// repaint area
						repaint();

					}
					// action number 2 when mouse is pressed (delete)
					else if (actionNumber == 2) {

					}
					// action number 3 when mouse is pressed (move)
					else if (actionNumber == 3) {

						// record point clicked
						pointClicked = new Point(e.getX(), e.getY());
						// loops through all markers
						for (Marker m : markers) {

							// find out which marker is selected
							if (m.contains(pointClicked)) {

								// sends coords to textbox
								coordText.setText((char) (markers.indexOf(m) + 65) + " (" 
												+ (int) m.getLocation().getX() + ", "
										 		+ (int) m.getLocation().getY() + ")");

								// makes marker clicked on the selected marker
								m.setSelected(true);

							} else {

								// makes all other markers not selected
								m.setSelected(false);

							}

						}

					}
					// action number 4 when mouse is pressed (type in coords)
					else if (actionNumber == 4) {

					}

					// nullifies clickedPoint
					pointClicked = null;

					// repaint the drawing area
					repaint();
				}

			}); // end of mouse listener

			// mouse motion listener
			this.addMouseMotionListener(new MouseMotionAdapter() {

				// mouse dragged method
				public void mouseDragged(MouseEvent e) {

					// records points the mouse was dragged
					Point currentPoint = new Point(e.getX(), e.getY());

					// action number three when mouse is dragged
					if (actionNumber == 3) {

						// Cycles through each marker and sees which one was
						// clicked on
						for (Marker m : markers) {

							// finds selected marker that was selected in the
							// mouse listener
							if (m.isSelected) {

								// follows mouse while dragged
								m.setLocation(currentPoint);

								// sends coords of marker to textbox while it
								// moves
								coordText.setText((char) (markers.indexOf(m) + 65) + " ("
												+ (int) m.getLocation().getX() + ", "
												+ (int) m.getLocation().getY() + ")");

							}

						}

						// repaints drawing area
						repaint();

					}

				}

			}); // end of motion listener

		}

		public void paint(Graphics g) {

			// Class used to define the shapes to be drawn
			Graphics2D graphSettings = (Graphics2D) g;
			// Antialiasing cleans up the jagged lines and defines rendering
			// rules
			graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// Defines the line width of the stroke
			graphSettings.setStroke(new BasicStroke(2));

			// Iterators created to cycle through strokes and fills
			Iterator<Color> strokeCounter = shapeStroke.iterator();
			Iterator<Color> fillCounter = shapeFill.iterator();

			// Eliminates transparent setting below
			graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

			for (Marker s : markers) {

				// Grabs the next stroke from the color arraylist
				graphSettings.setPaint(strokeCounter.next());

				graphSettings.draw(s);

				// Grabs the next fill from the color arraylist
				graphSettings.setPaint(fillCounter.next());

				graphSettings.fill(s);

			}

			// Guide shape used for drawing

			if (pointClicked != null) {
				
				// Makes the guide shape transparent
				graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40f));

				// Make guide shape gray for professional look
				graphSettings.setPaint(Color.LIGHT_GRAY);

				// Create a new rectangle using x & y coordinates
				Marker mark = drawMarker(pointClicked.x + 2,
										 pointClicked.y + 2,
										 pointClicked.x - 2,
										 pointClicked.y - 2);
				
				graphSettings.draw(mark);

			}

		}

		/**
		 * creates a mew marker
		 * 
		 * @param x1
		 * @param y1
		 * @param x2
		 * @param y2
		 * @return new Rectangle
		 */
		private Marker drawMarker(int x1, int y1, int x2, int y2) {

			// Get the top left hand corner for the shape
			// Math.min returns the points closest to 0
			int x = Math.min(x1, x2);
			int y = Math.min(y1, y2);

			// Gets the difference between the coordinates
			int width = Math.abs(x1 - x2);
			int height = Math.abs(y1 - y2);

			Marker newRect = new Marker(x, y, width, height);

			return newRect;

		}

	} // end of private drawing board private class

}// end of GUI class
