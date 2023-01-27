import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author tiris0808
 */
public class ElectronicLock  implements Runnable, ActionListener{

  // Class Variables  
    JPanel mainPanel;
    
    JTextField inputNums;
    JTextField passcode;
    
    JLabel openClosed;
    JLabel enterPinText;
    JLabel status;
    JLabel access;
    
    JButton enterButton;
    JButton clearButton;

    JButton num1Button;
    JButton num2Button;
    JButton num3Button;
    JButton num4Button;
    JButton num5Button;
    JButton num6Button;
    JButton num7Button;
    JButton num8Button;
    JButton num9Button;
    JButton num0Button;
    
    String display = "";
    String password = "";
    
    //custom colours
    Color rred = new Color(212, 36, 17);
    Color ggreen = new Color(15, 219, 22);
    Color purp = new Color(63, 71, 176);
    Color bblue = new Color(242, 241, 228);

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Lock");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(550,300);
    // shows the window
    frame.setVisible(true);
 
    //create the panel to put things on
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    
    //create the spot to type password
    inputNums = new JTextField();
    //set pos
    inputNums.setBounds(1, 1, 380, 55);
    
    //create the spot to type password
    passcode = new JTextField();
    //set pos
    passcode.setBounds(1000, 1, 380, 55);
    
    //create buttons ROW 1
    clearButton = new JButton("CLEAR");
    clearButton.setBounds(1, 210, 126, 50);
    //make button listen
    clearButton.addActionListener(this);
    clearButton.setActionCommand("clear");
    
    num0Button = new JButton("0");
    num0Button.setBounds(128, 210, 126, 50);
    //make button listen
    num0Button.addActionListener(this);
    num0Button.setActionCommand("num0");
    
    enterButton = new JButton("Enter");
    enterButton.setBounds(255, 210, 126, 50);
    //make button listen
    enterButton.addActionListener(this);
    enterButton.setActionCommand("enter");
    
    
    //create buttons ROW 2
    num7Button = new JButton("7");
    num7Button.setBounds(1, 159, 126, 50);
    //make button listen
    num7Button.addActionListener(this);
    num7Button.setActionCommand("num7");
    
    num8Button = new JButton("8");
    num8Button.setBounds(128, 159, 126, 50);
    //make button listen
    num8Button.addActionListener(this);
    num8Button.setActionCommand("num8");
    
    num9Button = new JButton("9");
    num9Button.setBounds(255, 159, 126, 50);
    //make button listen
    num9Button.addActionListener(this);
    num9Button.setActionCommand("num9");
    
    //create buttons ROW 3
    num4Button = new JButton("4");
    num4Button.setBounds(1, 108, 126, 50);
    //make button listen
    num4Button.addActionListener(this);
    num4Button.setActionCommand("num4");
    
    num5Button = new JButton("5");
    num5Button.setBounds(128, 108, 126, 50);
    //make button listen
    num5Button.addActionListener(this);
    num5Button.setActionCommand("num5");
    
    num6Button = new JButton("6");
    num6Button.setBounds(255, 108, 126, 50);
    //make button listen
    num6Button.addActionListener(this);
    num6Button.setActionCommand("num6");
    
    //create buttons ROW 3
    num3Button = new JButton("3");
    num3Button.setBounds(255, 57, 126, 50);
    //make button listen
    num3Button.addActionListener(this);
    num3Button.setActionCommand("num3");
    
    num2Button = new JButton("2");
    num2Button.setBounds(128, 57, 126, 50);
    //make button listen
    num2Button.addActionListener(this);
    num2Button.setActionCommand("num2");
    
    num1Button = new JButton("1");
    num1Button.setBounds(1, 57, 126, 50);
    //make button listen
    num1Button.addActionListener(this);
    num1Button.setActionCommand("num1");
    
    //labels
    status = new JLabel("STATUS: ");
    status.setBounds(400, 60, 450, 50);
    
    openClosed = new JLabel("CLOSED");
    openClosed.setBounds(453, 60, 450, 50);
    openClosed.setForeground(rred);
    
    access = new JLabel("");
    access.setBounds(400, 105, 450, 50);
    access.setForeground(purp);
      
    enterPinText = new JLabel("Enter a 4-digit pin:");
    enterPinText.setBounds(400, 15, 450, 50);
    
    //add components to main panel
    mainPanel.add(inputNums);
    
    mainPanel.add(clearButton);
    mainPanel.add(enterButton);
    mainPanel.add(num0Button); 
    
    mainPanel.add(num7Button);
    mainPanel.add(num8Button);
    mainPanel.add(num9Button);
    
    mainPanel.add(num4Button);
    mainPanel.add(num5Button);
    mainPanel.add(num6Button);
    
    mainPanel.add(num1Button);
    mainPanel.add(num2Button);
    mainPanel.add(num3Button);
    
    mainPanel.add(openClosed);
    mainPanel.add(enterPinText);
    mainPanel.add(status);
    mainPanel.add(access);
    
    //button colour set to custom colour
    num1Button.setBackground(bblue);
    num2Button.setBackground(bblue);
    num3Button.setBackground(bblue);
    num4Button.setBackground(bblue);
    num5Button.setBackground(bblue);
    num6Button.setBackground(bblue);
    num7Button.setBackground(bblue);
    num8Button.setBackground(bblue);
    num9Button.setBackground(bblue);
    num0Button.setBackground(bblue);
    clearButton.setBackground(bblue);
    enterButton.setBackground(bblue);
    //put panel in frame
    frame.add(mainPanel);
    
    
    
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    if(command.equals("clear")){
        inputNums.setText("");
        display = "";
        password = "";
        openClosed.setText("CLOSED");
        openClosed.setForeground(rred);
        
        access.setText("");
    }
  
    //button inputs for all numbers
    if(command.equals("num1")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "1");
       
    }
    
    if(command.equals("num2")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "2");
    }
    
    if(command.equals("num3")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "3");
    }
    
    if(command.equals("num4")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "4");
    }
    
    if(command.equals("num5")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "5");
    }
    
    if(command.equals("num6")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "6");
    }
    
    if(command.equals("num7")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "7");
    }
    
    if(command.equals("num8")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "8");
    }
    
    if(command.equals("num9")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "9");
    }
    
    if(command.equals("num0")){
        inputNums.setText(display = display + "*");
        passcode.setText(password = password + "0");
    }
    
    //enter button command to check if entered password is correct
    if(command.equals("enter")){
        //get text from hidden password textfield and convert to integer
        String inputBox = passcode.getText();
        int guess = Integer.parseInt(inputBox);
        
        //correct numbur and access granted/ denied
        if(guess == 1234){
            openClosed.setText("OPEN");
            openClosed.setForeground(ggreen);
            
            access.setText("ACCESS GRANTED");
        }
        else{
            openClosed.setText("CLOSED");
            openClosed.setForeground(rred);
            
            access.setText("ACCESS DENIED");
            
        }
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    ElectronicLock  gui = new ElectronicLock ();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

