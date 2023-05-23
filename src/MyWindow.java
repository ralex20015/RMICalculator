import ui.MyCustomButton;
import ui.RoundedButtonUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyWindow extends JFrame implements ActionListener {

    private final JButton bSuma;
    private final JButton bResta;
    private final JButton bMultiplicacion;
    private final JButton bDivision;
    private final JButton bCuadrado;
    private final JButton bModulo;
    private final JButton bLimpiar;
    private final JLabel lError;
    private final JLabel lSimbolo;
    public JLabel lResultado = new JLabel("Resultado: SR");
    private final JTextField num1Txt;
    private final Operations objOperaciones;
    String nameOfTheWindow;
    private double result;
    private Color operationsColor;
    private Color calculatorBackground;
    private Color numbersColor;
    private Color backgroundNumbersButtons;
    private JPanel panelNumbers, panelOperations, panelMessages, panelBackground;
    private MyCustomButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9;
    private Font numberFont = new Font("Arial",Font.PLAIN,22);

    MyWindow(Operations objOperaciones, String nameOfTheWindow) throws RemoteException {
        operationsColor = new Color(0, 93, 178);
        calculatorBackground = new Color(19, 29, 37);
        numbersColor = new Color(41, 157, 238);
        backgroundNumbersButtons = new Color(34, 49, 63);
        this.objOperaciones = objOperaciones;
        this.nameOfTheWindow = nameOfTheWindow;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        btn1 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"1");
        btn2 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"2");
        btn3 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"3");
        btn4 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"4");
        btn5 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"5");
        btn6 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"6");
        btn7 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"7");
        btn8 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"8");
        btn9 = new MyCustomButton(backgroundNumbersButtons,numbersColor,"9");

        panelBackground = new JPanel();
        panelNumbers = new JPanel();
        panelMessages = new JPanel();
        panelOperations = new JPanel();

        panelBackground.setLayout(null);
        panelBackground.setBackground(calculatorBackground);
        panelBackground.setBounds(0,0,350,500);

        panelNumbers.setLayout(new GridLayout(3,3,10,10));
        panelNumbers.setBounds(20,200,200,200);
        panelNumbers.setBackground(calculatorBackground);

        lError = new JLabel("");
        lError.setBounds(20, 150, 600, 32);
        lError.setForeground(Color.red);
        JLabel lNum1 = new JLabel("Número:");
        lNum1.setBounds(20, 50, 100, 32);
        num1Txt = new JTextField("");
        num1Txt.setBounds(20, 80, 225, 50);
        lResultado.setBounds(20, 130, 500, 32);
        lSimbolo = new JLabel("Operacion ");
        lSimbolo.setBounds(265, 86, 32, 32);
        JLabel lOperaciones = new JLabel("Operaciones");
        lOperaciones.setBounds(300, 170, 500, 32);
        bSuma = new JButton("+");
        bSuma.setBounds(300, 200, 50, 50);
        bSuma.addActionListener(this);
        JButton btnResult = new JButton("Enviar numero");
        btnResult.setBounds(300, 80, 225, 50);
        bResta = new JButton("-");
        bResta.setBounds(300, 270, 50, 50);
        bResta.addActionListener(this);
        bMultiplicacion = new JButton("x");
        bMultiplicacion.setBounds(440, 200, 50, 50);
        bMultiplicacion.addActionListener(this);
        bDivision = new JButton("/");
        bDivision.setBounds(440, 270, 50, 50);
        bDivision.addActionListener(this);
        bModulo = new JButton("%");
        bModulo.setBounds(370, 200, 50, 50);
        bModulo.addActionListener(this);
        bCuadrado = new JButton("x²");
        bCuadrado.setBounds(370, 270, 50, 50);
        bCuadrado.addActionListener(this);
        bLimpiar = new JButton("Limpiar");
        bLimpiar.setBounds(35, 200, 150, 50);
        bLimpiar.addActionListener(this);
        this.setLayout(null);
        this.setTitle("Calculadora "+nameOfTheWindow);
        this.setSize(350, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        add(panelBackground);
        panelBackground.add(panelNumbers);
        panelNumbers.add(btn1);
        panelNumbers.add(btn2);
        panelNumbers.add(btn3);
        panelNumbers.add(btn4);
        panelNumbers.add(btn5);
        panelNumbers.add(btn6);
        panelNumbers.add(btn7);
        panelNumbers.add(btn8);
        panelNumbers.add(btn9);
        //Registra la ventana para saber cual es el numero de cual
        btnResult.addActionListener(e -> {
            try {
                result = objOperaciones.getResult(nameOfTheWindow);
                lResultado.setText("Resultado: "+result);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        });
        serviceForGettingTheCurrentNumber();
        objOperaciones.registerWindow(this);
        //serviceForUpdateTheResult();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (sendToTheServer() != -1) {
                String operationToDo;
                if (e.getSource() == bSuma) {
                    this.lSimbolo.setText("+");
                    operationToDo = "s";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == bResta) {
                    this.lSimbolo.setText("-");
                    operationToDo = "r";
                } else if (e.getSource() == bMultiplicacion) {
                    this.lSimbolo.setText("x");
                    operationToDo = "p";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == bDivision) {
                    operationToDo = "d";
                    this.lSimbolo.setText("/");
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == bModulo) {
                    this.lSimbolo.setText("%");
                    operationToDo = "m";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == bCuadrado) {
                    this.lSimbolo.setText("x²");
                    operationToDo = "c";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == bLimpiar) {
                    this.lSimbolo.setText("err");
                    num1Txt.setText("");
                    operationToDo = null;
                    lResultado.setText("Resultado:");
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                    try {
                        this.objOperaciones.borrar(nameOfTheWindow);
                    } catch (RemoteException ex) {
                        Logger.getLogger(MyWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private int sendToTheServer() throws RemoteException {
        double number;
        if (!esNumerico(num1Txt.getText())) {
            lError.setText("Debe de escribir un número en el campo 'Número'. ");
            return -1;
        }
        number = Double.parseDouble(num1Txt.getText());
        lError.setText("");
        objOperaciones.sendNumberToServer(number, nameOfTheWindow);
        return 0;
    }

    private void serviceForGettingTheCurrentNumber(){
        while (true){
            try {
                Thread.sleep(500);
                sendToTheServer();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    /*public void serviceForUpdateTheResult() throws RemoteException{
        for (; ; ) {
            try {
                Thread.sleep(500);
                lResultado.setText("Resultado: " + this.objOperaciones.getResult(nameOfTheWindow));
            } catch (InterruptedException ex) {
                Logger.getLogger(MyWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/

    public static boolean esNumerico(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public String getNameOfTheWindow() {
        return nameOfTheWindow;
    }

    private boolean isEmpty() {
        return num1Txt.getText().equals("");
    }
}
