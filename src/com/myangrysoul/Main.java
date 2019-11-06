package com.myangrysoul;

public class Main {

    public static void main(String[] args) {
	NeuralNet net=new NeuralNet(25,10);
	Study study=new Study(net);
	study.initNet();
	study.study();
    }
}
