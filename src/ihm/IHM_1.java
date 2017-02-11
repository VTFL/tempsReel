package ihm;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import bean.Transaction;
import main.Simulation;

/**
 * Created by valentinpitel on 02/02/2017.
 */
public class IHM_1 extends JFrame {

    private JButton btn_Valider;
    private JButton btn_Test;
    private JButton btn_New;

    private JPanel pan_Intervalle1;
    private JPanel pan_Intervalle2;
    private JPanel pan_nbDonnees;
    private JPanel pan_nbDonneesTR;
    private JPanel pan_LectureDonnees;
    private JPanel pan_EcritureDonnees;
    private JPanel pan_DureeSimu;
    private JPanel pan_Lambda;
    private JPanel pan_Button;

    private JLabel lbl_nbDonnes;
    private JLabel lbl_nbDonnesTR;
    private JLabel lbl_Intervalle1;
    private JLabel lbl_Intervalle21;
    private JLabel lbl_Intervalle22;
    private JLabel lbl_LectureDonnees;
    private JLabel lbl_EcritureDonnees;
    private JLabel lbl_DureeSimu;
    private JLabel lbl_Lambda;

    private JFormattedTextField txt_nbDonnees;
    private JFormattedTextField txt_nbDonneesTR;
    private JFormattedTextField txt_LectureDonnees;
    private JFormattedTextField txt_EcritureDonnees;
    private JFormattedTextField txt_DureeSimu;
    private JFormattedTextField txt_Lambda;

    private JFormattedTextField txt_intervalle11;
    private JFormattedTextField txt_intervalle12;

    private JFormattedTextField txt_intervalle21;
    private JFormattedTextField txt_intervalle22;

    private Simulation s;

    public IHM_1(){
        super("Génération BDD temps réel");

        initFrame();
    }

    private void initFrame() {
        Container cont = getContentPane();
        cont.setLayout(new GridLayout(9,1));

        pan_nbDonneesTR = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_Intervalle1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_nbDonnees = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_Intervalle2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_LectureDonnees = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_EcritureDonnees = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_DureeSimu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_Lambda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_Button = new JPanel();


        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        // formatter.setCommitsOnValidEdit(true);


        lbl_nbDonnesTR = new JLabel("Nombre de données TR à générer\t:");
        txt_nbDonneesTR = new JFormattedTextField(formatter);
        txt_nbDonneesTR.setColumns(9);

        pan_nbDonneesTR.add(lbl_nbDonnesTR);
        pan_nbDonneesTR.add(txt_nbDonneesTR);

        lbl_Intervalle1 = new JLabel("Intervalle de durée de validité\t\t:");
        txt_intervalle11 = new JFormattedTextField(formatter);
        txt_intervalle11.setColumns(5);
        txt_intervalle12 = new JFormattedTextField(formatter);
        txt_intervalle12.setColumns(5);

        pan_Intervalle1.add(lbl_Intervalle1);
        pan_Intervalle1.add(txt_intervalle11);
        pan_Intervalle1.add(txt_intervalle12);

        lbl_nbDonnes = new JLabel("Nombre de données classiques à générer\t:");
        txt_nbDonnees = new JFormattedTextField(formatter);
        txt_nbDonnees.setColumns(5);

        pan_nbDonnees.add(lbl_nbDonnes);
        pan_nbDonnees.add(txt_nbDonnees);

        lbl_Intervalle21 = new JLabel("tpsUpdateMin:");
        txt_intervalle21 = new JFormattedTextField(formatter);
        txt_intervalle21.setColumns(5);
        lbl_Intervalle22 = new JLabel("tpsUpdateMax:");
        txt_intervalle22 = new JFormattedTextField(formatter);
        txt_intervalle22.setColumns(5);

        pan_Intervalle2.add(lbl_Intervalle21);
        pan_Intervalle2.add(txt_intervalle21);
        pan_Intervalle2.add(lbl_Intervalle22);
        pan_Intervalle2.add(txt_intervalle22);

        lbl_LectureDonnees = new JLabel("Durée lecture d'une donnée classique\t:");
        txt_LectureDonnees= new JFormattedTextField(formatter);
        txt_LectureDonnees.setColumns(5);

        pan_LectureDonnees.add(lbl_LectureDonnees);
        pan_LectureDonnees.add(txt_LectureDonnees);

        lbl_EcritureDonnees = new JLabel("Durée écriture d'une donnée classique\t:");
        txt_EcritureDonnees= new JFormattedTextField(formatter);
        txt_EcritureDonnees.setColumns(5);

        pan_EcritureDonnees.add(lbl_EcritureDonnees);
        pan_EcritureDonnees.add(txt_EcritureDonnees);

        lbl_Lambda = new JLabel("Lambda Loi de Poisson\t:");
        txt_Lambda= new JFormattedTextField(formatter);
        txt_Lambda.setColumns(5);

        pan_Lambda.add(lbl_Lambda);
        pan_Lambda.add(txt_Lambda);

        lbl_DureeSimu = new JLabel("Durée de la simulation\t:");
        txt_DureeSimu= new JFormattedTextField(formatter);
        txt_DureeSimu.setColumns(5);

        pan_DureeSimu.add(lbl_DureeSimu);
        pan_DureeSimu.add(txt_DureeSimu);

        btn_Valider = new JButton("Valider");
        btn_Valider.addActionListener(new actionValider1());

        btn_Test = new JButton("Test");
        btn_Test.addActionListener(new actionTest());

        pan_Button.add(btn_Valider);
        pan_Button.add(btn_Test);

        cont.add(pan_nbDonneesTR);
        cont.add(pan_Intervalle1);
        cont.add(pan_nbDonnees);
        cont.add(pan_Intervalle2);
        cont.add(pan_LectureDonnees);
        cont.add(pan_EcritureDonnees);
        cont.add(pan_Lambda);
        cont.add(pan_DureeSimu);
        cont.add(pan_Button);


        // this.setPreferredSize(new Dimension(500,500));
        pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public static void main(String[] arg){
        new IHM_1();
    }

    class actionValider1 implements ActionListener{
        public void actionPerformed(ActionEvent e){

            int nbDonneesTR;
            int intervalle11;
            int intervalle12;
            int nbDonnees;
            int intervalle21;
            int intervalle22;
            int lectureDonnees;
            int ecritureDonnees;
            double lambda;
            int dureeSimu;

            try
            {
                nbDonneesTR = Integer.parseInt(txt_nbDonneesTR.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Rentrez un nombre de données Temps Réels à générer" );
                return;
            }

            try
            {
                intervalle11 = Integer.parseInt(txt_intervalle11.getText());
                intervalle12 = Integer.parseInt(txt_intervalle12.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Rentrez un nombre pour l'intervalle de durée de validité" );
                return;
            }

            try
            {
                nbDonnees = Integer.parseInt(txt_nbDonnees.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Rentrez un nombre de données classique à générer" );
                return;
            }

            try
            {
                intervalle21 = Integer.parseInt(txt_intervalle21.getText());
                intervalle22 = Integer.parseInt(txt_intervalle22.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Rentrez un nombre pour les temps de mises à jours" );
                return;
            }

            try
            {
                lectureDonnees = Integer.parseInt(txt_LectureDonnees.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Rentrez un nombre pour la lecture d'une donnée classique" );
                return;
            }

            try
            {
                ecritureDonnees = Integer.parseInt(txt_EcritureDonnees.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Rentrez un nombre l'écriture d'une donnée classique" );
                return;
            }

            try
            {
                lambda = Double.parseDouble(txt_Lambda.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Rentrez un nombre pour le lambda de la loi de poisson" );
                return;
            }

            try
            {
                dureeSimu = Integer.parseInt(txt_DureeSimu.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Rentrez un nombre correspondant à la durée de la situmation");
                return;
            }


            s = new Simulation(nbDonneesTR,
                    intervalle11,
                    intervalle12,
                    nbDonnees,
                    intervalle21,
                    intervalle22,
                    lectureDonnees,
                    ecritureDonnees,
                    lambda,
                    dureeSimu);

            String res = s.lancer();

            afficherTransaction(res);
        }
    }

    class actionTest implements ActionListener{
        public void actionPerformed(ActionEvent e){
            s = new Simulation(10,5,20,15,1,3,1,1,5.0,300);

            String res = s.lancer();

            afficherTransaction(res);
        }
    }

    private void afficherTransaction(String res) {

        Container cont = getContentPane();
        cont.removeAll();
        cont.repaint();
        cont.setLayout(new BorderLayout());

        ArrayList<Transaction> transactions = s.getTransactionsTot();

        JLabel lab_Res = new JLabel(res);
        lab_Res.setHorizontalAlignment(SwingConstants.CENTER);

        JEditorPane pan_Text = new JEditorPane();
        pan_Text.setEditable(false);

        for(Transaction t:transactions) {
            pan_Text.setText(pan_Text.getText()+"\n"+t.toString());
        }

        JScrollPane pan_Scroll = new JScrollPane(pan_Text);

        btn_New = new JButton("Nouvelle Génération");
        btn_New.addActionListener(new actionNew());

        cont.add(lab_Res,BorderLayout.NORTH);
        cont.add(pan_Scroll,BorderLayout.CENTER);
        cont.add(btn_New,BorderLayout.SOUTH);

        pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    class actionNew implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Container cont = getContentPane();
            cont.removeAll();
            cont.repaint();
            initFrame();
        }
    }
}
