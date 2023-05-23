import ui.MyCustomButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MyWindow extends JFrame implements ActionListener {

    private final MyCustomButton btnAdd;
    private final MyCustomButton btnRest;
    private final MyCustomButton btnMultiplication;
    private final MyCustomButton btnDivition;
    private final JButton btnSquare;
    private final JButton btnRemainder;
    private final MyCustomButton btnCleanFields;
    private final MyCustomButton btnDelete;
    private final JLabel lblError;
    private final JLabel lblSymbol;
    public JLabel lblResult = new JLabel("Resultado: SR");
    private final JTextField txtNumberInput;
    private final Operations objOperaciones;
    String nameOfTheWindow;
    private double result;
    private final MyCustomButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9;
    private final MyCustomButton btn0, btnPunto;

    MyWindow(Operations objOperaciones, String nameOfTheWindow) throws RemoteException {
        Color operationsBackgroundColor = new Color(0, 93, 178);
        Color calculatorBackground = new Color(19, 29, 37);
        Color numbersColor = new Color(41, 157, 238);
        Color backgroundNumbersButtons = new Color(34, 49, 63);
        this.objOperaciones = objOperaciones;
        this.nameOfTheWindow = nameOfTheWindow;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        btn1 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"1");
        btn1.addActionListener(this);
        btn2 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"2");
        btn2.addActionListener(this);
        btn3 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"3");
        btn3.addActionListener(this);
        btn4 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"4");
        btn4.addActionListener(this);
        btn5 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"5");
        btn5.addActionListener(this);
        btn6 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"6");
        btn6.addActionListener(this);
        btn7 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"7");
        btn7.addActionListener(this);
        btn8 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"8");
        btn8.addActionListener(this);
        btn9 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"9");
        btn9.addActionListener(this);
        btn0 = new MyCustomButton(backgroundNumbersButtons, numbersColor,"0");
        btn0.addActionListener(this);
        btn0.setBounds(20,395,130,63);
        btnPunto = new MyCustomButton(backgroundNumbersButtons, numbersColor,".");
        btnPunto.addActionListener(this);
        btnPunto.setBounds(160,395,60,63);
        MyCustomButton btnEquals = new MyCustomButton(new Color(25, 145, 255),
                new Color(178, 218, 255),"=");
        btnEquals.setBounds(230, 370, 60, 90);

        Color operationsTextColor = new Color(51, 157, 255);
        btnAdd = new MyCustomButton(operationsBackgroundColor, operationsTextColor,"+");
        btnAdd.setBounds(230, 260, 60, 90);
        btnAdd.addActionListener(this);

        btnRest = new MyCustomButton(operationsBackgroundColor, operationsTextColor,"-");
        btnRest.setBounds(230, 180, 60, 60);
        btnRest.addActionListener(this);

        btnMultiplication = new MyCustomButton(operationsBackgroundColor, operationsTextColor,"*");
        btnMultiplication.setBounds(230, 110, 60, 60);
        btnMultiplication.addActionListener(this);

        btnDivition = new MyCustomButton(operationsBackgroundColor, operationsTextColor,"/");
        btnDivition.setBounds(160, 110, 60, 60);
        btnDivition.addActionListener(this);

        Color deleteColorBackground = new Color(95, 96, 96);
        Color deleteColorText = new Color(161, 162, 163);
        btnCleanFields = new MyCustomButton(deleteColorBackground, deleteColorText,"Ac");
        btnCleanFields.setBounds(20, 110, 60, 60);
        btnCleanFields.addActionListener(this);

        btnDelete = new MyCustomButton(deleteColorBackground, deleteColorText,"Del");
        btnDelete.setBounds(90,110,60,60);
        btnDelete.addActionListener(this);


        JPanel panelBackground = new JPanel();
        JPanel panelNumbers = new JPanel();

        panelBackground.setLayout(null);
        panelBackground.setBackground(calculatorBackground);
        panelBackground.setBounds(0,0,350,515);

        panelNumbers.setLayout(new GridLayout(3,3,10,10));
        panelNumbers.setBounds(20,180,200,200);
        panelNumbers.setBackground(calculatorBackground);

        lblError = new JLabel("");
        lblError.setBounds(20, 150, 600, 32);
        lblError.setForeground(Color.red);
        JLabel lNum1 = new JLabel("Número:");
        lNum1.setBounds(20, 50, 100, 32);

        txtNumberInput = new JTextField("");
        txtNumberInput.setFont(new Font("Arial",Font.PLAIN,32));
        txtNumberInput.setEditable(false);
        txtNumberInput.setBackground(calculatorBackground);
        txtNumberInput.setBorder(null);
        txtNumberInput.setForeground(Color.WHITE);
        txtNumberInput.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        txtNumberInput.setBounds(20, 20, 275, 50);

        lblResult.setBounds(20, 80, 200, 32);
        Font numberFont = new Font("Arial", Font.PLAIN, 22);
        lblResult.setFont(numberFont);
        lblResult.setForeground(numbersColor);
        lblSymbol = new JLabel("Operacion ");
        lblSymbol.setBounds(230, 80, 32, 32);
        lblSymbol.setFont(numberFont);
        lblSymbol.setForeground(numbersColor);
        JLabel lOperaciones = new JLabel("Operaciones");
        lOperaciones.setBounds(300, 170, 500, 32);

        btnRemainder = new JButton("%");
        btnRemainder.setBounds(370, 200, 50, 50);
        btnRemainder.addActionListener(this);
        btnSquare = new JButton("x²");
        btnSquare.setBounds(370, 270, 50, 50);
        btnSquare.addActionListener(this);
        this.setLayout(null);
        this.setTitle("Calculadora "+nameOfTheWindow);
        this.setSize(325, 515);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        add(panelBackground);

        panelBackground.add(panelNumbers);
        panelBackground.add(btn0);
        panelBackground.add(btnPunto);
        panelBackground.add(btnEquals);
        panelBackground.add(btnAdd);
        panelBackground.add(btnRest);
        panelBackground.add(btnMultiplication);
        panelBackground.add(btnDivition);
        panelBackground.add(btnCleanFields);
        panelBackground.add(btnDelete);
        panelBackground.add(txtNumberInput);
        panelBackground.add(lblResult);
        panelBackground.add(lblSymbol);

        panelNumbers.add(btn1);
        panelNumbers.add(btn2);
        panelNumbers.add(btn3);
        panelNumbers.add(btn4);
        panelNumbers.add(btn5);
        panelNumbers.add(btn6);
        panelNumbers.add(btn7);
        panelNumbers.add(btn8);
        panelNumbers.add(btn9);

        objOperaciones.registerWindow(this);
        //Registra la ventana para saber cual es el numero de cual
        btnEquals.addActionListener(e -> {
            try {
                result = objOperaciones.getResult(nameOfTheWindow);
                lblResult.setText("Resultado: "+result);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        });
        serviceForGettingTheCurrentNumber();
        //serviceForUpdateTheResult();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            addNumberToTheTextField(e);
            if (sendToTheServer() != -1) {
                String operationToDo;
                if (e.getSource() == btnAdd) {
                    this.lblSymbol.setText("+");
                    operationToDo = "s";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == btnRest) {
                    this.lblSymbol.setText("-");
                    operationToDo = "r";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == btnMultiplication) {
                    this.lblSymbol.setText("x");
                    operationToDo = "p";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == btnDivition) {
                    operationToDo = "d";
                    this.lblSymbol.setText("/");
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == btnRemainder) {
                    this.lblSymbol.setText("%");
                    operationToDo = "m";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == btnSquare) {
                    this.lblSymbol.setText("x²");
                    operationToDo = "c";
                    objOperaciones.setOperation(operationToDo,nameOfTheWindow);
                } else if (e.getSource() == btnCleanFields) {
                    this.lblSymbol.setText("err");
                    txtNumberInput.setText("");
                    operationToDo = null;
                    lblResult.setText("Resultado:");
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

    private void addNumberToTheTextField(ActionEvent e){
        if (e.getSource() == btn0){
            txtNumberInput.setText(txtNumberInput.getText() + "0");
        }
        if (e.getSource() == btn1){
            txtNumberInput.setText(txtNumberInput.getText() + "1");
        }
        if (e.getSource() == btn2){
            txtNumberInput.setText(txtNumberInput.getText() + "2");
        }
        if (e.getSource() == btn3){
            txtNumberInput.setText(txtNumberInput.getText() + "3");
        }
        if (e.getSource() ==btn4){
            txtNumberInput.setText(txtNumberInput.getText() + "4");
        }
        if (e.getSource() ==btn5){
            txtNumberInput.setText(txtNumberInput.getText() + "5");
        }
        if (e.getSource() == btn6){
            txtNumberInput.setText(txtNumberInput.getText() + "6");
        }
        if (e.getSource() == btn7){
            txtNumberInput.setText(txtNumberInput.getText()+ "7");
        }
        if (e.getSource() == btn8){
            txtNumberInput.setText(txtNumberInput.getText()+ "8");
        }
        if (e.getSource() == btn9){
            txtNumberInput.setText(txtNumberInput.getText() + "9");
        }
        if (e.getSource() == btnPunto){
            txtNumberInput.setText(txtNumberInput.getText() + ".");
        }
    }


    private int sendToTheServer() throws RemoteException {
        double number;
        if (!esNumerico(txtNumberInput.getText())) {
            lblError.setText("Debe de escribir un número en el campo 'Número'. ");
            return -1;
        }
        number = Double.parseDouble(txtNumberInput.getText());
        lblError.setText("");
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
        return txtNumberInput.getText().equals("");
    }
}
