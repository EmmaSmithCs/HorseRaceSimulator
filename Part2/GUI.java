import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        
        // Create a panel for creating horses on the left
        JPanel createHorsePanel = new JPanel();
        createHorsePanel.setLayout(new BorderLayout());
        createHorsePanel.setPreferredSize(new Dimension(500, 400));
        createHorsePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        createHorsePanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 5));

        // Create components for creating horses
        JLabel createHorseLabel = new JLabel("Create Horse");
        createHorseLabel.setFont(new Font("Arial", Font.BOLD, 20));
        createHorseLabel.setHorizontalAlignment(JLabel.CENTER);
        createHorseLabel.setBackground(Color.PINK);
        createHorseLabel.setOpaque(true);
        createHorsePanel.add(createHorseLabel, BorderLayout.NORTH);

        // Create a panel for the horse details
        JPanel horseDetailsPanel = new JPanel();
        horseDetailsPanel.setLayout(new GridLayout(4, 2, 10, 10));
        horseDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create labels and fields for horse details
        JLabel nameHorseLabel = new JLabel("Name:");
        JTextField nameHorseField = new JTextField();
        JLabel colourLabel = new JLabel("Colour:");
        String[] colours = {"White", "Light Brown", "Dark Brown", "Black"};
        JComboBox<String> colourComboBox = new JComboBox<>(colours);
        JLabel maneLabel = new JLabel("Mane:");
        String[] manes = {"White", "Light Brown", "Dark Brown", "Black"};
        JComboBox<String> maneComboBox = new JComboBox<>(colours);

        // Change the font size of the labels
        nameHorseLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        colourLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        maneLabel.setFont(new Font("Arial", Font.PLAIN, 50));

        // Change the font of the inputs
        nameHorseField.setFont(new Font("Arial", Font.PLAIN, 50));
        colourComboBox.setFont(new Font("Arial", Font.PLAIN, 30));
        maneComboBox.setFont(new Font("Arial", Font.PLAIN, 30));

        // Add labels and fields to the horse details panel
        horseDetailsPanel.add(nameHorseLabel);
        horseDetailsPanel.add(nameHorseField);
        horseDetailsPanel.add(colourLabel);
        horseDetailsPanel.add(colourComboBox);
        horseDetailsPanel.add(maneLabel);
        horseDetailsPanel.add(maneComboBox);

        // Create a button to add the horse
        JButton addHorseButton = new JButton("Add");
        addHorseButton.setPreferredSize(new Dimension(250, horseDetailsPanel.getHeight()));
        addHorseButton.setBackground(Color.PINK);
        addHorseButton.setFont(new Font("Arial", Font.PLAIN, 50));
        addHorseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameHorseField.getText();
                String colour = (String) colourComboBox.getSelectedItem();
                String mane = (String) maneComboBox.getSelectedItem();

                Horse newHorse = new Horse('H', name, colour, mane);

                // Check if the track name already exists
                boolean horseExists = false;
                try (BufferedReader reader = new BufferedReader(new FileReader("storedHorses.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.equals(newHorse.getName())) {
                            horseExists = true;
                            break;
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if (horseExists == true) {
                        nameHorseField.setText("");
                        colourComboBox.setSelectedIndex(0);
                        maneComboBox.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Horse name already exists. Please enter a different name.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try (FileWriter writer = new FileWriter("storedHorses.txt", true)) {
                        writer.write(newHorse.getName() + "\n");
                        writer.write(newHorse.getConfidence() + "\n");
                        writer.write(newHorse.getDistanceTravelled() + "\n");
                        writer.write(newHorse.getColour() + "\n");
                        writer.write(newHorse.getMane() + "\n");
                        writer.write("\n");
                        
                        nameHorseField.setText("");
                        colourComboBox.setSelectedIndex(0);
                        maneComboBox.setSelectedIndex(0);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            
           

            }
        });

        // Add clear button for horse adding
        JButton clearHorseButton = new JButton("Clear");
        clearHorseButton.setPreferredSize(new Dimension(250, horseDetailsPanel.getHeight()));
        clearHorseButton.setBackground(Color.PINK);
        clearHorseButton.setFont(new Font("Arial", Font.PLAIN, 50));
        clearHorseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameHorseField.setText("");
                colourComboBox.setSelectedIndex(0);
                maneComboBox.setSelectedIndex(0);
            }
        });

        horseDetailsPanel.add(clearHorseButton);
        horseDetailsPanel.add(addHorseButton);

        // Add the horse details panel to the create horse panel
        createHorsePanel.add(horseDetailsPanel, BorderLayout.CENTER);

        // Add the create horse panel to the horses panel
        horsesPanel.add(createHorsePanel, BorderLayout.WEST);

        // Add the horses panel to the content panel
        contentPanel.add(horsesPanel, "horses");

        // Create a panel to display created horses
        JPanel createdHorsesPanel = new JPanel();
        createdHorsesPanel.setLayout(new BorderLayout());

        // Create a label for the created horses
        JLabel createdHorsesLabel = new JLabel("Created Horses");
        createdHorsesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        createdHorsesLabel.setHorizontalAlignment(JLabel.CENTER);
        createdHorsesLabel.setBackground(Color.PINK);
        createdHorsesLabel.setOpaque(true);
        createdHorsesPanel.add(createdHorsesLabel, BorderLayout.NORTH);

        // Create a panel to hold the created horses
        JPanel horsesListPanel = new JPanel();
        horsesListPanel.setLayout(new GridLayout(0, 1, 10, 10));
        horsesListPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create a scroll pane for the horses list panel
        JScrollPane horsesScrollPane = new JScrollPane(horsesListPanel);
        horsesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Read the created horses from the file
        try {
            File file = new File("storedHorses.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String horseName = scanner.nextLine();
                String horseConfidence = scanner.nextLine();
                String horseDistance = scanner.nextLine();
                String horseColour = scanner.nextLine();
                String horseMane = scanner.nextLine();
                scanner.nextLine(); // Skip the blank line

                JButton horseButton = new JButton("<html><font size='6'>" + horseName + "</font><br><font size='4'>Confidence: " + horseConfidence + "</font><br><font size='4'>Distance: " + horseDistance + "</font><br><font size='4'>Colour: " + horseColour + "</font><br><font size='4'>Mane: " + horseMane + "</font></html>");
                horseButton.setFont(new Font("Arial", Font.PLAIN, 30));
                horseButton.setBackground(Color.WHITE); // Set the background color to white
                horseButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Set the background color of the clicked button to pink
                        JButton clickedButton = (JButton) e.getSource();
                        Component[] buttons = horsesListPanel.getComponents();
                        for (Component button : buttons) {
                            button.setBackground(Color.WHITE);
                        }
                        clickedButton.setBackground(Color.PINK);


                    }
                });
                horsesListPanel.add(horseButton);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }


        // Create a button to reload the created horses
        JButton relaodHorseButton = new JButton("Reload Horses");
        relaodHorseButton.setFont(new Font("Arial", Font.PLAIN, 20));
        relaodHorseButton.setBackground(Color.PINK);
        relaodHorseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                horsesListPanel.removeAll(); // Remove all existing track buttons
                try {
                    File file = new File("storedHorses.txt");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String horseName = scanner.nextLine();
                        String horseConfidence = scanner.nextLine();
                        String horseDistance = scanner.nextLine();
                        String horseColour = scanner.nextLine();
                        String horseMane = scanner.nextLine();
                        scanner.nextLine(); // Skip the blank line
        
                        JButton horseButton = new JButton("<html><font size='6'>" + horseName + "</font><br><font size='4'>Confidence: " + horseConfidence + "</font><br><font size='4'>Distance: " + horseDistance + "</font><br><font size='4'>Colour: " + horseColour + "</font><br><font size='4'>Mane: " + horseMane + "</font></html>");
                        horseButton.setFont(new Font("Arial", Font.PLAIN, 30));
                        horseButton.setBackground(Color.WHITE); // Set the background color to white
                        horseButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Set the background color of the clicked button to pink
                                JButton clickedButton = (JButton) e.getSource();
                                Component[] buttons = horsesListPanel.getComponents();
                                for (Component button : buttons) {
                                    button.setBackground(Color.WHITE);
                                }
                                clickedButton.setBackground(Color.PINK);
        
        
                            }
                        });
                        horsesListPanel.add(horseButton);
                    }
                    scanner.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
        
                horsesListPanel.revalidate(); // Revalidate the panel to update the changes
                horsesListPanel.repaint(); // Repaint the panel to reflect the changes
            }
        });
        createdHorsesPanel.add(relaodHorseButton, BorderLayout.SOUTH);


        // Add the scroll pane to the created horses panel
        createdHorsesPanel.add(horsesScrollPane, BorderLayout.CENTER);
        horsesPanel.add(createdHorsesPanel, BorderLayout.CENTER);

        // Create a panel to add a horse to each lane
        JPanel addHorseToLanePanel = new JPanel();
        addHorseToLanePanel.setLayout(new BorderLayout());
        addHorseToLanePanel.setPreferredSize(new Dimension(500, 400));
        addHorseToLanePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        addHorseToLanePanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 5));

        // Create components for adding a horse to each lane
        JLabel addHorseToLaneLabel = new JLabel("Add Horse to Lane");
        addHorseToLaneLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addHorseToLaneLabel.setHorizontalAlignment(JLabel.CENTER);
        addHorseToLaneLabel.setBackground(Color.PINK);
        addHorseToLaneLabel.setOpaque(true);
        addHorseToLanePanel.add(addHorseToLaneLabel, BorderLayout.NORTH);

        // Create a panel for the lane details
        JPanel laneDetailsPanel = new JPanel();
        laneDetailsPanel.setLayout(new GridLayout(3, 1, 10, 10));
        laneDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add a label below to show the current track
        // Add a label to show the current track
        JLabel currentTrackLabel = new JLabel("Current Track: " + (currentTrack != null ? currentTrack.getName() : "None"));
        currentTrackLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        currentTrackLabel.setHorizontalAlignment(JLabel.CENTER);
        laneDetailsPanel.add(currentTrackLabel);

        if (currentTrack != null) {
            // Create a panel to hold all the lanes
            JPanel allLanesPanel = new JPanel();
            allLanesPanel.setLayout(new GridLayout(currentTrack.getLanes(), 1, 10, 10));
            allLanesPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Loop through each lane in the current track
            for (int i = 0; i < currentTrack.getLanes(); i++) {
                // Create a panel for each lane
                JPanel lanePanel = new JPanel();
                lanePanel.setLayout(new GridLayout(2, 1, 10, 10));
                lanePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                // Create a label for the lane number
                JLabel laneLabel = new JLabel("Lane " + (i + 1));
                laneLabel.setFont(new Font("Arial", Font.PLAIN, 30));
                lanePanel.add(laneLabel);

                // Create a text field for entering the horse name
                JTextField horseNameField = new JTextField();
                horseNameField.setFont(new Font("Arial", Font.PLAIN, 30));
                lanePanel.add(horseNameField);

                // Add the lane panel to the all lanes panel
                allLanesPanel.add(lanePanel);
            }

            // Create a scroll pane for the all lanes panel
            JScrollPane lanesScrollPane = new JScrollPane(allLanesPanel);
            lanesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            // Add the lanes scroll pane to the lane details panel
            laneDetailsPanel.add(lanesScrollPane);
        }

        

        // Create a button to reload the lanes
        JButton reloadLanes = new JButton("Reload Lanes");
        reloadLanes.setFont(new Font("Arial", Font.PLAIN, 20));
        reloadLanes.setBackground(Color.PINK);
        reloadLanes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laneDetailsPanel.removeAll(); // Remove all existing track buttons
                    JLabel currentTrackLabel = new JLabel("Current Track: " + (currentTrack != null ? currentTrack.getName() : "None"));
                    currentTrackLabel.setFont(new Font("Arial", Font.PLAIN, 30));
                    currentTrackLabel.setHorizontalAlignment(JLabel.CENTER);
                    laneDetailsPanel.add(currentTrackLabel);

                    if (currentTrack != null) {
                        // Create a panel to hold all the lanes
                        JPanel allLanesPanel = new JPanel();
                        allLanesPanel.setLayout(new GridLayout(currentTrack.getLanes(), 1, 10, 10));
                        allLanesPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            
                        // Loop through each lane in the current track
                        for (int i = 0; i < currentTrack.getLanes(); i++) {
                            // Create a panel for each lane
                            JPanel lanePanel = new JPanel();
                            lanePanel.setLayout(new GridLayout(2, 1, 10, 10));
                            lanePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            
                            // Create a label for the lane number
                            JLabel laneLabel = new JLabel("Lane " + (i + 1));
                            laneLabel.setFont(new Font("Arial", Font.PLAIN, 30));
                            lanePanel.add(laneLabel);
            
                            // Create a text field for entering the horse name
                            JTextField horseNameField = new JTextField();
                            horseNameField.setFont(new Font("Arial", Font.PLAIN, 30));
                            lanePanel.add(horseNameField);
            
                            // Add the lane panel to the all lanes panel
                            allLanesPanel.add(lanePanel);
                        }
            
                        // Create a scroll pane for the all lanes panel
                        JScrollPane lanesScrollPane = new JScrollPane(allLanesPanel);
                        lanesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            
                        // Create a button to add all the lane horses to activeHorses
                        JButton addAllHorsesButton = new JButton("Add All Horses");
                        addAllHorsesButton.setFont(new Font("Arial", Font.PLAIN, 20));
                        addAllHorsesButton.setBackground(Color.PINK);
                        addAllHorsesButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                activeHorses.clear(); // Clear the activeHorses list
                                boolean invalidNames = false;
                                // Loop through each lane in the current track
                                for (int i = 0; i < currentTrack.getLanes(); i++) {
                                    // Get the horse name from the corresponding text field
                                    JPanel lanePanel = (JPanel) allLanesPanel.getComponent(i);
                                    JTextField horseNameField = (JTextField) lanePanel.getComponent(1);
                                    String horseName = horseNameField.getText();

                                    
                                    // Validate the horse name
                                    if (!horseName.isEmpty() && isHorseNameValid(horseName) && !activeHorses.contains(horseName)) {
                                        // Create a new Horse object with the horse name and add it to activeHorses
                                        activeHorses.add(horseName);
                                    }
                                    else {
                                        invalidNames = true;
                                    }
                                }
                                if (invalidNames) {
                                    JOptionPane.showMessageDialog(null, "Invalid horse names. Please enter valid horse names.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "All horses added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                }
                
                            }
                            
                        });
                        
                        // Add the lanes scroll pane to the lane details panel
                        laneDetailsPanel.add(lanesScrollPane);
                        laneDetailsPanel.add(addAllHorsesButton);
                    }
                
                    laneDetailsPanel.revalidate(); // Revalidate the panel to update the changes
                    laneDetailsPanel.repaint(); // Repaint the panel to reflect the changes
            }
        });
        addHorseToLanePanel.add(reloadLanes, BorderLayout.SOUTH);


        // Add the lane details panel to the add horse to lane panel
        addHorseToLanePanel.add(laneDetailsPanel, BorderLayout.CENTER);

        // Add the add horse to lane panel to the horses panel
        horsesPanel.add(addHorseToLanePanel, BorderLayout.EAST);











        // Create a button to redirect to the main page
        JButton backHorseButton = new JButton("Back");
        backHorseButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backHorseButton.setBackground(Color.PINK);
        backHorseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            cardLayout.show(contentPanel, "home"); // Show the home panel when the back button is pressed
            }
        });
        horsesPanel.add(backHorseButton, BorderLayout.SOUTH);




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





    private ArrayList<String> activeHorses = new ArrayList<>();
    private Track currentTrack; // Declare the currentTrack variable

    public Track getCurrentTrack() {
        return currentTrack;
    }
    
    public void setCurrentTrack(Track track) {
        currentTrack = track;
    }

    public boolean isHorseNameValid(String horseName) {
        try {
            // Read the storedHorse.txt file
            File file = new File("storedHorse.txt");
            Scanner scanner = new Scanner(file);

            // Check if the horse name exists in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(horseName)) {
                    scanner.close();
                    return false;
                }
                // Skip other lines related to horse details
                for (int i = 0; i < 7; i++) {
                    scanner.nextLine();
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
}

   
