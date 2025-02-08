package Assignment1_CSCN72040_Group16.classifier;

import java.util.Comparator;
import java.util.List;

import Assignment1_CSCN72040_Group16.domain.Data;

public class NN extends BaseClassifier {

    public NN(List<Data> trainingData) {
        train(trainingData);
    }

    @Override
    public int classify(double x, double y, double z) {
        Data nearest = findNearestNeighbor(x, y, z);
        return (nearest != null) ? nearest.getPosition() : -1;
    }

    private Data findNearestNeighbor(double x, double y, double z) {
        return trainingData.stream()
                .min(Comparator.comparingDouble(d -> calculateEuclideanDistance(x, y, z, d.getX(), d.getY(), d.getZ())))
                .orElse(null);
    }
}