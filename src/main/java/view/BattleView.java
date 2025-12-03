package view;

import entity.Monster;
import entity.User;
import interface_adapter.battle.BattleController;
import interface_adapter.battle.BattleState;
import interface_adapter.battle.BattleViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for the Battle Use Case.
 * Displays the battle interface and handles user interactions.
 */
public class BattleView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Battle";
    private final BattleViewModel viewModel;
    private BattleController battleController;

    // UI Components
    private final JLabel titleLabel;
    private final JLabel userHpLabel;
    private final JLabel monsterNameLabel;
    private final JLabel monsterHpLabel;
    private final JTextArea battleMessageArea;
    private final JButton attackButton;

    public BattleView(BattleViewModel battleViewModel, InventoryView inventoryView) {
        this.viewModel = battleViewModel;
        this.viewModel.addPropertyChangeListener(this);

        // Initialize UI components
        titleLabel = new JLabel("Battle", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));

        userHpLabel = new JLabel("HP: N/A");
        userHpLabel.setFont(new Font("Arial", Font.BOLD, 18));

        monsterNameLabel = new JLabel("Monster: N/A");
        monsterNameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        monsterHpLabel = new JLabel("HP: N/A");
        monsterHpLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Battle Log
        battleMessageArea = new JTextArea(12, 50);
        battleMessageArea.setEditable(false);
        battleMessageArea.setLineWrap(true);
        battleMessageArea.setWrapStyleWord(true);
        battleMessageArea.setText("Battle is ready to begin...");
        battleMessageArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        attackButton = new JButton("Attack");
        attackButton.setFont(new Font("Arial", Font.BOLD, 16));
        attackButton.setPreferredSize(new Dimension(120, 40));

        // Add action listeners
        attackButton.addActionListener(this);

        // Layout setup
        setupLayout();

        if (inventoryView != null) {
            inventoryView.setPreferredSize(new Dimension(280, 0));
            add(inventoryView, BorderLayout.EAST);
            revalidate();
            repaint();
        }

        setPreferredSize(new Dimension(900, 600));
    }

    /**
     * Sets up the layout of the view.
     */
    private void setupLayout() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Center panel with battle info
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel statsPanel = new JPanel(new GridLayout(1, 2, 20, 0));

        // User info panel
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(67, 109, 144), 2),
                "Player",
                javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)
        ));
        userPanel.add(Box.createVerticalGlue());
        userHpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userPanel.add(userHpLabel);
        userPanel.add(Box.createVerticalGlue());
        userPanel.setPreferredSize(new Dimension(200, 80));

        // Monster info panel
        JPanel monsterPanel = new JPanel();
        monsterPanel.setLayout(new BoxLayout(monsterPanel, BoxLayout.Y_AXIS));
        monsterPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(178, 34, 34), 2),
                "Monster",
                javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)
        ));
        monsterPanel.add(Box.createVerticalGlue());
        monsterNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        monsterHpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        monsterPanel.add(monsterNameLabel);
        monsterPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        monsterPanel.add(monsterHpLabel);
        monsterPanel.add(Box.createVerticalGlue());
        monsterPanel.setPreferredSize(new Dimension(200, 80));

        statsPanel.add(userPanel);
        statsPanel.add(monsterPanel);

        // Battle message panel
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                "Battle Log",
                javax.swing.border.TitledBorder.LEFT,
                javax.swing.border.TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14)
        ));
        JScrollPane scrollPane = new JScrollPane(battleMessageArea);
        scrollPane.setPreferredSize(new Dimension(500, 250));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messagePanel.add(scrollPane, BorderLayout.CENTER);

        centerPanel.add(statsPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        centerPanel.add(messagePanel);

        add(centerPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(attackButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Sets the controller for this view.
     */
    public void setBattleController(BattleController controller) {
        this.battleController = controller;
    }

    /**
     * Returns the view name.
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attackButton) {
            handleAttackButton();
        }
    }

    /**
     * Handles the attack button click.
     */
    private void handleAttackButton() {
        BattleState state = viewModel.getState();

        if (state.isBattleEnded()) {
            JOptionPane.showMessageDialog(this,
                    "Battle has already ended!",
                    "Battle Over",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (battleController != null && state.getUser() != null && state.getMonster() != null) {
            attackButton.setEnabled(false);
            User user = state.getUser();
            Monster monster = state.getMonster();
            battleController.switchToQuizView(user, monster);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Battle is not properly initialized!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            BattleState state = viewModel.getState();
            if (state.isJustFinishedQuiz()) {
                state.setJustFinishedQuiz(false);

                User user = state.getUser();
                Monster monster = state.getMonster();
                boolean quizResult = state.isQuizResult();

                if (battleController != null) {
                    battleController.execute(user, monster, quizResult);
                }
            }
            updateDisplay(state);
        }
    }

    /**
     * Updates all display elements based on the current state.
     */
    private void updateDisplay(BattleState state) {
        if (state.isNewBattleStarted()) {
            battleMessageArea.setText("Battle is ready to begin...");
            state.setNewBattleStarted(false);
        }

        // Update user info
        if (state.getUser() != null) {
            userHpLabel.setText(String.format("HP: %.1f", state.getUserHp()));
        }

        // Update monster info
        if (state.getMonster() != null) {
            monsterNameLabel.setText("Monster: " + state.getMonsterName());
            monsterHpLabel.setText(String.format("HP: %.1f", state.getMonsterHP()));
        }

        // Update battle message
        String message = state.getBattleMessage();
        if (message != null && !message.isEmpty()) {
            battleMessageArea.append("\n" + message);
            battleMessageArea.setCaretPosition(battleMessageArea.getDocument().getLength());

            state.setBattleMessage("");
        }

        // Handle battle end
        if (state.isBattleEnded()) {
            state.setBattleEnded(false);
            attackButton.setEnabled(false);
            // Show result dialog
            String title = state.isUserWon() ? "Victory!" : "Defeat!";
            int messageType = state.isUserWon() ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE;

            JOptionPane.showMessageDialog(this,
                    state.getBattleMessage(),
                    title,
                    messageType);
        } else {
            // Battle continues - re-enable buttons
            attackButton.setEnabled(true);
        }
    }
}


