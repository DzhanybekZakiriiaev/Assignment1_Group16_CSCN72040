package Assignment1_CSCN72040_Group16;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class KNN extends BaseClassifier {
	
    private final int k;

    public KNN(List<Data> trainingData, int k) {
        if (k <= 0) throw new IllegalArgumentException("k must be greater than 0.");
        this.k = k;
        train(trainingData);
    }

    @Override
    public int classify(double x, double y, double z) {
        List<Data> kNearest = findKNearestNeighbors(x, y, z);
        
        return kNearest.stream()
                .collect(Collectors.groupingBy(Data::getPosition, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    private List<Data> findKNearestNeighbors(double x, double y, double z) {
        return trainingData.stream()
                .sorted(Comparator.comparingDouble(d -> calculateEuclideanDistance(x, y, z, d.getX(), d.getY(), d.getZ())))
                .limit(k)
                .toList();
    }
}