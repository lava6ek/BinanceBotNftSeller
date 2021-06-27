package jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

public class ControllerJframe {
    String output;
    JLabel textLable;
    JTextArea textArea;
    boolean pause = true;


    public ControllerJframe() {

        //Создаем фрейм (окно)
        JFrame frame = new JFrame("Binance Auction Buyer");

        //Просим программу закрыться при закрытии фрейма
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();

        //JPanel panel = new JPanel();
        //panel.setSize(600, 600);

        //Создадим кнопку и поместим ее во фрейм
        JButton pauseButton = new JButton("BUY START/PAUSE");
        frame.add(pauseButton, BorderLayout.SOUTH);
        //Добавим к кнопке слушатель события
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pause) {
                    pause = false;
                    textArea.setText(textArea.getText() + "\nstarted");
                } else {
                    pause = true;
                    textArea.setText(textArea.getText() + "\npaused");
                }
            }
        });

        //Создадим лейбл и поместим его во фрейм
        textLable = new JLabel("Info: ");
        container.add(textLable, BorderLayout.NORTH);

        //Создаем textArea с ползунком
        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        setTextArea("Нажмите старт для запуска бота\n");

        JScrollPane scroll = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        container.add(scroll, BorderLayout.CENTER);

        //2 метод. Размеры окна
        frame.setSize(800, 400);

        //Показать фрейм
        frame.setVisible(true);

        //Поверх всех окон
        frame.setAlwaysOnTop(true);
    }

    public void updateTextArea(String newText) {
        //Обновляем содержимое Лейбла
        //String newInput = convertString(newText,"UTF-8","Windows-1251");
        textArea.setText(textArea.getText() + "\n" + newText);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public void updateTextArea() {
        //Обновляем содержимое Лейбла
        if (!pause) {
            Point loc = MouseInfo.getPointerInfo().getLocation();
            double x = loc.getX();
            double y = loc.getY();
            textArea.setText(textArea.getText() + "\n" + ("x=" + x + " " + "y=" + y));
        }
    }

    public void setTextArea(String input) {
        //String newInput = convertString(input,"UTF-8","Windows-1251");
        textArea.setText(input);
    }

    public static String convertString(
            String inputString,
            String from,   //encoding of input
            String to) {

        byte[] input = inputString.getBytes(Charset.forName(from));
        String output = new String(input, Charset.forName(to));
        return output;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public boolean isPause() {
        return pause;
    }
}
