/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perlintest1;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author 344169834
 */
public class PerlinTest1 extends Canvas {

    /**
     * @param args the command line arguments
     */
    static double[] heights = new double[25];
    public static double interpolate(double height1, double height2, double ratio){
        double ft = ratio * Math.PI;
        double f = (1 - Math.cos(ft)) * 0.5;
        return height1 * (1 - f) + height2 * f;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        for (int i = 0; i < heights.length; i++){
            heights[i] = Math.random();
        }
        Canvas canvas = new PerlinTest1();
        canvas.setSize(384, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int v = 10;
        int o = 300;
        Color red = new Color(205,133,63);
        g.setColor(red);
        for (int i = 0; i < 24; i++){
            g.fillRect(i*16,(int)(heights[i]*v)+o,4,400);
            g.fillRect(i*16+2, (int)(interpolate(heights[i], heights[i+1], 0.125)*v)+o, 4, 400);
            g.fillRect(i*16+4, (int)(interpolate(heights[i], heights[i+1], 0.25)*v)+o, 4, 400);
            g.fillRect(i*16+6, (int)(interpolate(heights[i], heights[i+1], 0.375)*v)+o, 4, 400);
            g.fillRect(i*16+8, (int)(interpolate(heights[i], heights[i+1], 0.5)*v)+o, 4, 400);
            g.fillRect(i*16+10, (int)(interpolate(heights[i], heights[i+1], 0.625)*v)+o, 4, 400);
            g.fillRect(i*16+12, (int)(interpolate(heights[i], heights[i+1], 0.75)*v)+o, 4, 400);
            g.fillRect(i*16+14, (int)(interpolate(heights[i], heights[i+1], 0.875)*v)+o, 4, 400);
        }
        Color green = new Color(124, 252, 0);
        g.setColor(green);
        o-=4;
        for (int i = 0; i < 24; i++){
            g.fillRect(i*16,(int)(heights[i]*v)+o,4,4);
            g.fillRect(i*16+2, (int)(interpolate(heights[i], heights[i+1], 0.125)*v)+o, 4, 4);
            g.fillRect(i*16+4, (int)(interpolate(heights[i], heights[i+1], 0.25)*v)+o, 4, 4);
            g.fillRect(i*16+6, (int)(interpolate(heights[i], heights[i+1], 0.375)*v)+o, 4, 4);
            g.fillRect(i*16+8, (int)(interpolate(heights[i], heights[i+1], 0.5)*v)+o, 4, 4);
            g.fillRect(i*16+10, (int)(interpolate(heights[i], heights[i+1], 0.625)*v)+o, 4, 4);
            g.fillRect(i*16+12, (int)(interpolate(heights[i], heights[i+1], 0.75)*v)+o, 4, 4);
            g.fillRect(i*16+14, (int)(interpolate(heights[i], heights[i+1], 0.875)*v)+o, 4, 4);
        }
    }

}
