package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public GUI(){
        homeScreen();
    }
    private void homeScreen(){
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

        public Registration(){
            signup();
        }

        private void signup(){

            //Set up window
            JFrame f = new JFrame("Connexion");
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setBounds(300, 90, 900, 600);

            Container c = f.getContentPane();
            c.setLayout(new FlowLayout());

            JLabel title = new JLabel("Connexion");
            title.setFont(new Font("Arial", Font.PLAIN, 30));
            title.setSize(350, 30);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            c.add(title);

            //PARAMETRES DE CONNEXION

            //Nom
            JLabel surname = new JLabel("Nom :");
            surname.setFont(new Font("Arial", Font.PLAIN, 20));
            surname.setSize(100,20);
            surname.setLocation(100, 100);
            c.add(surname);

            JTextField tsurname = new JTextField();
            tsurname.setFont(new Font("Arial", Font.PLAIN, 15));
            tsurname.setSize(190, 20);
            tsurname.setLocation(200, 100);
            c.add(tsurname);

            //Prénom
            JLabel name = new JLabel("Prénom :");
            name.setFont(new Font("Arial", Font.PLAIN, 20));
            name.setSize(100, 20);
            name.setLocation(100, 150);
            c.add(name);

            JTextField tname = new JTextField();
            tname.setFont(new Font("Arial", Font.PLAIN, 15));
            tname.setSize(190, 20);
            tname.setLocation(200, 150);
            c.add(tname);

            //E-mail
            JLabel email = new JLabel("Adresse mail:");
            email.setFont(new Font("Arial", Font.PLAIN, 20));
            email.setSize(100, 200);
            email.setLocation(100,200);
            c.add(email);

            JTextField temail = new JTextField();
            temail.setFont(new Font("Arial", Font.PLAIN, 15));
            temail.setSize(190, 20);
            temail.setLocation(200, 200);
            c.add(temail);

            //Password
            JLabel password = new JLabel("Mot de passe :");
            password.setFont(new Font("Arial", Font.PLAIN, 20));
            password.setSize(100, 20);
            password.setLocation(100, 250);
            c.add(password);

            JPasswordField tpassword = new JPasswordField();
            tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
            tpassword.setSize(190, 20);
            tpassword.setLocation(200, 250);
            c.add(tpassword);

            //Bouton connexion
            JButton button = new JButton("Connexion"); //set label to button

        /*
            //create panel to put form elements
            JPanel p = new JPanel(new GridLayout(3, 1));
            p.add(surname);   //Set surname label to panel
            p.add(tsurname);   //Set surname field to panel
            p.add(name);    //set username label to panel
            p.add(tname);   //set text field to panel
            p.add(email);   //Set email label to panel
            p.add(temail);   //Set email field to panel
            p.add(password);    //set password label to panel
            p.add(tpassword);   //set text field to panel
            p.add(button);           //set button to panel


            //set border to panel
            c.add(p, BorderLayout.CENTER);
            //Display the panel
            p.setVisible(true);
        */
            //Frame config
            f.setVisible(true);
        }
    }
}

