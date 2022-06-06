package GUI;

import game.Dices;
import game.Game;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    private static JFrame frame;
    private ConfigurationPanel configurationPanel;
    private static Canvas canvas;
    private static JButton rollDicesButton;

    public MainFrame() {
        frame = new JFrame("Backgammon");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(880, 800);
        canvas = new Canvas();
        configurationPanel = new ConfigurationPanel();
        frame.getContentPane().add(configurationPanel, BorderLayout.NORTH);
        frame.getContentPane().add(canvas, BorderLayout.CENTER);

        rollDicesButton = new JButton(Icons.getInstance().rollDicesImage);
        rollDicesButton.setText("Roll");
        rollDicesButton.setEnabled(false);
        rollDicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDicesButton.setEnabled(false);
                Dices dices = new Dices();
                canvas.showDices(dices);
                canvas.revalidate();
                canvas.repaint();
            }
        });
        frame.getContentPane().add(rollDicesButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    public static void enableRollButton() {
        rollDicesButton.setEnabled(true);
    }

    public static JButton getRollDicesButton() {
        return rollDicesButton;
    }

    public static void displayWinner(Player player) {
        int option = JOptionPane.showConfirmDialog(frame, player.getPlayerName() + " has won the game! Do you wish to begin another game?", "Congrats!", JOptionPane.YES_NO_OPTION);
        if (option == 0)
        {
            frame.dispose();
            new MainFrame();
        }
        else
            System.exit(1);
    }

}
