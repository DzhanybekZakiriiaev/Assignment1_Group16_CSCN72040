package Assignment1_CSCN72040_Group16.classifier;

import java.util.List;

import Assignment1_CSCN72040_Group16.domain.Data;

public abstract class BaseClassifier implements ClassifierInterface{
	
	protected List<Data> trainingData;

    @Override
    public void train(List<Data> trainingData) {
        if (trainingData == null || trainingData.isEmpty()) {
            throw new IllegalArgumentException("Training data cannot be null or empty.");
        }
        this.trainingData = trainingData;
    }

    protected double calculateEuclideanDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }
}
