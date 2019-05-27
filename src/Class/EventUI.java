package Class;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.util.Vector;
import java.io.*;

public class EventUI extends JFrame implements ActionListener
{
private JPanel buttonPanel, textPanel, fieldPanel, topPanel;
private JButton openButton, saveButton, closeButton;
private JScrollPane scrollPane;
private JTextArea textArea;
private JTextField textField;
private static final String[] ONES =
{
"zero", "one", "two", "three", "four", "five",
"six", "seven", "eight", "nine"
};
private static final String[] TEENS =
{
"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
"sixteen", "seventeen", "eighteen", "nineteen", null
};
private static final String[] TENS =
{
"twenty", "thirty", "forty", "fifty",
"sixty", "seventy", "eighty", "ninety", null
};

public EventUI()
{
setSize(400, 300);
setTitle("Event UI");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//make a button toolbar using buttonPanel as a container
buttonPanel = new JPanel(new GridLayout(1,3)); //1 row 3 cols

openButton = new JButton("One");
openButton.addActionListener(this);//"th... because we implement actionlistener
buttonPanel.add(openButton); //first button added goes on left side

saveButton = new JButton("Two");
saveButton.addActionListener(this);
buttonPanel.add(saveButton); //next button goes in the middle

closeButton = new JButton("Three");
closeButton.addActionListener(this);
buttonPanel.add(closeButton); //last one goes on the right side

//textPanel visually contains the scroll area and text area objects
textPanel = new JPanel(new BorderLayout());

textArea = new JTextArea();
textArea.setLineWrap(true);
textArea.setEditable(true);

scrollPane = new JScrollPane(textArea); //this object lets us scroll the text editor


textPanel.add(scrollPane, BorderLayout.CENTER); //scroll pane goes inside textPanel

textField = new JTextField("Default");
fieldPanel = new JPanel(new GridLayout(1,1));
fieldPanel.add(textField);

//put the button panel and the field panel on a third panel with a grid layout
topPanel = new JPanel(new GridLayout(2,1));
topPanel.add(buttonPanel);
topPanel.add(fieldPanel);

//now mount the two panels on the frame
add(topPanel, BorderLayout.NORTH); //adds to JFrame at top of window
add(textPanel, BorderLayout.CENTER); //adds to JFrame in center of window

setVisible(true); //makes JFrame visible
}

public static String numberToWords(int number)
{
if (number<10)
{
return ONES[number];
}
else if (number<20)
{
int n = number - 10;
String words = TEENS[n];
return words == null ? ONES[n]+"teen" : TEENS[n];
}
else
{
int n = number % 10;
return TENS[number/10] + (n == 0 ? "" : (" " + numberToWords(n)));
}
}
/**
actionPerformed
This is the method required to implement interface ActionListener.
*/
public void actionPerformed(ActionEvent e)
{
if (e.getActionCommand().compareTo("One") == 0)
{
System.out.println("Pushed One");
String contents = textField.getText();
textArea.append("It contains:\n" + contents);
}
else if (e.getActionCommand().compareTo("Two") == 0)
{
System.out.println("Pushed Two");

}
else if (e.getActionCommand().compareTo("Three") == 0)
{
System.out.println("Pushed Three");

}
}



public static void main(String args[])
{
EventUI be = new EventUI();
}
}