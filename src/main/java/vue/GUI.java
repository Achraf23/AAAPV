package vue;

import controller.ControllerUser;
import controller.ControllerValidator;
import controller.ControllerVolunteer;
import controller.ControllerVulnerable;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public GUI(){
        homeScreen();
    }
    private void homeScreen() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set up window
        JFrame f = new JFrame("AAAPV");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(800, 400));

        Container pane = f.getContentPane();

        //Label with text area
        final JLabel text = new JLabel("Quel type d'utilisateur.trice êtes-vous ?");
        text.setFont(new Font("Arial", Font.PLAIN, 30));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        pane.add(text, BorderLayout.CENTER);

        //Create the panel and the 3 buttons inside
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());

        JButton vuln = new JButton("Demandeur d'aide");
        vuln.setFont(new Font("Arial", Font.PLAIN, 20));
        p.add(vuln);
        ControllerUser controllerVulnerable = new ControllerVulnerable(this);
        controllerVulnerable.addListener(vuln);

        JButton benev = new JButton("Bénévole");
        benev.setFont(new Font("Arial", Font.PLAIN, 20));
        p.add(benev);
        ControllerUser controllerVolunteer = new ControllerVolunteer(this);
        controllerVolunteer.addListener(benev);

        JButton valid = new JButton("Valideur.euse");
        valid.setFont(new Font("Arial", Font.PLAIN, 20));
        p.add(valid);
        ControllerUser controllerValidator = new ControllerValidator(this);
        controllerValidator.addListener(valid);

        pane.add(p, BorderLayout.PAGE_END);

        //Make window's dimension fit its content
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

    public void signup(ControllerUser controllerUser){

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set up window
        JFrame f = new JFrame("Connexion");
        f.setResizable(false);
        f.setBounds(300, 90, 600, 450);

        Container c = f.getContentPane();
        c.setLayout(null);

        JLabel title = new JLabel("Connexion");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(350, 30);
        title.setLocation(210, 25);
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
        tsurname.setSize(190, 30);
        tsurname.setLocation(300, 100);
        c.add(tsurname);

        //Prénom
        JLabel name = new JLabel("Prénom :");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 150);
        c.add(name);

        JTextField tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 30);
        tname.setLocation(300, 150);
        c.add(tname);

        //E-mail
        JLabel email = new JLabel("Adresse mail:");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(200, 20);
        email.setLocation(100,200);
        c.add(email);

        JTextField temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(190, 30);
        temail.setLocation(300, 200);
        c.add(temail);

        //Password
        JLabel password = new JLabel("Mot de passe :");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(200, 20);
        password.setLocation(100, 250);
        c.add(password);

        JPasswordField tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(190, 30);
        tpassword.setLocation(300, 250);
        c.add(tpassword);

        //Bouton connexion
        JButton button = new JButton("Connexion"); //set label to button
        button.setFont(new Font("Arial", Font.PLAIN, 15));
        button.setSize(200, 40);
        button.setLocation(200, 325);
        c.add(button);
        controllerUser.addConnexionListener(button, tsurname, tname, temail, tpassword);

        //Frame config
        f.setVisible(true);
        c.setVisible(true);
        button.setVisible(true);
    }

    public void errorPassword(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,"Le mot de passe est incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public void homepage_vulnerable(String first_name){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set up window
        JFrame f = new JFrame("Page d'accueil");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(600, 400));

        Container c = f.getContentPane();
        c.setLayout(new BorderLayout());

        JLabel title = new JLabel("Bonjour "+ first_name+" !");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(title, BorderLayout.CENTER);

        //Create the panel and the buttons inside
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());

        JButton demande = new JButton("Demander de l'aide"); //set label to button
        demande.setFont(new Font("Arial", Font.PLAIN, 20));
        p1.add(demande);

        JButton historique = new JButton("Gérer vos demandes en cours"); //set label to button
        historique.setFont(new Font("Arial", Font.PLAIN, 20));
        p1.add(historique);

        //Make window's dimension fit its content
        f.pack();

        //Set frame and pane to visible
        f.setVisible(true);
        c.setVisible(true);

        //Display the panel
        c.add(p1, BorderLayout.PAGE_END);
        p1.setVisible(true);

        //Display the buttons
        demande.setVisible(true);
        historique.setVisible(true);
    }

    public void homepage_volunteer(String first_name){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set up window
        JFrame f = new JFrame("Page d'accueil");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(600, 400));

        Container c = f.getContentPane();
        c.setLayout(new BorderLayout());

        JLabel title = new JLabel("Bonjour "+ first_name+" !");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(title, BorderLayout.CENTER);

        //Create the panel and the buttons inside
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());

        //TODO : affichage des missions demandés par les vulnérables

        JButton demande = new JButton("Accepter Mission"); //set label to button
        demande.setFont(new Font("Arial", Font.PLAIN, 20));
        p1.add(demande);

        JButton historique = new JButton("Accéder à vos mission en cours"); //set label to button
        historique.setFont(new Font("Arial", Font.PLAIN, 20));
        p1.add(historique);

        //Make window's dimension fit its content
        f.pack();

        //Set frame and pane to visible
        f.setVisible(true);
        c.setVisible(true);

        //Display the panel
        c.add(p1, BorderLayout.PAGE_END);
        p1.setVisible(true);

        //Display the buttons
        demande.setVisible(true);
        historique.setVisible(true);
    }

    public void homepage_validator(String first_name){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Set up window
        JFrame f = new JFrame("Page d'accueil");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(600, 400));

        Container c = f.getContentPane();
        c.setLayout(new BorderLayout());

        JLabel title = new JLabel("Bonjour "+ first_name+" !");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(title, BorderLayout.CENTER);

        //Create the panel and the buttons inside
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());

        //TODO : affichage des missions demandés par les vulnérables

        JButton demande = new JButton("Accepter demande"); //set label to button
        demande.setFont(new Font("Arial", Font.PLAIN, 20));
        p1.add(demande);

        JButton historique = new JButton("Refuser demande"); //set label to button
        historique.setFont(new Font("Arial", Font.PLAIN, 20));
        p1.add(historique);

        //Make window's dimension fit its content
        f.pack();

        //Set frame and pane to visible
        f.setVisible(true);
        c.setVisible(true);

        //Display the panel
        c.add(p1, BorderLayout.PAGE_END);
        p1.setVisible(true);

        //Display the buttons
        demande.setVisible(true);
        historique.setVisible(true);
    }
}


