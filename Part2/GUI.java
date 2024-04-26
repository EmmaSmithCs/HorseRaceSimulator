import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

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

        // Create a card layout for the main content
        CardLayout cardLayout = new CardLayout();
        JPanel contentPanel = new JPanel(cardLayout);
        panel.add(contentPanel, BorderLayout.CENTER);

        // Create the home page panel
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        // Add a new panel to hold the races
        JPanel racesPanel = new JPanel();
        racesPanel.setLayout(new GridLayout(3, 1));
        racesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        racesPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 5));
        racesPanel.setPreferredSize(new Dimension(1000, 400)); // Set the panel size to 300x400
        homePanel.add(racesPanel, BorderLayout.WEST);

        // Add buttons on the right 
        JButton tracksButton = new JButton("Tracks");
        JButton horsesButton = new JButton("Horses");
        JButton betsButton = new JButton("Bets");
        JButton stats = new JButton("Stats");
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
        stats.setBackground(Color.PINK);
        tracksButton.setFont(new Font("Arial", Font.PLAIN, 30));
        horsesButton.setFont(new Font("Arial", Font.PLAIN, 30));
        betsButton.setFont(new Font("Arial", Font.PLAIN, 30));
        currentBetLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        currentHorseLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        startRace.setFont(new Font("Arial", Font.PLAIN, 30));
        stats.setFont(new Font("Arial", Font.PLAIN, 30));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(432, buttonsPanel.getHeight()));
        buttonsPanel.setLayout(new GridLayout(7, 1, 0, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add empty border around buttonsPanel
        buttonsPanel.add(tracksButton);
        buttonsPanel.add(horsesButton);
        buttonsPanel.add(betsButton);
        buttonsPanel.add(stats);
        buttonsPanel.add(currentBetLabel);
        buttonsPanel.add(currentHorseLabel);
        buttonsPanel.add(startRace);
        

        homePanel.add(buttonsPanel, BorderLayout.EAST);

        contentPanel.add(homePanel, "home"); // Add the home panel to the content panel with the name "home"

        // Create the tracks panel
        JPanel tracksPanel = new JPanel();
        tracksPanel.setLayout(new BorderLayout());
           
        // Create a panel for creating tracks on the left
        JPanel createTrackPanel = new JPanel();
        createTrackPanel.setLayout(new BorderLayout());
        createTrackPanel.setPreferredSize(new Dimension(722, 400));
        createTrackPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        createTrackPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 5));

        // Create components for creating tracks
        JLabel createTrackLabel = new JLabel("Create Track");
        createTrackLabel.setFont(new Font("Arial", Font.BOLD, 20));
        createTrackLabel.setHorizontalAlignment(JLabel.CENTER);
        createTrackLabel.setBackground(Color.PINK);
        createTrackLabel.setOpaque(true);
        createTrackPanel.add(createTrackLabel, BorderLayout.NORTH);

        // Create a panel for the track details
        JPanel trackDetailsPanel = new JPanel();
        trackDetailsPanel.setLayout(new GridLayout(5, 2, 10, 10));
        trackDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create labels and fields for track details
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel lengthLabel = new JLabel("Length:");
        JTextField lengthField = new JTextField();
        JLabel surfaceLabel = new JLabel("Surface:");
        String[] surfaceOptions = {"Dirt", "Grass", "Synthetic", "Mud", "Ice"};
        JComboBox<String> surfaceComboBox = new JComboBox<>(surfaceOptions);
        JLabel lanesLabel = new JLabel("Lanes:");
        JTextField lanesField = new JTextField();

        // Change the font size of the labels
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        lengthLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        surfaceLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        lanesLabel.setFont(new Font("Arial", Font.PLAIN, 50));

        // Change the font of the inputs
        nameField.setFont(new Font("Arial", Font.PLAIN, 50));
        lengthField.setFont(new Font("Arial", Font.PLAIN, 50));
        surfaceComboBox.setFont(new Font("Arial", Font.PLAIN, 50));
        lanesField.setFont(new Font("Arial", Font.PLAIN, 50));

        // Add labels and fields to the track details panel
        trackDetailsPanel.add(nameLabel);
        trackDetailsPanel.add(nameField);
        trackDetailsPanel.add(lengthLabel);
        trackDetailsPanel.add(lengthField);
        trackDetailsPanel.add(surfaceLabel);
        trackDetailsPanel.add(surfaceComboBox);
        trackDetailsPanel.add(lanesLabel);
        trackDetailsPanel.add(lanesField);

        // Create a button to add the track
        JButton addTrackButton = new JButton("Add Track");
        addTrackButton.setPreferredSize(new Dimension(432, trackDetailsPanel.getHeight()));
        addTrackButton.setBackground(Color.PINK);
        addTrackButton.setFont(new Font("Arial", Font.PLAIN, 50));

        // Add clear button for track adding
        JButton clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(432, trackDetailsPanel.getHeight()));
        clearButton.setBackground(Color.PINK);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 50));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            nameField.setText("");
            lengthField.setText("");
            surfaceComboBox.setSelectedIndex(0);
            lanesField.setText("");
            }
        });

        trackDetailsPanel.add(clearButton);

        // Add the track details panel to the create track panel
        createTrackPanel.add(trackDetailsPanel, BorderLayout.CENTER);

        // Add the create track panel to the tracks panel
        tracksPanel.add(createTrackPanel, BorderLayout.WEST);

        // Add the tracks panel to the content panel
        contentPanel.add(tracksPanel, "tracks");
        addTrackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            int length = Integer.parseInt(lengthField.getText());
            String surface = (String) surfaceComboBox.getSelectedItem();
            int lanes = Integer.parseInt(lanesField.getText());

            Track newTrack = new Track(name, length, surface, lanes);

            // Check if the track name already exists
            boolean trackExists = false;
            try (BufferedReader reader = new BufferedReader(new FileReader("storedTracks.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(newTrack.getName())) {
                        trackExists = true;
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (trackExists == true) {
                lanesField.setText("");
                    nameField.setText("");
                    lengthField.setText("");
                    surfaceComboBox.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Track name already exists. Please enter a different name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try (FileWriter writer = new FileWriter("storedTracks.txt", true)) {
                    writer.write(newTrack.getName() + "\n");
                    writer.write(newTrack.getTrackLength() + "\n");
                    writer.write(newTrack.getSurface() + "\n");
                    writer.write(newTrack.getLanes() + "\n");
                    writer.write("\n");
                    lanesField.setText("");
                    nameField.setText("");
                    lengthField.setText("");
                    surfaceComboBox.setSelectedIndex(0);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
           
           

            }
        });
        trackDetailsPanel.add(addTrackButton);

        // Add the track details panel to the create track panel
        createTrackPanel.add(trackDetailsPanel, BorderLayout.CENTER);

        // Add the stored tracks panel to the tracks panel
        // Create a panel to display stored tracks
        JPanel storedTracksPanel = new JPanel();
        storedTracksPanel.setLayout(new BorderLayout());

        // Create a label for the stored tracks
        JLabel storedTracksLabel = new JLabel("Stored Tracks");
        storedTracksLabel.setFont(new Font("Arial", Font.BOLD, 20));
        storedTracksLabel.setHorizontalAlignment(JLabel.CENTER);
        storedTracksLabel.setBackground(Color.PINK);
        storedTracksLabel.setOpaque(true);
        storedTracksPanel.add(storedTracksLabel, BorderLayout.NORTH);

        // Create a panel to hold the stored tracks
        JPanel tracksListPanel = new JPanel();
        tracksListPanel.setLayout(new GridLayout(0, 1, 10, 10));
        tracksListPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create a scroll pane for the tracks list panel
        JScrollPane scrollPane = new JScrollPane(tracksListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Read the stored tracks from the file
        try {
            File file = new File("storedTracks.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String trackName = scanner.nextLine();
                String trackLength = scanner.nextLine();
                String trackSurface = scanner.nextLine();
                String trackLanes = scanner.nextLine();
                scanner.nextLine(); // Skip the blank line

                JButton trackButton = new JButton("<html><font size='6'>" + trackName + "</font><br><font size='4'>Length: " + trackLength + "</font><br><font size='4'>Surface: " + trackSurface + "</font><br><font size='4'>Lanes: " + trackLanes + "</font></html>");
                trackButton.setFont(new Font("Arial", Font.PLAIN, 30));
                trackButton.setBackground(Color.WHITE); // Set the background color to white
                trackButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Set the background color of the clicked button to pink
                        JButton clickedButton = (JButton) e.getSource();
                        Component[] buttons = tracksListPanel.getComponents();
                        for (Component button : buttons) {
                            button.setBackground(Color.WHITE);
                        }
                        clickedButton.setBackground(Color.PINK);

                        Track track = new Track(trackName, Integer.parseInt(trackLength), trackSurface, Integer.parseInt(trackLanes));
                        setCurrentTrack(track);
                        System.out.println("Current Track: " + getCurrentTrack().getName());
                    }
                });
                tracksListPanel.add(trackButton);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        // Create a button to reload the tracks
        JButton reloadTracksButton = new JButton("Reload Tracks");
        reloadTracksButton.setFont(new Font("Arial", Font.PLAIN, 20));
        reloadTracksButton.setBackground(Color.PINK);
        reloadTracksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tracksListPanel.removeAll(); // Remove all existing track buttons
                try {
                    File file = new File("storedTracks.txt");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String trackName = scanner.nextLine();
                        String trackLength = scanner.nextLine();
                        String trackSurface = scanner.nextLine();
                        String trackLanes = scanner.nextLine();
                        scanner.nextLine(); // Skip the blank line

                        JButton trackButton = new JButton("<html><font size='6'>" + trackName + "</font><br><font size='4'>Length: " + trackLength + "</font><br><font size='4'>Surface: " + trackSurface + "</font><br><font size='4'>Lanes: " + trackLanes + "</font></html>");
                        trackButton.setFont(new Font("Arial", Font.PLAIN, 30));
                        trackButton.setBackground(Color.WHITE); // Set the background color to white
                        trackButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Set the background color of the clicked button to pink
                                JButton clickedButton = (JButton) e.getSource();
                                Component[] buttons = tracksListPanel.getComponents();
                                for (Component button : buttons) {
                                    button.setBackground(Color.WHITE);
                                }
                                clickedButton.setBackground(Color.PINK);

                                Track track = new Track(trackName, Integer.parseInt(trackLength), trackSurface, Integer.parseInt(trackLanes));
                                setCurrentTrack(track);
                                System.out.println("Current Track: " + getCurrentTrack().getName());
                            }
                        });
                        tracksListPanel.add(trackButton);
                    }
                    scanner.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                tracksListPanel.revalidate(); // Revalidate the panel to update the changes
                tracksListPanel.repaint(); // Repaint the panel to reflect the changes
            }
        });
        storedTracksPanel.add(reloadTracksButton, BorderLayout.SOUTH);

        // Add the scroll pane to the stored tracks panel
        storedTracksPanel.add(scrollPane, BorderLayout.CENTER);
        tracksPanel.add(storedTracksPanel, BorderLayout.CENTER);

        // Create a button to redirect to the main page
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBackground(Color.PINK);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            cardLayout.show(contentPanel, "home"); // Show the home panel when the back button is pressed
            }
        });
        tracksPanel.add(backButton, BorderLayout.SOUTH);

        contentPanel.add(tracksPanel, "tracks"); // Add the tracks panel to the content panel with the name "tracks"

        // Create the horses panel
        JPanel horsesPanel = new JPanel();
        horsesPanel.setLayout(new BorderLayout());
        // Add components to the horses panel

        contentPanel.add(horsesPanel, "horses"); // Add the horses panel to the content panel with the name "horses"

        // Create the bets panel
        JPanel betsPanel = new JPanel();
        betsPanel.setLayout(new BorderLayout());
        // Add components to the bets panel

        contentPanel.add(betsPanel, "bets"); // Add the bets panel to the content panel with the name "bets"

        // Add action listeners to the buttons
        tracksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "tracks"); // Show the tracks panel when the tracks button is pressed
            }
        });

        horsesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "horses"); // Show the horses panel when the horses button is pressed
            }
        });

        betsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "bets"); // Show the bets panel when the bets button is pressed
            }
        });

        frame.setVisible(true); // Set the frame visible after adding all the components

        
    }





    
    private Track currentTrack; // Declare the currentTrack variable

    public Track getCurrentTrack() {
        return currentTrack;
    }
    
    public void setCurrentTrack(Track track) {
        currentTrack = track;
    }

    
}

   
