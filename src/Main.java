
/*

Main.java

java version 1.8.0_191

01/02/2018

Saul Contreras Godoy
Michele Benevenuto
Hoja de trabajo 2
Algoritmos y estructura de datos
Main con GUI
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;


public class Main extends JFrame implements ActionListener{

	/*Definimos los botones*/
	private JButton empezar = new JButton("Comenzar");;//boton que permitira que se realice la accion
	private JTextArea mensaje;
	private Panel panelEntrada, panelCentro;
	private JPanel panelDeLaVentana;

	public Main(){
		super("Calculadora");/*Sera el nombre de la ventana*/
		empezar.setActionCommand("empezar");
		mensaje = new JTextArea();
		mensaje.setBounds(10,50,400,300);
		mensaje.setPreferredSize(new Dimension(1000,500));//dimensiones
		empezar.addActionListener(this);
		panelDeLaVentana = (JPanel)this.getContentPane();
		panelEntrada = new Panel();//los siguientes paneles son para poner orden y estetica
		panelCentro = new Panel();
		panelEntrada.add(empezar,BoxLayout.X_AXIS);
		panelCentro.add(mensaje,BoxLayout.X_AXIS);
		panelDeLaVentana.add(panelEntrada,BorderLayout.NORTH);//agreamos las ventanas a la interfaz grafica
    	panelDeLaVentana.add(panelCentro,BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e){
		if("empezar".equals(e.getActionCommand())){
			MyCalculator calculator = new MyCalculator();
	        StackVector<Integer> stack = new StackVector<Integer>();
	        ArrayList<String> operation = new ArrayList<String>();
	        int operator = 0;
	        int operand = 0;
	        try {//si no es un operando
	            Stream<String> lines = Files.lines(
	                    Paths.get("datos.txt"),
	                    StandardCharsets.UTF_8
	            );
	            lines.forEach(s ->{
	                    operation.add(s);
	            });
	        }catch (IOException exception){
	            System.out.println("Error");
	        }

	        String anterior = " ";//sera util para guardar la segunda posicion
	        int contador = 0;//llevara la cuenta de las rondas
	        String retorno;


	        /*Aca iria el for*/	
	        retorno = "\n\n\n\tEntrada \tOperacion \t\t\t\t\t\tPila";
	        String operationToDo= (String) operation.get(0);
	        for (int i =0; i<operationToDo.length();i++){
	        	String currentString=operationToDo.substring(i,i+1);
	            try {
	                int currentNumber = Integer.parseInt(currentString);
	                stack.push(currentNumber);
	                contador = contador + 1;
	                retorno=retorno + ("\n\t"+ String.valueOf(contador));
	                if(anterior==" "){//si solo hay un elemento
	                	retorno = retorno + "\tpush Operando\t\t\t\t\t\t" + stack.peek();
	                	anterior = String.valueOf(stack.peek());//lo guardamos en la variable
	                }
	                else{
	                	retorno = retorno + "\tpush Operando\t\t\t\t\t\t" + anterior + "," + stack.peek();
	                	anterior = " ";
	                }
	            }catch(NumberFormatException nfe){
	                if (!currentString.equals(" ")){
	                    if (currentString.equals("+")){
	                        operand=stack.pop();
	                        operator= stack.pop();
	                        stack.push(calculator.calculate(operand,operator,"+"));
	                        retorno = retorno + "\n\t+\tSumar: pop, pop y push del resultado\t\t\t\t"+ stack.peek();
	                    	anterior = String.valueOf(stack.peek());//lo guardamos en la variable
	                    }
	                    else if (currentString.equals("*")){
	                        operand=stack.pop();
	                        operator=stack.pop();
	                        stack.push(calculator.calculate(operand,operator,"*"));
	                        retorno = retorno + "\n\t*\tMultiplicar: pop, pop y push del resultado\t\t\t\t" + stack.peek();
	                    	anterior = String.valueOf(stack.peek());//lo guardamos en la variable
	                    }
	                    else if (currentString.equals("-")){
	                        operator=stack.pop();
	                        operand= stack.pop();
	                        stack.push(calculator.calculate(operand,operator,"-"));
	                        retorno = retorno + "\n\t-\tRestar: pop, pop y push del resultado\t\t\t\t"+stack.peek();
	                    	anterior = String.valueOf(stack.peek());//lo guardamos en la variable
	                    }
	                    else if (currentString.equals("/")){
	                        operator=stack.pop();
	                        operand= stack.pop();
	                        stack.push(calculator.calculate(operand,operator,"/"));
	                        retorno = retorno + "\n\t/\tDividir: pop, pop y push del resultado\t\t\t\t"+stack.peek();
	                    	anterior = String.valueOf(stack.peek());//lo guardamos en la variable
	                    }
	                }
	            }
	        }
	        mensaje.setText(retorno);
		}
	}

    public static void main(String[] arg){
    	
    	/*Imprimimos la ventana en la pantalla*/
    	
    	Main miAplicacion = new Main();
     	miAplicacion.setBounds(10,10,200,200);
    	miAplicacion.pack();
    	miAplicacion.setVisible(true);
    }
}
