import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl; // Add to JFrame
    JPanel statsPnl; // Top
    JPanel displayPnl; // Center
    JPanel controlPnl; // Bottom for buttons

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    JLabel playerWinsLabel;
    JLabel titleLbl;
    JTextField playerWinsField;
    JLabel computerWinsLabel;
    JTextField computerWinsField;
    JLabel tiesLabel;
    JTextField tiesField;
    JScrollPane resultsScrollPane;
    JTextArea resultsTextArea;

    int playerWins;
    int computerWins;
    int ties;
    String lastPlayerMove;
    String lastComputerMove;

    public RockPaperScissorsFrame(){

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);




        playerWinsLabel = new JLabel("Player Wins");
        playerWinsField = new JTextField(5);
        playerWinsField.setEditable(false);

        computerWinsLabel = new JLabel("Computer Wins");
        computerWinsField = new JTextField(5);
        computerWinsField.setEditable(false);



        tiesLabel = new JLabel("It's A Tie");
        tiesField = new JTextField(5);
        tiesField.setEditable(false);

        createStatsPanel();
        mainPnl.add(statsPnl, BorderLayout.NORTH);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);
        add(mainPnl);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,4));
        controlPnl.setBorder(BorderFactory.createTitledBorder("Select Your Move"));


        rockBtn = new JButton(new ImageIcon("src/rock.png"));


        paperBtn = new JButton(new ImageIcon("src/paper.png"));
        scissorsBtn = new JButton(new ImageIcon("src/scissors.png"));
        quitBtn = new JButton(new ImageIcon("src/quit.png"));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));


        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
    }
    private void createDisplayPanel() {
        displayPnl = new JPanel();
        resultsTextArea = new JTextArea(10,25);
        resultsTextArea.setEditable(false);
        resultsScrollPane = new JScrollPane(resultsTextArea);
        displayPnl.add(resultsScrollPane);

        resultsScrollPane = new JScrollPane();
        resultsScrollPane.setBorder(BorderFactory.createTitledBorder("Results"));
    }
    private void createStatsPanel() {
        statsPnl = new JPanel();
        statsPnl.setBorder(BorderFactory.createTitledBorder("Stats"));
        statsPnl.add(playerWinsLabel);
        statsPnl.add(playerWinsField);
        statsPnl.add(computerWinsLabel);
        statsPnl.add(computerWinsField);
        statsPnl.add(tiesLabel);
        statsPnl.add(tiesField);

    }

}
