package org.usfirst.frc2783.util;

public class AutonWaypoint {
	public void AutoWaypoint() {
		System.out.println("I'm sorry, Carl");
	}
	
	// Create Variables for driveToWaypoint method
    double referenceDistance;
    double initialPositionx;
    double initialPositiony;
    double initialGyroAngle;
    double initialLeftReferencex;
    double initialLeftReferencey;
    double finalLeftReferencex;
    double finalLeftReferencey;
    double initialRightReferencex;
    double initialRightReferencey;
    double finalRightReferencex;
    double finalRightReferencey;
    double distanceRR;
    double distanceRL;
    double distanceLR;
    double distanceLL;
    double minDistance;
    double initialActualx;
    double initialActualy;
    double finalActualx;
    double finalActualy;
    double positiveDistance;
    double negativeDistance;
    boolean innerBitangent;
    boolean normalDirection;
    
    //Drives to a specified waypoint
    public void driveToWaypoint(double finalPositionx, double finalPositiony, double finalGyroAngle, double speed) {
    	
    	//Get initial values
//    	initialPositionx = [insert get current x command here];
//    	initialPositiony = [insert get current y command here];
    	initialGyroAngle = NavSensor.getAngle(false);
    	
    	//Calculate each potential reference point
    	//Since 0 represents North and not East, and values progress clockwise instead of counterclockwise, we substitute sin for cos and vice versa
    	initialLeftReferencex = initialPositionx + (referenceDistance * Math.sin(Math.toRadians((initialGyroAngle + 270) % 360)));
    	initialLeftReferencey = initialPositiony + (referenceDistance * Math.cos(Math.toRadians((initialGyroAngle + 270) % 360)));
    	finalLeftReferencex = finalPositionx + (referenceDistance * Math.sin(Math.toRadians((finalGyroAngle + 270) % 360)));
    	finalLeftReferencey = finalPositiony + (referenceDistance * Math.cos(Math.toRadians((finalGyroAngle + 270) % 360)));
        initialRightReferencex = initialPositionx + (referenceDistance * Math.sin(Math.toRadians((initialGyroAngle + 90) % 360)));
        initialRightReferencey = initialPositiony + (referenceDistance * Math.cos(Math.toRadians((initialGyroAngle + 90) % 360)));
        finalRightReferencex = finalPositionx + (referenceDistance * Math.sin(Math.toRadians((finalGyroAngle + 90) % 360)));
        finalRightReferencey = finalPositiony + (referenceDistance * Math.cos(Math.toRadians((finalGyroAngle + 90) % 360)));
        
        //Calculate the four distances between the potential reference points
        distanceRR = distanceBetweenXY(initialRightReferencex, finalRightReferencex, initialRightReferencey, finalRightReferencey);
        distanceRL = distanceBetweenXY(initialRightReferencex, finalLeftReferencex, initialRightReferencey, finalLeftReferencey);
        distanceLR = distanceBetweenXY(initialLeftReferencex, finalRightReferencex, initialLeftReferencey, finalRightReferencey);
        distanceLL = distanceBetweenXY(initialLeftReferencex, finalLeftReferencex, initialLeftReferencey, finalLeftReferencey);
        
        //Find the minimum distance
        minDistance = minimum(minimum(distanceRR, distanceRL), minimum(distanceLR, distanceLL));
        
        //Checks to see if distance can be calculated
        if (minDistance < referenceDistance) {
        	
        	//Value too close
        	System.out.println("Final Point too close to initial point. Please choose a further value");
        } else {
        	
        	//Acceptable value
        	//Shows preference to opposite references to avoid situations in which movement is prolonged
        	if (minDistance == distanceLR) {
        		initialActualx = initialLeftReferencex;
        		initialActualy = initialLeftReferencey;
        		finalActualx = finalRightReferencex;
        		finalActualy = finalRightReferencey;
        		innerBitangent = true;
        	} else if (minDistance == distanceRL) {
        		initialActualx = initialRightReferencex;
        		initialActualy = initialRightReferencey;
        		finalActualx = finalLeftReferencex;
        		finalActualy = finalLeftReferencey;
        		innerBitangent = true;
        	} else if (minDistance == distanceRR) {
        		initialActualx = initialRightReferencex;
        		initialActualy = initialRightReferencey;
        		finalActualx = finalRightReferencex;
        		finalActualy = finalRightReferencey;
        		innerBitangent = false;
        	} else {
        		initialActualx = initialLeftReferencex;
        		initialActualy = initialLeftReferencey;
        		finalActualx = finalLeftReferencex;
        		finalActualy = finalLeftReferencey;
        		innerBitangent = false;
        	}
        	
        	circleBitangents(initialPositionx, initialPositiony, finalPositionx, finalPositiony, innerBitangent);
        	
        	positiveDistance = arclengthFromDistance(tangentOneXInterceptOne, tangentOneYInterceptOne, initialPositionx, initialPositiony, referenceDistance)
        			+ distanceBetweenXY(tangentOneXInterceptOne, tangentOneYInterceptOne, tangentOneXInterceptTwo, tangentOneYInterceptTwo)
        			+ arclengthFromDistance(tangentOneXInterceptTwo, tangentOneYInterceptTwo, finalPositionx, finalPositiony, referenceDistance);
        	negativeDistance = arclengthFromDistance(tangentTwoXInterceptOne, tangentTwoYInterceptOne, initialPositionx, initialPositiony, referenceDistance)
        			+ distanceBetweenXY(tangentTwoXInterceptOne, tangentTwoYInterceptOne, tangentTwoXInterceptTwo, tangentTwoYInterceptTwo)
        			+ arclengthFromDistance(tangentTwoXInterceptTwo, tangentTwoYInterceptTwo, finalPositionx, finalPositiony, referenceDistance);
        	
        	//Set route to shorter distance
        	//Insert driving mechanics here
        }
    } 
    
    //Find the minimum value of two given indexes
    public double minimum(double indexOne, double indexTwo) {
    	return (indexOne < indexTwo) ? indexOne : indexTwo;
    }
    
    //Calculate the distance between two points
    public double distanceBetweenXY(double xone, double yone, double xtwo, double ytwo) {
    	return Math.sqrt(Math.pow((xone - xtwo), 2) + Math.pow((yone - ytwo), 2));
    }
    
    public double square(double number) {
    	return number * number;
    }
    
    public double arclengthFromDistance(double xone, double yone, double xtwo, double ytwo, double radius) {
    	return radius * Math.acos(1 - (distanceBetweenXY(xone, yone, xtwo, ytwo) / (2 * square(radius))));
    }
    
    //Create variables for bitangent method
    double bitangentXCoefficientOne;
    double bitangentYCoefficientOne;
    double bitangentConstantOne;
    double bitangentXCoefficientTwo;
    double bitangentYCoefficientTwo;
    double bitangentConstantTwo;
    double tangentOneXInterceptOne;
    double tangentOneYInterceptOne;
    double tangentOneXInterceptTwo;
    double tangentOneYInterceptTwo;
    double tangentTwoXInterceptOne;
    double tangentTwoYInterceptOne;
    double tangentTwoXInterceptTwo;
    double tangentTwoYInterceptTwo;
    
    //Calculate the points where a bitangent intersects two circles
    //Returns values of the x and y of points of intersection
    public void circleBitangents(double circleOnex, double circleOney, double circleTwox, double circleTwoy, boolean internalBitangents) {
    	if (internalBitangents == true) {
    		bitangentXCoefficientOne = -1 * ((circleTwoy - circleOney)/distanceBetweenXY(circleOnex, circleOney, circleTwox, circleTwoy));
    		bitangentYCoefficientOne = ((circleTwox - circleOnex)/distanceBetweenXY(circleOnex, circleOney, circleTwox, circleTwoy));
    		bitangentConstantOne = referenceDistance  - ((bitangentXCoefficientOne * circleOnex) + (bitangentYCoefficientOne * circleOney));
    		bitangentXCoefficientTwo = ((circleTwoy - circleOney)/distanceBetweenXY(circleOnex, circleOney, circleTwox, circleTwoy));
    		bitangentYCoefficientTwo = -1 * ((circleTwox - circleOnex)/distanceBetweenXY(circleOnex, circleOney, circleTwox, circleTwoy));
    		bitangentConstantTwo = referenceDistance  - ((bitangentXCoefficientOne * circleOnex) + (bitangentYCoefficientOne * circleOney));
    		tangentOneXInterceptOne = ((square(bitangentYCoefficientOne)*circleOnex)-(bitangentXCoefficientOne*bitangentYCoefficientOne*circleOney)
    				-(bitangentXCoefficientOne*bitangentConstantOne))/(square(bitangentXCoefficientOne)+square(bitangentYCoefficientOne));
    		tangentOneYInterceptOne = ((-(bitangentXCoefficientOne*tangentOneXInterceptOne))+bitangentConstantOne)/bitangentYCoefficientOne;
    		tangentOneXInterceptTwo = ((square(bitangentYCoefficientOne)*circleTwox)-(bitangentXCoefficientOne*bitangentYCoefficientOne*circleTwoy)
    				-(bitangentXCoefficientOne*bitangentConstantOne))/(square(bitangentXCoefficientOne)+square(bitangentYCoefficientOne));
    		tangentOneYInterceptTwo = ((-(bitangentXCoefficientOne*tangentOneXInterceptTwo))+bitangentConstantOne)/bitangentYCoefficientOne;
    		tangentTwoXInterceptOne = ((square(bitangentYCoefficientTwo)*circleOnex)-(bitangentXCoefficientTwo*bitangentYCoefficientTwo*circleOney)
    				-(bitangentXCoefficientTwo*bitangentConstantTwo))/(square(bitangentXCoefficientTwo)+square(bitangentYCoefficientTwo));
    		tangentTwoYInterceptOne = ((-(bitangentXCoefficientTwo*tangentTwoXInterceptOne))+bitangentConstantTwo)/bitangentYCoefficientTwo;
    		tangentTwoXInterceptTwo = ((square(bitangentYCoefficientTwo)*circleTwox)-(bitangentXCoefficientTwo*bitangentYCoefficientTwo*circleTwoy)
    				-(bitangentXCoefficientTwo*bitangentConstantTwo))/(square(bitangentXCoefficientTwo)+square(bitangentYCoefficientTwo));
    		tangentTwoYInterceptTwo = ((-(bitangentXCoefficientTwo*tangentTwoXInterceptTwo))+bitangentConstantTwo)/bitangentYCoefficientTwo;
    	} else {
    		tangentOneXInterceptOne = circleOnex + referenceDistance * Math.cos(Math.PI/2 - Math.atan((circleTwoy - circleOney) / (circleTwox - circleOnex)));
    		tangentOneYInterceptOne = circleOney + referenceDistance * Math.sin(Math.PI/2 - Math.atan((circleTwoy - circleOney) / (circleTwox - circleOnex)));
    		tangentOneXInterceptTwo = circleTwox + referenceDistance * Math.cos(Math.PI/2 - Math.atan((circleTwoy - circleOney) / (circleTwox - circleOnex)));
    		tangentOneYInterceptTwo = circleTwoy + referenceDistance * Math.sin(Math.PI/2 - Math.atan((circleTwoy - circleOney) / (circleTwox - circleOnex)));
    		tangentTwoXInterceptOne = circleOnex - referenceDistance * Math.cos(Math.PI/2 - Math.atan((circleTwoy - circleOney) / (circleTwox - circleOnex)));
    		tangentTwoYInterceptOne = circleOney - referenceDistance * Math.sin(Math.PI/2 - Math.atan((circleTwoy - circleOney) / (circleTwox - circleOnex)));
    		tangentTwoXInterceptTwo = circleTwox - referenceDistance * Math.cos(Math.PI/2 - Math.atan((circleTwoy - circleOney) / (circleTwox - circleOnex)));
    		tangentTwoYInterceptTwo = circleTwoy - referenceDistance * Math.sin(Math.PI/2 - Math.atan((circleTwoy - circleOney) / (circleTwox - circleOnex)));
    	}
    }
}
