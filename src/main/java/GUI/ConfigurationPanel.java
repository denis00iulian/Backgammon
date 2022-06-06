package GUI;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigurationPanel extends JPanel implements ActionListener {

    JButton newGameButton;
    JTextField player1Name;
    JTextField player2Name;
    Thread gameThread;

    ConfigurationPanel() {
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);
        player1Name = new JTextField("Player 1");
        player2Name = new JTextField("Player 2");
        player1Name.setPreferredSize(new Dimension(200, 30));
        player2Name.setPreferredSize(new Dimension(200, 30));
        this.setLayout(new FlowLayout());
        this.add(newGameButton);
        this.add(player1Name);
        this.add(player2Name);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Game.getInstance() != null) {
            int confirm = JOptionPane.showConfirmDialog(MainFrame.getFrame(), "There is a game running! Are you sure you wish to begin another game?", "Warning", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                Game.getInstance().stop();
                startNewGame();
            }
        } else {
            startNewGame();
        }
    }

    private void startNewGame() {
        if (!player1Name.getText().equals("") && !player2Name.getText().equals("")) {
            gameThread = new Thread(new Game(player1Name.getText(), player2Name.getText()));
            gameThread.start();
            while (Game.getBoard() == null) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            new BoardMouseListener();
            MainFrame.getCanvas().repaint();
        } else JOptionPane.showMessageDialog(MainFrame.getFrame(), "Player names not filled in!");
    }

}
