package gui;

import grabber.autoFetchChapters;

import javax.swing.*;
import java.awt.event.*;

public class getChapterNumber extends JDialog {
    private static getChapterNumber dialog;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField chapterField;
    private JLabel chapterNameLbl;
    private JLabel chapterNumberLbl;

    private getChapterNumber(GUI gui) {
        ImageIcon favicon = new ImageIcon(getClass().getResource("/images/favicon.png"));
        setIconImage(favicon.getImage());
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(gui);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    static void main(GUI gui) {
        dialog = new getChapterNumber(gui);
        dialog.setTitle("Display number of chapter");
        dialog.pack();
        dialog.setVisible(true);
    }

    private void onOK(GUI gui) {
        String[] infos = autoFetchChapters.getChapterNumber(gui, chapterField.getText(), gui.auto);
        chapterNameLbl.setText(infos[0]);
        chapterNumberLbl.setText(infos[1]);
        dialog.pack();
    }

    private void onCancel() {
        dialog.dispose();
    }
}
