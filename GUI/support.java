package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class support extends JFrame implements ActionListener {
    private JTextArea messageTextArea;
    private JButton sendButton;

    public support() {
        setTitle("Contact Admin");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        messageTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        panel.add(sendButton, BorderLayout.SOUTH);

        add(panel);

        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            String message = messageTextArea.getText();
            
            JOptionPane.showMessageDialog(this, "Message sent to admin:\n" + message);
            messageTextArea.setText(""); // Clear the text area after sending
			this.dispose();
			firstpage a = new firstpage();
			a.setVisible(true);
        }
    }

}