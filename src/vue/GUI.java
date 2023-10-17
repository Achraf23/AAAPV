package vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public GUI(){
        try {UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) { e.printStackTrace(); }

        JFrame f = new JFrame("AAAPV");

        final JTextArea textArea = new JTextArea("Quel type d'utilisateur.trice êtes-vous ?");

        textArea.setBounds(50,50, 300,50);
        //textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        //mayve frame sur mode vulerable par defaut et opt benev ou valideur en bas (??)
        JButton b1 = new JButton("Demandeur d'aide");
        b1.setBounds(100, 100, 150, 50);
        f.add(b1);
        JButton b2 = new JButton("Bénévole");
        b2.setBounds(100, 150, 100, 50);
        f.add(b2);
        JButton b3 = new JButton("Valideur");
        b3.setBounds(100, 200, 100, 50);
        f.add(b3);
        b1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                //this.moveFrame();
             }
        });
        f.setSize(500, 500);
        f.add(textArea);
        f.setLayout(null);
        f.setVisible(true);
        textArea.setVisible(true);
    }
}

