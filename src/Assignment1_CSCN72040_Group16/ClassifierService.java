package Assignment1_CSCN72040_Group16;

import java.util.List;

public class ClassifierService {
    private final DataDAO dataDAO;

    public ClassifierService(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }

    public List<Data> loadTrainingData(String filename) {
        return dataDAO.readDataFromFile(filename);
    }

    public void processFile(ClassifierInterface classifier, String inputFile, String outputFile) {
        List<Data> inputData = dataDAO.readDataFromFile(inputFile);
        for (Data data : inputData) {
            int classification = classifier.classify(data.getX(), data.getY(), data.getZ());
            data.setPosition(classification);
        }
        dataDAO.writeDataToFile(outputFile, inputData);
    }
}
