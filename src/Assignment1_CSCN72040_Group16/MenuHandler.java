
package Assignment1_CSCN72040_Group16;

import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private final Scanner scanner;
    private final ClassifierService classifierService;

    public MenuHandler() {
        scanner = new Scanner(System.in);
        classifierService = new ClassifierService(new DataDAO());
    }

    public void start() {
        System.out.println("Welcome to the Phone Orientation Classifier!");
        
        ClassifierInterface classifier = chooseClassifier();
        if (classifier == null) return;

        System.out.print("Enter the name of the file with unknown data (e.g., unknownData.txt): ");
        String inputFileName = scanner.nextLine();
        
        classifierService.processFile(classifier, inputFileName, "result.txt");
        System.out.println("Classification complete! Results saved in 'result.txt'.");
    }

    private ClassifierInterface chooseClassifier() {
        while (true) {
            System.out.println("\nChoose a classifier:");
            System.out.println("1. Nearest Neighbor (NN)");
            System.out.println("2. K-Nearest Neighbors (KNN)");
            System.out.println("3. Another Classifier");
            System.out.print("Enter your choice (1, 2 or 3): ");

            String choice = scanner.nextLine();
            List<Data> trainingData = classifierService.loadTrainingData("trainingData.txt");

            if ("1".equals(choice)) {
                return new NN(trainingData);
            } else if ("2".equals(choice)) {
                System.out.print("Enter the value of k for KNN: ");
                int k = scanner.nextInt();
                scanner.nextLine();
                return new KNN(trainingData, k);
            } else if ("3".equals(choice)) {
                return new AnotherClassifier(trainingData);
            } else {
                System.out.println("Invalid choice. Please enter 1, 2 or 3.");
            }
        }
    }


}