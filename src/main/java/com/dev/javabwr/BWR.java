package com.dev.javabwr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BWR extends JFrame {
    private JLabel timeLabel;
    private JTextField rpvPressureField, rpvTempField, rpvLevelField, srmField, periodField, irmField, aprmField, coreFlowField;
    private JProgressBar rpvLevelBar;
    private JComboBox<String> irmRangeCombo;
    private JRadioButton runMode, startupMode, shutdownMode;
    private JButton scramButton, autoRodManagementButton;

    public BWR() {
        setTitle("BWR Control Panel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Panel for Current Time
        JPanel headerPanel = new JPanel();
        timeLabel = new JLabel("Current Time: ");
        headerPanel.add(timeLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Main Control Panel
        JPanel mainPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        // RPV Measurements
        mainPanel.add(new JLabel("RPV Pressure (PSI):"));
        rpvPressureField = new JTextField();
        rpvPressureField.setEditable(false);
        mainPanel.add(rpvPressureField);

        mainPanel.add(new JLabel("RPV Temp (K):"));
        rpvTempField = new JTextField();
        rpvTempField.setEditable(false);
        mainPanel.add(rpvTempField);

        mainPanel.add(new JLabel("RPV Level (IN/Bar):"));
        JPanel levelPanel = new JPanel(new BorderLayout());
        rpvLevelField = new JTextField();
        rpvLevelField.setEditable(false);
        rpvLevelBar = new JProgressBar(0, 1000);
        levelPanel.add(rpvLevelField, BorderLayout.NORTH);
        levelPanel.add(rpvLevelBar, BorderLayout.CENTER);
        mainPanel.add(levelPanel);

        // SRM and PERIOD
        mainPanel.add(new JLabel("SRM (CPS):"));
        srmField = new JTextField();
        srmField.setEditable(false);
        mainPanel.add(srmField);

        mainPanel.add(new JLabel("Period (SEC):"));
        periodField = new JTextField();
        periodField.setEditable(false);
        mainPanel.add(periodField);

        // IRM
        mainPanel.add(new JLabel("IRM (% + Range):"));
        JPanel irmPanel = new JPanel(new BorderLayout());
        irmField = new JTextField();
        irmField.setEditable(false);
        irmRangeCombo = new JComboBox<>(new String[]{"Range 1", "Range 2", "Range 3", "Range 4"});
        irmPanel.add(irmField, BorderLayout.NORTH);
        irmPanel.add(irmRangeCombo, BorderLayout.CENTER);
        mainPanel.add(irmPanel);

        // APRM and Core Flow
        mainPanel.add(new JLabel("APRM (%):"));
        aprmField = new JTextField();
        aprmField.setEditable(false);
        mainPanel.add(aprmField);

        mainPanel.add(new JLabel("Core Flow (%):"));
        coreFlowField = new JTextField();
        coreFlowField.setEditable(false);
        mainPanel.add(coreFlowField);

        add(mainPanel, BorderLayout.CENTER);

        // Bottom Panel for Reactor Mode and Rod Management
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        // Automatic Rod Management Button
        JPanel rodControlPanel = new JPanel();
        rodControlPanel.setBorder(BorderFactory.createTitledBorder("Automatic Rod Management"));
        autoRodManagementButton = new JButton("Enable Automatic Rod Management");
        rodControlPanel.add(autoRodManagementButton);
        bottomPanel.add(rodControlPanel);

        // Reactor Mode Panel
        JPanel reactorModePanel = new JPanel(new GridLayout(4, 1));
        reactorModePanel.setBorder(BorderFactory.createTitledBorder("Reactor Mode"));

        ButtonGroup modeGroup = new ButtonGroup();
        runMode = new JRadioButton("RUN");
        startupMode = new JRadioButton("STARTUP");
        shutdownMode = new JRadioButton("SHUTDOWN");
        modeGroup.add(runMode);
        modeGroup.add(startupMode);
        modeGroup.add(shutdownMode);

        reactorModePanel.add(runMode);
        reactorModePanel.add(startupMode);
        reactorModePanel.add(shutdownMode);

        scramButton = new JButton("SCRAM");
        scramButton.setBackground(Color.RED);
        scramButton.setForeground(Color.WHITE);
        reactorModePanel.add(scramButton);

        bottomPanel.add(reactorModePanel);
        add(bottomPanel, BorderLayout.SOUTH);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    private void updateTime() {
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        timeLabel.setText("Current Time: " + currentTime);
    }
}
