package Assignment1_CSCN72040_Group16;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		DataDAO dataDAO = new DataDAO();

        String filePath = "testingData.txt";

        // Read data from file
        List<Data> dataList = dataDAO.readDataFromFile(filePath);

        // Print the data
        System.out.println("Data read from file:");
        for (Data data : dataList) {
            System.out.println("Position: " + data.getPosition() +
                               ", X: " + data.getX() +
                               ", Y: " + data.getY() +
                               ", Z: " + data.getZ());
        }
        
        
        
        // NN classifier tests

        // load training data
        String trainingFilePath = "trainingData.txt";
        List<Data> trainingData = dataDAO.readDataFromFile(trainingFilePath);


        // initialize NN classifier with training data
        NN nnClassifier = new NN(trainingData);

        // load unknown data (data to classify)
        String unknownFilePath = "unknownData.txt";
        List<Data> unknownData = dataDAO.readDataFromFile(unknownFilePath);

        if (unknownData.isEmpty()) {
            System.out.println("error: No unknown data found. Exiting.");
            return;
        }

        // classify each unknown sample using nn
        System.out.println("\nClassifying Unknown Data...");
        for (Data data : unknownData) {
            int predictedLabel = nnClassifier.classify(data.getX(), data.getY(), data.getZ());
            System.out.println("X: " + data.getX() +
                    ", Y: " + data.getY() +
                    ", Z: " + data.getZ() +
                    " → Predicted orientation: " + predictedLabel);
        }
        
	}

}

