package Assignment1_CSCN72040_Group16;

import java.util.List;

public class NN {

    private List<Data> trainingData;

    // Constructor to initialize the classifier with training data
    public NN(List<Data> trainingData) {
        if (trainingData == null || trainingData.isEmpty()) {
            throw new IllegalArgumentException("training data cannot be null or empty.");
        }
        this.trainingData = trainingData;
    }
    
    
    
    // classifies an unknown point based on the nearest training data point.
    public int classify(double x, double y, double z) {
        Data nearest = findNearestNeighbor(x, y, z);
        
        if (nearest != null) {
            return nearest.getPosition(); // return the label of the nearest training sample
        } else {
            return -1; // no valid classification found
        }
    }
    
    // finds the nearest neighbor to the given sample using Euclidean distance.
    private Data findNearestNeighbor(double x, double y, double z) {
        Data nearest = null; // store the closest point
        double minDistance = Double.MAX_VALUE; // start with a very large distance

        // Loop through all training data
        for (Data point : trainingData) {
            double distance = calculateEuclideanDistance(x, y, z, point.getX(), point.getY(), point.getZ());

            if (distance < minDistance) {
                minDistance = distance; // update the smallest distance found
                nearest = point; // store this point as the closest match
            }
        }

        return nearest; // Return the closest point found
    }
    
    
    
    // helper calculates the Euclidean distance between two (x, y, z) points
    private double calculateEuclideanDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        double xDiff = x2 - x1;
        double yDiff = y2 - y1;
        double zDiff = z2 - z1;

        // compute squared differences and take the square root
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
    }
    
}
