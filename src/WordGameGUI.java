import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WordGameGUI extends JFrame implements ActionListener {

    String[] words = {"java", "program", "computer", "game", "keyboard"};
    String word;
    char[] guessed;

    int attempts = 6;

    JLabel wordLabel, attemptsLabel, messageLabel;
    JTextField inputField;
    JButton guessButton;

    public WordGameGUI() {
        setTitle("Word Guess Game");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Random rand = new Random();
        word = words[rand.nextInt(words.length)];
        guessed = new char[word.length()];
        Arrays.fill(guessed, '_');

        wordLabel = new JLabel(getWordDisplay());
        attemptsLabel = new JLabel("Attempts left: " + attempts);
        messageLabel = new JLabel("Enter a letter");

        inputField = new JTextField(5);
        guessButton = new JButton("Guess");

        guessButton.addActionListener(this);

        add(wordLabel);
        add(attemptsLabel);
        add(inputField);
        add(guessButton);
        add(messageLabel);

        setVisible(true);
    }

    public String getWordDisplay() {
        StringBuilder sb = new StringBuilder();
        for (char c : guessed) {
            sb.append(c).append(" ");
        }
        return sb.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();

        if (input.isEmpty()) return;

        char letter = input.charAt(0);
        inputField.setText("");

        boolean found = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessed[i] = letter;
                found = true;
            }
        }

        if (!found) {
            attempts--;
            messageLabel.setText("Wrong guess!");
        } else {
            messageLabel.setText("Correct!");
        }

        wordLabel.setText(getWordDisplay());
        attemptsLabel.setText("Attempts left: " + attempts);

        if (String.valueOf(guessed).equals(word)) {
            JOptionPane.showMessageDialog(this, "🎉 You Won! Word: " + word);
            System.exit(0);
        }

        if (attempts == 0) {
            JOptionPane.showMessageDialog(this, "😢 You Lost! Word: " + word);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new WordGameGUI();
    }
}