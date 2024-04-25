import javax.swing.*;
import java.awt.*;

public class GUI {
    // Create the page for the simulation using swing
    public GUI() {
        // Create the frame
        JFrame frame = new JFrame("Horse Race Simulator");
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a title label
        JLabel titleLabel = new JLabel("Horse Race Simulator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(Color.PINK);
        titleLabel.setOpaque(true);
        panel.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel);

       
        // Add a new panel to hold the races
        JPanel racesPanel = new JPanel();
        racesPanel.setLayout(new GridLayout(3, 1));
        racesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        racesPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 5));
        racesPanel.setPreferredSize(new Dimension(1000, 400)); // Set the panel size to 300x400
        panel.add(racesPanel, BorderLayout.WEST);
        panel.add(racesPanel, BorderLayout.WEST);
        

        // Add 3 buttons on the right (Tracks, Horses, Bets)
        JButton tracksButton = new JButton("Tracks");
        JButton horsesButton = new JButton("Horses");
        JButton betsButton = new JButton("Bets");
        JLabel currentBet = new JLabel("Current Bet: None");
        currentBet.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel currentBetLabel = new JLabel("Current Bet: None");
        currentBetLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        currentBetLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel currentHorseLabel = new JLabel("Current Horse: None");
        currentHorseLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        currentHorseLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JButton startRace = new JButton("START RACE");
        tracksButton.setBackground(Color.PINK);
        horsesButton.setBackground(Color.PINK);
        betsButton.setBackground(Color.PINK);
        currentBet.setBackground(Color.PINK);
        startRace.setBackground(Color.PINK);
        tracksButton.setFont(new Font("Arial", Font.PLAIN, 30));
        horsesButton.setFont(new Font("Arial", Font.PLAIN, 30));
        betsButton.setFont(new Font("Arial", Font.PLAIN, 30));
        currentBetLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        currentHorseLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        startRace.setFont(new Font("Arial", Font.PLAIN, 30));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(432, buttonsPanel.getHeight()));
        buttonsPanel.setLayout(new GridLayout(6, 1, 0, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add empty border around buttonsPanel
        buttonsPanel.add(tracksButton);
        buttonsPanel.add(horsesButton);
        buttonsPanel.add(betsButton);
        buttonsPanel.add(currentBetLabel);
        buttonsPanel.add(currentHorseLabel);
        buttonsPanel.add(startRace);

        panel.add(buttonsPanel, BorderLayout.EAST);

        frame.setVisible(true); // Set the frame visible after adding all the components
      
        buttonsPanel.add(startRace);
        
        panel.add(buttonsPanel, BorderLayout.EAST);
    }
}

