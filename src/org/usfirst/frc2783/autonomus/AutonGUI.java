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

		// Going to be used to monitor what shape to draw next
		
		int actionNumber = 1;
		boolean isSelected = true;
		
		// Default stroke and fill colors
		
		Color strokeColor = Color.BLACK, fillColor = Color.GREEN;
	
        public static void main(String[] args) {
                new AutonGUI();
        }

        public AutonGUI() {
        	// Define the defaults for the JFrame
        	
            this.setSize(1000, 700);
            this.setTitle("Autonomus Mapping");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel buttonPanel = new JPanel();
            
            JPanel textPanel = new JPanel();
            
            // Swing box that will hold all the buttons
            
            Box menu = Box.createHorizontalBox();
            Box textArea = Box.createVerticalBox();
            
            // Make all the buttons in makeMeButtons by passing the
            // button icon. 
            
            addButton = createButton("./src/greenbox.png", 1);
            deleteButton = createButton("./src/delete.png", 2);
            manipulateButton = createButton("./src/manip.png", 3);
            
            
            // Make all the buttons in makeMeColorButton by passing the
            // button icon and true for stroke color or false for fill
            
            
            // Add the buttons to the box
            
            menu.add(addButton);
            menu.add(deleteButton);
            menu.add(manipulateButton);
            
            
            // Add the box of buttons to the panel
            
            buttonPanel.add(menu);
            textPanel.add(textArea);

            // Position the buttons in the bottom of the frame
            
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            
            // Make the drawing area take up the rest of the frame
            
            getContentPane().add(new DrawingBoard(), BorderLayout.CENTER);
            
            if (isSelected) {
            	
            	getContentPane().add(textPanel, BorderLayout.WEST);
                
                textArea.add(coordText);
                coordText.setColumns(10);
            	
            } else {
            	
            	getContentPane().remove(textPanel);
            	
            }
            
            this.setVisible(true);
        }
        
        // Spits out buttons based on the image supplied  // actionNum represents each shape to be drawn
        
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
        
        
        
		private class DrawingBoard extends JComponent {
        	
        	// ArrayLists that contain each shape drawn along with
        	// that shapes stroke and fill
        	
                ArrayList<Rectangles> markers = new ArrayList<Rectangles>();
                ArrayList<Color> shapeFill = new ArrayList<Color>();
                ArrayList<Color> shapeStroke = new ArrayList<Color>();
                Point pointClicked;
                
                // Monitors events on the drawing area of the frame
                
                public DrawingBoard() {
                	
                        this.addMouseListener(new MouseAdapter() {
                        	
                        	
                        	
                            public void mousePressed(MouseEvent e) {
                            	
                            	pointClicked = new Point(e.getX(), e.getY());
                            	
                            		// When the mouse is pressed get x & y position
                            	if (actionNumber == 1) {
                            		
                            		// When the mouse is pressed get x & y position
                            		
                            		
                            		Rectangles marker = drawMarker(pointClicked.x + 3, pointClicked.y + 3, pointClicked.x - 3, pointClicked.y - 3);
                                    
                        			// Add shapes, fills and colors to their ArrayLists
                            		markers.add(marker);
                            		shapeFill.add(fillColor);
                            		shapeStroke.add(strokeColor);
                            		coordText.setText((char) (markers.indexOf(marker) + 65) + " (" + (int) marker.getLocation().getX() + ", " + (int) marker.getLocation().getY() + ")");
                            		repaint();
                            		
                            	} else if (actionNumber == 2) {
                            		
                            		
                            		
                            	} else if (actionNumber == 3) {
                            		
                            		for (Rectangles m : markers) {
                            			
                            			if (m.contains(pointClicked)) {
                            				
                            				coordText.setText((char) (markers.indexOf(m) + 65) + " (" + (int) m.getLocation().getX() + ", " + (int) m.getLocation().getY() + ")");
                            				m.setSelected(true);
                            				
                            			} else {
                            				
                            				m.setSelected(false);
                            				
                            			}
                            			
                            		}
                            		
                            	}
                        		
                        		pointClicked = null;
                        			
                             
                        			// repaint the drawing area
                        		repaint();
                            }
                            	
                            	
                        }); //end of mouse listener
                        
                        this.addMouseMotionListener(new MouseMotionAdapter() {
                        	
                        	
                        	
                        	public void mouseDragged(MouseEvent e) {
                        		Point currentPoint = new Point(e.getX(), e.getY());
                        		if (actionNumber == 3) {
                        			
                        			//Cycles through each marker and sees which one was cicked on
                        			for (Rectangles m : markers) {
                        				if (m.isSelected) {
                        					
                        					m.setLocation(currentPoint);
                        				} else {
                        					isSelected = false;
                          				
                          			    }
                          			
                          		    }
                        	  	
                        	  	
                        	  	
                        	  
                        	  	  repaint();
                        	    }
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
                        
                        for (Rectangles s : markers) {
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
                            
                            graphSettings.setComposite(AlphaComposite.getInstance(
                                    AlphaComposite.SRC_OVER, 0.40f));
                        	
                            // Make guide shape gray for professional look
                            
                        	graphSettings.setPaint(Color.LIGHT_GRAY);
                        	
                        	// Create a new rectangle using x & y coordinates
                        	
                                Rectangles aShape = drawMarker(pointClicked.x + 2, pointClicked.y + 2, pointClicked.x - 2, pointClicked.y - 2);
                                graphSettings.draw(aShape);
                        }
                }

                private Rectangles drawMarker(int x1, int y1, int x2, int y2) {
                	
                	boolean selected;
                	
                	// Get the top left hand corner for the shape
                	// Math.min returns the points closest to 0
                	
                    int x = Math.min(x1, x2);
                    int y = Math.min(y1, y2);
                        
                    // Gets the difference between the coordinates and 
                        
                    int width = Math.abs(x1 - x2);
                    int height = Math.abs(y1 - y2);
                    
                    Rectangles newRect = new Rectangles(x, y, width, height);
                        
                    

                    return newRect;
                }
                
                
        }
        
}
