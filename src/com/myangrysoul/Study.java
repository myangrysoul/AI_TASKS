package com.myangrysoul;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Study {
    private final NeuralNet net1;
    private final double step = 0.25;

    private final double[][] patterns = {
            { -1, -1, 1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1 },
            { 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, -1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, -1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1 }

    };
    private final double[][] answers = {
            {1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,1,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,1},
    };

    public Study(NeuralNet net1) {
        this.net1 = net1;
    }

    public void initNet() {
        net1.setPatterns(patterns);
        net1.setAnswers(answers);
        net1.initOutputLayer(patterns[0]);
    }

    public void study() {
        int counter = 0;
        ArrayList<Neuron> outputLayer;
        double[] outputs = new double[10];
        do {
            for (int numOfPatterns = 0; numOfPatterns < patterns.length; numOfPatterns++) {
                net1.setOutputLayerInputs(patterns[numOfPatterns]);
                outputLayer = net1.getOutputLayer();
                for (int idx = 0; idx < 10; idx++) {
                    double[] weigths = outputLayer.get(idx).getWeights();
                    double[] newWeights = new double[weigths.length];
                    for (int i = 0; i < weigths.length; i++) {
                        newWeights[i] = weigths[i] + patterns[numOfPatterns][i] * answers[numOfPatterns][idx];

                    }
                    outputLayer.get(idx).setWeights(newWeights);

                }
                net1.countOutput();
                outputs = net1.getOutputLayerOut();
                if (counter ==200) {
                    for (double out : patterns[numOfPatterns]
                    ) {
                        System.out.println(out);

                    }
                    System.out.println("//////////////////////");
                    for (double out : outputs
                    ) {
                        System.out.println(out);

                    }

                }
            }

            counter++;
        }
        while (true);

    }
}