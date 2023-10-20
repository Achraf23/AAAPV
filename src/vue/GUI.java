package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public GUI(){
        try {UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) { e.printStackTrace(); }

        //Set up window
        JFrame f = new JFrame("AAAPV");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(600,400));

        Container pane = f.getContentPane();

        //label with text area
        final JLabel text = new JLabel("Quel type d'utilisateur.trice êtes-vous ?");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        pane.add(text, BorderLayout.CENTER);

        //Create the panel and the 3 buttons inside
        JPanel p = new JPanel(new BorderLayout());
        p.setLayout(new FlowLayout());

        //maybe frame sur mode vulerable par defaut et opt benev ou valideur en bas (??)
        JButton vuln = new JButton("Demandeur d'aide");
        //vuln.setBounds(100, 100, 150, 50);
        p.add(vuln);

        JButton benev = new JButton("Bénévole");
        //benev.setBounds(100, 150, 100, 50);
        p.add(benev);

        JButton valid = new JButton("Valideur");
        //valid.setBounds(100, 200, 100, 50);
        p.add(valid);

        pane.add(p, BorderLayout.PAGE_END);

        vuln.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                //this.moveFrame();
             }
        });

        // make window's dimension fit its content
        f.pack();
        f.setVisible(true);
        text.setVisible(true);
        //Display the panel
        p.setVisible(true);
        //Display the buttons
        vuln.setVisible(true);
        benev.setVisible(true);
        valid.setVisible(true);
    }

    public static class Registration{

    }
}

