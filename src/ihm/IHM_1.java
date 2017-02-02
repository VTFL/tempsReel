package ihm;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import main.Simulation;

/**
 * Created by valentinpitel on 02/02/2017.
 */
public class IHM_1 extends JFrame {
    private JButton btn_Valider;
    private JPanel pan_Intervalle1;
    private JPanel pan_Intervalle2;
    private JPanel pan_nbDonnees;
    private JPanel pan_nbDonneesTR;

    private JLabel lbl_nbDonnes;
    private JLabel lbl_nbDonnesTR;
    private JLabel lbl_Intervalle1;
    private JLabel lbl_Intervalle21;
    private JLabel lbl_Intervalle22;

    private JFormattedTextField txt_nbDonnees;
    private JFormattedTextField txt_nbDonneesTR;

    private JFormattedTextField txt_intervalle11;
    private JFormattedTextField txt_intervalle12;

    private JFormattedTextField txt_intervalle21;
    private JFormattedTextField txt_intervalle22;
    public IHM_1(){
        super("Génération BDD temps réel");

        Container cont = getContentPane();
        cont.setLayout(new GridLayout(5,1));

        pan_nbDonneesTR = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_Intervalle1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_nbDonnees = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan_Intervalle2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

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

        btn_Valider = new JButton("Valider");
        btn_Valider.addActionListener(new actionValider1());

        cont.add(pan_nbDonneesTR);
        cont.add(pan_Intervalle1);
        cont.add(pan_nbDonnees);
        cont.add(pan_Intervalle2);
        cont.add(btn_Valider);


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
            Simulation s = new Simulation(Integer.parseInt(txt_nbDonneesTR.getText()),
                    Integer.parseInt(txt_intervalle11.getText()),
                    Integer.parseInt(txt_intervalle12.getText()),
                    Integer.parseInt(txt_nbDonnees.getText()),
                    Integer.parseInt(txt_intervalle21.getText()),
                    Integer.parseInt(txt_intervalle22.getText()));


            System.out.println(s.lancer());
        }
    }
}
