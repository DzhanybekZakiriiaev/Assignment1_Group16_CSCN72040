package Assignment1_CSCN72040_Group16;

import java.util.List;

public class NN {

    private List<Data> trainingData;

    // constructor
    public NN(List<Data> trainingData) {
        this.trainingData = trainingData;
    }

    // method to classify a new point (x, y, z)
    public int classify(double x, double y, double z) {
        Data nearest = null; // store the closest data point
        double minDistance = Double.MAX_VALUE; // start with a very large distance

        // go through every data point in trainingData list
        for (Data point : trainingData) {
            // calculate the distance between the new point and the training point
            double distance = calculateDistance(x, y, z, point.getX(), point.getY(), point.getZ());

            // if this point is closer than the previous closest, update nearest
            if (distance < minDistance) {
                minDistance = distance; // update the smallest distance found
                nearest = point; // store this point as the closest match
            }
        }

        // if the nearest point was found return its position value
        if (nearest != null) {
            return nearest.getPosition();
        } else {
            return -1;
        }
    }

    // helper calculates the Euclidean distance between two (x, y, z) points
    private double calculateDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        double xDiff = x2 - x1;
        double yDiff = y2 - y1;
        double zDiff = z2 - z1;

        // compute squared differences and take the square root
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
    }
}
