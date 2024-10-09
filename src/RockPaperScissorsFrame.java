import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl; // Add to JFrame
    JPanel statsPnl; // Top
    JPanel displayPnl; // Center
    JPanel controlPnl; // Bottom for buttons

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    JTextField playerWinsField;
    JLabel playerWinsLabel;
    JTextField computerWinsField;
    JLabel computerWinsLabel;
    JTextField tiesField;
    JLabel tiesLabel;
    JTextArea resultsTextArea;

    int playerWins = 0;
    int computerWins = 0;
    int ties = 0;


    public RockPaperScissorsFrame(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);

        setTitle("Rock Paper Scissors Game");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Create the main panels
        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createStatsPanel();
        mainPnl.add(statsPnl, BorderLayout.NORTH);





    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setLayout(new FlowLayout());
        controlPnl.setBorder(new TitledBorder("Make Your Choice"));

        // Create buttons with images (add images in the src directory of your IntelliJ project)
        rockBtn = new JButton(new ImageIcon("src/rock.png"));
        paperBtn = new JButton(new ImageIcon("src/paper.png"));
        scissorsBtn = new JButton(new ImageIcon("src/scissors.png"));
        quitBtn = new JButton(new ImageIcon("src/quit.png"));

        // Add action listeners
        rockBtn.addActionListener(new ChoiceListener("Rock"));
        paperBtn.addActionListener(new ChoiceListener("Paper"));
        scissorsBtn.addActionListener(new ChoiceListener("Scissors"));
        quitBtn.addActionListener(e -> System.exit(0));

        // Add buttons to the panel
        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
        controlPnl.add(quitBtn);


    }
    private void createDisplayPanel() {
        displayPnl = new JPanel();
        displayPnl.setLayout(new BorderLayout());
        displayPnl.setBorder(new TitledBorder("Game Results"));

        resultsTextArea = new JTextArea(8, 50);
        resultsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsTextArea);

        displayPnl.add(scrollPane, BorderLayout.CENTER);
    }
    private void createStatsPanel() {
        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(3, 2));
        statsPnl.setBorder(new TitledBorder("Game Stats"));

        // Create labels and text fields
        playerWinsLabel = new JLabel("Player Wins:");
        computerWinsLabel = new JLabel("Computer Wins:");
        tiesLabel = new JLabel("Ties:");

        playerWinsField = new JTextField("0", 5);
        playerWinsField.setEditable(false);
        computerWinsField = new JTextField("0", 5);
        computerWinsField.setEditable(false);
        tiesField = new JTextField("0", 5);
        tiesField.setEditable(false);

        // Add to panel
        statsPnl.add(playerWinsLabel);
        statsPnl.add(playerWinsField);
        statsPnl.add(computerWinsLabel);
        statsPnl.add(computerWinsField);
        statsPnl.add(tiesLabel);
        statsPnl.add(tiesField);


    }
    private class ChoiceListener implements ActionListener {
        private String playerChoice;

        public ChoiceListener(String playerChoice) {
            this.playerChoice = playerChoice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String computerChoice = getComputerChoice();
            String result = determineWinner(playerChoice, computerChoice);

            // Update results in the text area
            resultsTextArea.append("Player: " + playerChoice + " | Computer: " + computerChoice + " -> " + result + "\n");

            // Update stats
            playerWinsField.setText(String.valueOf(playerWins));
            computerWinsField.setText(String.valueOf(computerWins));
            tiesField.setText(String.valueOf(ties));
        }

        private String getComputerChoice() {
            String[] choices = {"Rock", "Paper", "Scissors"};
            Random random = new Random();
            return choices[random.nextInt(choices.length)];
        }

        private String determineWinner(String playerChoice, String computerChoice) {
            if (playerChoice.equals(computerChoice)) {
                ties++;
                return "It's a tie!";
            } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                    (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                    (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
                playerWins++;
                return "You win!";
            } else {
                computerWins++;
                return "Computer wins!";
            }
        }
    }
}
