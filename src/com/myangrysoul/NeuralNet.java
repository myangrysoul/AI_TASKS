package com.myangrysoul;

import java.util.ArrayList;

import java.io.Serializable;
import java.util.ArrayList;

public class NeuralNet implements Serializable {
    private static final long serialVersionUID = -7108169269793526436L;
    private double[] inputLayer;
    private final double[] outputLayerOut;
    private ArrayList<Neuron> outputLayer;
    private double[][] patterns;
    private double[][] answers;

    public NeuralNet(int input, int out) {
        inputLayer = new double[input];
        outputLayerOut = new double[out];
    }

    public double[][] getPatterns() {
        return patterns;
    }


    public ArrayList<Neuron> getOutputLayer() {
        return outputLayer;
    }

    public double[] getOutputLayerOut() {
        return outputLayerOut;
    }

    public double[][] getAnswers() {
        return answers;
    }


    private double[] initWeight(int numOfEl) {
        double[] weight = new double[numOfEl];
        for (int i = 0; i < weight.length; i++) {
            weight[i] =0;
        }
        return weight;
    }

    public void initOutputLayer(double[] input) {
        outputLayer = new ArrayList<>();
        for (int i = 0; i < outputLayerOut.length; i++) {
            outputLayer.add(new Neuron(input, initWeight(inputLayer.length)));
        }
    }

    public void countOutput() {
        int index = 0;
        for (Neuron neuron : outputLayer) {
            outputLayerOut[index] = neuron.Output();
            index++;
        }
    }


    public double[] getOutWeight(int index) {
        double[] weight = new double[answers[0].length];
        int j = 0;
        for (Neuron neuron : outputLayer) {
            weight[j] = neuron.getWeight(index);
            j++;
        }
        return weight;
    }


    public void setOutputLayerInputs(double[] outputLayerInputs) {
        for (Neuron outputNeuron : outputLayer) {
            outputNeuron.setInputs(outputLayerInputs);
        }
    }


    public void setPatterns(double[][] patterns) {
        this.patterns = patterns;
    }

    public void setAnswers(double[][] answers) {
        this.answers = answers;
    }


}