
import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;  


public class lotofacil extends JFrame {

    public static void main(String[] args) {
        new lotofacil();
    }

    //atributos
    private JPanel painel = new JPanel();
    private JLabel jLabelMensagemTitle = new JLabel("MENU LOTOFÁCIL");
    private JLabel jLabelMensagem = new JLabel("Escolha a opção desejada: ");
    private JButton jButtonApostar = new JButton("Apostar");
    private JRadioButton jRadioButtonOpcao1 = new JRadioButton("Aposta de 0 a 100");
    private JRadioButton jRadioButtonOpcao2 = new JRadioButton("Aposta de A à Z");
    private JRadioButton jRadioButtonOpcao3 = new JRadioButton("Apostar PAR ou ÍMPAR"); 
    private ButtonGroup buttonGroup = new ButtonGroup();

    //construtor
    public lotofacil(){
        this.setTitle("Lotofácil");
        this.setSize(400,400);
        configurarComponentes();
        //this.setLocationRelativeTo(null); // Centralizar janela
        this.setVisible(true); // Exibir janela
    }

    private void configurarComponentes() {

        jButtonApostar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                apostar();
            } 
        });

        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        painel.add(jLabelMensagemTitle);
        painel.add(jLabelMensagem);

        buttonGroup.add(jRadioButtonOpcao1);
        buttonGroup.add(jRadioButtonOpcao2);
        buttonGroup.add(jRadioButtonOpcao3); 

        painel.add(jRadioButtonOpcao1);
        painel.add(jRadioButtonOpcao2);
        painel.add(jRadioButtonOpcao3);

        painel.add(jButtonApostar);
        this.getContentPane().add(painel);
    }

    private void apostar() {
        if(jRadioButtonOpcao1.isSelected()){  
            limpaComponentes(); 
            apostarOpcao1();  
        } else if(jRadioButtonOpcao2.isSelected()){  
            limpaComponentes(); 
            apostarOpcao2();  
        } else if(jRadioButtonOpcao3.isSelected()){ 
            limpaComponentes(); 
            apostarOpcao3();
        } else { 
        }
    }

    private void limpaComponentes() {
        painel.removeAll();
    }

    private void apostarOpcao1() {
        //levar pra tela de aposta de 0 a 100 
        JLabel jLabelT = new JLabel("APOSTA DE 0 A 100");
        painel.add(jLabelT);
        this.getContentPane().add(painel);
        revalidate(); 
        repaint(); 
    }

    private void apostarOpcao2() {
        //levar pra tela de aposta de A a Z
        JLabel jLabelT = new JLabel("APOSTA DE A A Z");
        painel.add(jLabelT);
        this.getContentPane().add(painel);
        revalidate(); 
        repaint(); 
    }

    private void apostarOpcao3() {
        //levar pra tela de aposta de PAR ou IMPAR
        JLabel jLabelT = new JLabel("APOSTA PAR OU IMPAR");
        painel.add(jLabelT);
        this.getContentPane().add(painel);
        revalidate(); 
        repaint(); 
    }
}
