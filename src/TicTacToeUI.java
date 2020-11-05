import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// The Frame holds the contents of the window
class TicTacToeUI extends JFrame implements /*ItemListener,*/ ActionListener {

    JButton newGameButton;
    JButton[] gameSquares;
    JPanel boxPanel;
    boolean state;
    Icon iconX, iconO, icon;
    TicTacToeController controller;

   //TODO: Fix rendering of tic tac toe game
    TicTacToeUI(TicTacToeController controller){
        super("Tic Tac Toe");
        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));
        setContentPane(boxPanel);
        setVisible(true);
        setSize(300,320);
        // Add new game button
        newGameButton = new JButton("New Game");
        newGameButton.setBounds(100,100,1,1);
        boxPanel.add(newGameButton);
        newGameButton.addActionListener(this);

        gameSquares = new JButton[9];
        state = true;
        iconX = new ImageIcon("X.png");
        iconO = new ImageIcon("O.png");

        this.controller = controller;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(newGameButton)) {
            remove(newGameButton);
            repaint();
            newGame();
        }
        else {
            for(int i = 0; i < gameSquares.length; i++) {
                if(e.getSource().equals(gameSquares[i])) {
                    if(state) {
                        if(controller.isValidMove(i+1, 1)) {
                            state = false;
                            icon = iconX;
                            gameSquares[i].setIcon(icon);
                        }
                        else {
                            //TODO: add invalid move dialog
                        }
                    }
                    else {
                        if(controller.isValidMove(i+1, 2)) {
                            state = true;
                            icon = iconO;
                            gameSquares[i].setIcon(icon);
                        }
                        else {
                            //TODO: add invalid move dialog
                        }
                    }
                }
            }
        }
    }

    public void newGame() {
        int x = 10;
        int y = 10;
        int j = 0;
        for(int i = 0; i < 9; i++, j++, x+=95) {
            if(j == 3) {
                x = 10;
                j = 0;
                y += 95;
            }
            gameSquares[i] = new JButton();
            gameSquares[i].setBounds(x, y, 90, 90);
            add(gameSquares[i]);
            gameSquares[i].addActionListener(this);
        }
    }
}