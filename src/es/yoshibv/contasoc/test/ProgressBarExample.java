package es.yoshibv.contasoc.test;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ProgressBarExample {
    private JFrame frame;
    private JProgressBar progressBar;
    private Timer timer;
    private int progress;

    public ProgressBarExample() {
    	progressBar = new JProgressBar(0, 100);
        frame = new JFrame("Progress Bar Example");
        
        progress = 0;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(null);

        progressBar.setBounds(50, 30, 200, 30);

        frame.add(progressBar);
        frame.setVisible(true);

        llenarBarra();
        
    }
    private void llenarBarra() {
        timer = new Timer(1000, e -> updateProgress());
        timer.start();
    }

    private void updateProgress() {
        progress += 10;
        progressBar.setValue(progress);

        if (progress >= 100) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        new ProgressBarExample();
        
    }
}
