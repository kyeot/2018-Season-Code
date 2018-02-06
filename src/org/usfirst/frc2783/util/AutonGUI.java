package org.usfirst.frc2783.util;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

@SuppressWarnings("serial")
public class AutonGUI extends JFrame {
	
		JButton addButton, deleteButton;

		// Going to be used to monitor what shape to draw next
		
		int actionNumber = 2;
		
		// Default stroke and fill colors
		
		Color strokeColor = Color.BLACK, fillColor = Color.GREEN;
	
        public static void main(String [] args) {
                new AutonGUI();
        }

        public AutonGUI() {
        	// Define the defaults for the JFrame
        	
            this.setSize(500, 700);
            this.setTitle("Autonomus Mapping");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel buttonPanel = new JPanel();
            
            // Swing box that will hold all the buttons
            
            Box menu = Box.createHorizontalBox();
            
            // Make all the buttons in makeMeButtons by passing the
            // button icon. 
            
            addButton = createButton("./src/blackbox.png", 2);
            deleteButton = createButton("./src/delete.png", 1);
            
            
            // Make all the buttons in makeMeColorButton by passing the
            // button icon and true for stroke color or false for fill
            
            
            // Add the buttons to the box
            
            menu.add(addButton);
            menu.add(deleteButton);
            
            // Add the box of buttons to the panel
            
            buttonPanel.add(menu);

            // Position the buttons in the bottom of the frame
            
            this.add(buttonPanel, BorderLayout.SOUTH);
            
            // Make the drawing area take up the rest of the frame
            
            this.add(new DrawingBoard(), BorderLayout.CENTER);
            
            // Show the frame
            
            this.setVisible(true);
        }
        
        // Spits out buttons based on the image supplied
        // actionNum represents each shape to be drawn
        
        public JButton createButton(String iconFile, int actionNum) {
        	JButton newButton = new JButton();
            Icon buttonIcon = new ImageIcon(iconFile);
            newButton.setIcon(buttonIcon);
            
            // Make the proper actionPerformed method execute when the
            // specific button is pressed
            
            newButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					actionNumber = actionNum;
					System.out.println("actionNum: " + actionNum);
					
				}
            });
            
            return newButton;  
        }

        @SuppressWarnings("serial")
		private class DrawingBoard extends JComponent {
        	
        	// ArrayLists that contain each shape drawn along with
        	// that shapes stroke and fill
        	
                ArrayList<Shape> shapes = new ArrayList<Shape>();
                ArrayList<Color> shapeFill = new ArrayList<Color>();
                ArrayList<Color> shapeStroke = new ArrayList<Color>();
                Point drawStart;

                // Monitors events on the drawing area of the frame
                
                public DrawingBoard() {
                	
                        this.addMouseListener(new MouseAdapter() {
                            public void mousePressed(MouseEvent e) {
                            	if (actionNumber != 1) {
                            		
                            		// When the mouse is pressed get x & y position
                            		drawStart = new Point(e.getX(), e.getY());
                            		repaint();
                            		
                                }
                            	
                            	else if (actionNumber == 1) {
                            		
                            		
                            		
                            	}
                            	
                            }

                            public void mouseReleased(MouseEvent e) {
                            	
                            	if (actionNumber != 1) {
                            		
                            		if (actionNumber == 2) {
                            	
                            			// Create a shape using the starting x & y
                            			// and finishing x & y positions
                            			Shape marker = drawRectangle(drawStart.x + 2, drawStart.y + 2, drawStart.x - 2, drawStart.y - 2);
                                  
                            			// Add shapes, fills and colors to their ArrayLists
                            			shapes.add(marker);
                            			shapeFill.add(fillColor);
                            			shapeStroke.add(strokeColor);
                            			System.out.println(drawStart.getX() + ", " + drawStart.getY());
                                
                            			drawStart = null;
                            			
                                 
                            			// repaint the drawing area
                            			repaint();
                            			
                            		}
                            		
                            	}
                            	else if (actionNumber == 1){
                            		
                            	}
                            }
                        });

                        this.addMouseMotionListener(new MouseMotionAdapter() {
                          public void mouseDragged(MouseEvent e) {
                        	  
                        	  repaint();
                          }
                        });
                	
                }
                
                public void paint(Graphics g) {
                		// Class used to define the shapes to be drawn
                	
                        Graphics2D graphSettings = (Graphics2D)g;

                        // Antialiasing cleans up the jagged lines and defines rendering rules
                        
                        graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        
                        // Defines the line width of the stroke
                        
                        graphSettings.setStroke(new BasicStroke(2));

                        // Iterators created to cycle through strokes and fills
                        Iterator<Color> strokeCounter = shapeStroke.iterator();
                        Iterator<Color> fillCounter = shapeFill.iterator();
                        
                        // Eliminates transparent setting below
                        
                        graphSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                        
                        for (Shape s : shapes) {
                        	// Grabs the next stroke from the color arraylist
                        	graphSettings.setPaint(strokeCounter.next());
                        	
                        	graphSettings.draw(s);
                        	
                        	// Grabs the next fill from the color arraylist
                        	graphSettings.setPaint(fillCounter.next());
                        	
                        	graphSettings.fill(s);
                        }

                        // Guide shape used for drawing
                        if (drawStart != null) {
                        	// Makes the guide shape transparent
                            
                            graphSettings.setComposite(AlphaComposite.getInstance(
                                    AlphaComposite.SRC_OVER, 0.40f));
                        	
                            // Make guide shape gray for professional look
                            
                        	graphSettings.setPaint(Color.LIGHT_GRAY);
                        	
                        	// Create a new rectangle using x & y coordinates
                        	
                                Shape aShape = drawRectangle(drawStart.x + 2, drawStart.y + 2, drawStart.x - 2, drawStart.y - 2);
                                graphSettings.draw(aShape);
                        }
                }

                private Rectangle2D.Float drawRectangle(int x1, int y1, int x2, int y2) {
                	// Get the top left hand corner for the shape
                	// Math.min returns the points closest to 0
                	
                        int x = Math.min(x1, x2);
                        int y = Math.min(y1, y2);
                        
                        // Gets the difference between the coordinates and 
                        
                        int width = Math.abs(x1 - x2);
                        int height = Math.abs(y1 - y2);

                        return new Rectangle2D.Float(x, y, width, height);
                        
                }
                
        }
        
}
