package Assignment1_CSCN72040_Group16.classifier;

import java.util.List;

import Assignment1_CSCN72040_Group16.domain.Data;

public interface ClassifierInterface {
	
	void train(List<Data> trainingData);
	
    int classify(double x, double y, double z);
    
}
