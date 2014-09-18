import javax.swing.JOptionPane;

public class JOptionPaneDemo
{
    public static void main(String args[])
    {
        String input = JOptionPane.showInputDialog("Enter your name:");
        JOptionPane.showMessageDialog(null, "Good morning, " + input);
    }
}
