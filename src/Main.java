
/*

Main.java

java version 1.8.0_191

01/02/2018

Saul Contreras Godoy
Michele Benevenuto
Hoja de trabajo 4
Algoritmos y estructura de datos
Main con GUI

Nota: Las clases que heredan AbstactList fueron tomadas de los archivos de clase
y configuradas para realizar los requerimentos necesarios

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

    String[] stacks = {"VECTOR","ARRAYLIST","LIST"};
    int stack_index = 0;
    int list_index = 0;
    private String stack_string =  stacks[stack_index];
    String[] lists = {"SINGLE","DOUBLE","CIRCULAR",null};
    private String list_String = lists[stack_index];
	/*Definimos los botones*/
    private JButton setStack = new JButton("Cambiar Stack");
    private JButton setList = new JButton("Cambiar Lista");
	private JButton empezar = new JButton("Comenzar");;//boton que permitira que se realice la accion
	private JTextArea mensaje;
    private JTextArea stack_state = new JTextArea();//nos dice el stack preferido
    private JTextArea list_state = new JTextArea();//nos dice el list preferido
	private Panel panelEntrada, panelCentro;
	private JPanel panelDeLaVentana;
	private JScrollPane scroll;

	public Main(){
		super("Calculadora");/*Sera el nombre de la ventana*/
		empezar.setActionCommand("empezar");
		mensaje = new JTextArea(50,100);
		scroll = new JScrollPane(mensaje);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mensaje.setBounds(10,50,400,300);
		mensaje.setPreferredSize(new Dimension(1000,500));//dimensiones
		empezar.addActionListener(this);
		setStack.addActionListener(this);
		setList.addActionListener(this);
		panelDeLaVentana = (JPanel)this.getContentPane();
		panelEntrada = new Panel();//los siguientes paneles son para poner orden y estetica
		panelCentro = new Panel();
		setStack.setActionCommand("Stack");
		setList.setActionCommand("Lista");
		stack_state.setText(stack_string);
		list_state.setText(list_String);
		panelEntrada.add(stack_state);
		panelEntrada.add(setStack);
		panelEntrada.add(empezar);
		panelEntrada.add(setList);
		panelEntrada.add(list_state);
		panelCentro.add(scroll,BoxLayout.X_AXIS);
		panelDeLaVentana.add(panelEntrada,BorderLayout.NORTH);//agreamos las ventanas a la interfaz grafica
    	panelDeLaVentana.add(panelCentro,BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e){
	    if("Stack".equals((e.getActionCommand()))){
            stack_index++;
            if (stack_index==3){
                stack_index=0;
            }
            stack_string = stacks[stack_index];
            stack_state.setText(stack_string);
        }
	    if("Lista".equals((e.getActionCommand()))){
            list_index++;
            if (list_index==3){
                list_index=0;
            }
            list_String = lists[list_index];
            list_state.setText(list_String);
        }
		if("empezar".equals(e.getActionCommand())){
			MyCalculator calculator = MyCalculator.getInstance();
			StackFactory stackFactory= new StackFactory();
			ListFactory listFactory = new ListFactory();
			AbstractList<String> list = listFactory.getList(list_String);
	        Stack<Integer>stack = stackFactory.getStack(stack_string,list);
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

	        String retorno = "";
	        for(int a=0; a<operation.size();a++){
	        	String anterior = " ";//sera util para guardar la segunda posicion
	        	int contador = 0;//llevara la cuenta de las rondas
		        retorno = retorno + "\n\n\n\tEntrada \tOperacion \t\t\t\t\t\tPila";
		        String operationToDo= operation.get(a);
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
