package br.ufjf.dcc171;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Janela extends JFrame {

    private final JLabel etiqueta1 = new JLabel("Informe o valor da mercadoria");
    private final JLabel etiqueta2 = new JLabel("Informe a cotação BRL/USD");
    private final JLabel resultado = new JLabel("");
    private final JTextField txt = new JTextField(15);
    private final JTextField txt2 = new JTextField(15);
    private final JCheckBox chk1 = new JCheckBox("ICMS");
    private final JCheckBox chk2 = new JCheckBox("Tributado");
    private final JButton btn = new JButton("Calcular");

    private double valFinal;

    public Janela() throws HeadlessException {
        super("Preço Final");
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(etiqueta1);
        add(txt);
        add(etiqueta2);
        add(txt2);
        add(chk1);
        add(chk2);
        add(btn);
        

        btn.addActionListener(new Calcula());
        resultado.setText("Valor: " + valFinal);
        add(resultado);

    }

    private class Calcula implements ActionListener, ItemListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            valFinal += Double.parseDouble(txt.getText());
            valFinal = valFinal * Double.parseDouble(txt2.getText());
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(chk1.isSelected() && chk2.isSelected())
            {
                valFinal += valFinal * 1.60;
                valFinal += valFinal * 1.18;
            }
            else if(chk1.isSelected())
            {
                valFinal += valFinal * 1.18;
            }
            else if(chk2.isSelected())
            {
                valFinal += valFinal * 1.60;
            }
        }

        
    }

    

   

}
