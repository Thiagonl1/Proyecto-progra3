package Visual;
import javax.swing.*;

public class Pantalla extends JFrame{
    private JPanel panel1;
    private JButton tijeraButton;
    private JButton piedraButton;
    private JButton papelButton;

    public Pantalla(){
        setContentPane(panel1);
        setTitle("sus");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
