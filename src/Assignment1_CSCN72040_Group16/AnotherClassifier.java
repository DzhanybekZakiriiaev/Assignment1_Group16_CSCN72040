package Assignment1_CSCN72040_Group16;

import java.util.List;

public class AnotherClassifier extends BaseClassifier {

    public AnotherClassifier(List<Data> trainingData) {
        train(trainingData);
    }

    @Override
    public void train(List<Data> trainingData) {
        System.out.println("train");
    }

    @Override
    public int classify(double x, double y, double z) {
        System.out.println("classify");
        return 0;
    }

    @Override
    protected double calculateEuclideanDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        System.out.println("calculateEuclideanDistance");
        return 0;
    }
}
