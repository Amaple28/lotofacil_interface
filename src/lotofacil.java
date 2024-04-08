
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
    //componentes da tela inicial
    private JLabel jLabelMensagemTitle = new JLabel("✺✺✺ LOTOFÁCIL ✺✺✺");
    private JLabel jLabelMensagem = new JLabel("Escolha a opção desejada: ");
    private JButton jButtonApostar = new JButton("⚔ APOSTAR ⚔");

    private JRadioButton jRadioButtonOpcao1 = new JRadioButton("Aposta de 0 a 100");
    private JRadioButton jRadioButtonOpcao2 = new JRadioButton("Aposta de A à Z");
    private JRadioButton jRadioButtonOpcao3 = new JRadioButton("Apostar PAR ou ÍMPAR"); 
    private ButtonGroup buttonGroup = new ButtonGroup();

    //componentes gerais de aposta
    private JLabel jLabelT = new JLabel();
    private JLabel jLabelD = new JLabel();
    private JTextField jTextFieldAposta = new JTextField(10);
    private JButton jButtonAposta = new JButton("√ Realizar Aposta");
    private JLabel jLabelResultado = new JLabel();
    private JButton jButtonVoltar = new JButton("⮰ Voltar");


    //construtor
    public lotofacil(){
        this.setTitle("Lotofácil");
        this.setSize(400,350);
        configurarComponentes();
        this.setLocationRelativeTo(null); // Centralizar janela
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
        revalidate(); 
        repaint(); 
    }
    
    private void limpaComponentes() {
        painel.removeAll();
    }

    private void apostar() {
        if(jRadioButtonOpcao1.isSelected()){   
            limpaComponentes(); 
            jLabelT.setText("✺✺ APOSTA DE 0 A 100 ✺✺");
            jLabelD.setText("Digite um número de 0 a 100:");
            realizarAposta();  
        } else if(jRadioButtonOpcao2.isSelected()){  
            limpaComponentes(); 
            jLabelT.setText("✺✺ APOSTA DE A A Z ✺✺");
            jLabelD.setText("Digite uma letra de A a Z:");
            realizarAposta(); 
        } else if(jRadioButtonOpcao3.isSelected()){ 
            limpaComponentes(); 
            jLabelT.setText("✺✺ APOSTA PAR OU IMPAR ✺✺");
            jLabelD.setText("Digite um número:");
            realizarAposta(); 
        } else { 
            JOptionPane.showMessageDialog(null, "Selecione uma opção para apostar");
        }
    }

    private void realizarAposta() { 
        painel.add(jLabelT);
        painel.add(jLabelD);
        painel.add(jTextFieldAposta);
        painel.add(jButtonAposta);

        // Remover action listeners antigos antes de adicionar um novo
        for (ActionListener al : jButtonAposta.getActionListeners()) {
            jButtonAposta.removeActionListener(al);
        }

        jButtonAposta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jRadioButtonOpcao1.isSelected()){   
                    aposta0a100(); 
                } else if(jRadioButtonOpcao2.isSelected()){  
                    apostaAaZ(); 
                } else if(jRadioButtonOpcao3.isSelected()){ 
                    apostaParImpar(); 
                }
            } 
        });

        jButtonVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //limpar value do textfield
                jTextFieldAposta.setText(""); 
                limpaComponentes();
                configurarComponentes();
            } 
        });

        this.getContentPane().add(painel);
        revalidate(); 
        repaint(); 
    }

    private void aposta0a100() { 
        String textoAposta = jTextFieldAposta.getText();
        try {
            int numeroAposta = Integer.parseInt(textoAposta);
            if(numeroAposta >= 0 && numeroAposta <= 100){

                int numeroSorteado = (int) (Math.random() * 100);

                if(numeroAposta == numeroSorteado){
                    jLabelResultado.setText("Parabéns, você ganhou R$ 1.000,00 reais! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ");
                } else {
                    jLabelResultado.setText("Que pena! O número sorteado foi: " + numeroSorteado + " (｡•́︿•̀｡) ");
                }

                painel.add(jLabelResultado);
                painel.add(jButtonVoltar);
                this.getContentPane().add(painel);
                revalidate(); 
                repaint(); 
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Aposta inválida! Digite um número entre 0 e 100.");
        }
    }

    private void apostaAaZ(){
        String letraAposta = jTextFieldAposta.getText();
        if(letraAposta.length() == 1 && Character.isLetter(letraAposta.charAt(0))){
            letraAposta = letraAposta.toUpperCase();
            char letraSorteada = 'M';

            if(letraAposta.charAt(0) == letraSorteada){
                jLabelResultado.setText("Parabéns, você ganhou R$ 500,00 reais! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ");
            } else {
                jLabelResultado.setText("Que pena! A letra sorteada foi: " + letraSorteada + " (｡•́︿•̀｡) ");
            }

            painel.add(jLabelResultado);
            painel.add(jButtonVoltar);
            this.getContentPane().add(painel);
            revalidate(); 
            repaint(); 

        } else {
            JOptionPane.showMessageDialog(null, "Aposta inválida! Digite uma letra de A a Z.");
        }
    }

    private void apostaParImpar() {
        String textoAposta = jTextFieldAposta.getText();
        try {
            int numeroAposta = Integer.parseInt(textoAposta); 
            // Verifica se o número é par ou ímpar
            if (numeroAposta % 2 == 0) {
                jLabelResultado.setText("Parabéns, Você ganhou R$ 100,00 reais! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ");
            } else {
                jLabelResultado.setText("O número digitado é ímpar e a premiação foi para números pares. (｡•́︿•̀｡) ");
            }
    
            painel.add(jLabelResultado); 
            painel.add(jButtonVoltar);
            this.getContentPane().add(painel);
            revalidate();
            repaint();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Aposta inválida! Digite um número.");
        }
    }
    
}
