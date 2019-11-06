package com.myangrysoul;

public class Neuron  {
    private double[] inputs;
    private double[] weights;

    Neuron(double[] inputs, double[] weights) {
        this.inputs = inputs;
        this.weights = weights;
    }

    private double activator(double[] i, double[] w) {
        double sum = 0;
        for (int j = 0; j < i.length; j++) {
            sum += i[j] * w[j];
        }
        if(sum>0){
            return 1;
        }
        return -1;
    }

    public double[] getInputs() {
        return inputs;
    }

    public double[] getWeights() {
        return weights;
    }

    double getWeight(int index) {
        return weights[index];
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    void setInputs(double[] inputs) {
        this.inputs = inputs;
    }

    public double Output() {
        return activator(inputs, weights);
    }


}
