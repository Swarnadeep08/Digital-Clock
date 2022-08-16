package com.clock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyWindow extends JFrame
{
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    private JLabel dayLabel;
    private JLabel clockLabel;
    private JLabel dateLabel;
    private final Font smallFont = new Font("Monospaced", Font.PLAIN, 24);
    private final Font largeFont = new Font("Monospaced", Font.BOLD, 40);

    MyWindow()
    {
        super.setTitle("Digital Clock");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        this.setResizable(false);
        this.setLocation(300, 200);
        this.setLayout(new GridLayout(3,1));
        this.getContentPane().setBackground(Color.MAGENTA);

        this.createGUI();

        this.setVisible(true);

        this.updateTime();
    }

    public void createGUI()
    {
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        clockLabel = new JLabel();
        clockLabel.setFont(largeFont);
        clockLabel.setForeground(Color.white);
        clockLabel.setBackground(Color.darkGray);
        clockLabel.setOpaque(true);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dayFormat = new SimpleDateFormat("EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(largeFont);
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        dateLabel = new JLabel();
        dateLabel.setFont(smallFont);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(dayLabel);
        this.add(dateLabel);
        this.add(clockLabel);
    }

    public void updateTime(){
        while(true){
            String time = timeFormat.format(Calendar.getInstance().getTime());
            clockLabel.setText(time);

            String day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            String date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
