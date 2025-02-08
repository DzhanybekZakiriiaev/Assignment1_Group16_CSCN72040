package Assignment1_CSCN72040_Group16;

import java.util.List;

public interface ClassifierInterface {
	
	void train(List<Data> trainingData);
	
    int classify(double x, double y, double z);
    
}
