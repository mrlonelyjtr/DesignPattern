import language.InterpreterFacade;
import turtle.TurtleCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame implements ActionListener {
    private TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(canvas);
    private TextField programTextField = new TextField("program repeat 3 go right go left end end");

    public Main(String title) {
        super(title);
        setLayout(new BorderLayout());
        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        canvas.setExecutor(facade);

        programTextField.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pack();
        parseAndExecute();
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == programTextField)
            parseAndExecute();
    }

    private void parseAndExecute() {
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        facade.parse(programText);
        canvas.repaint();
    }

    public static void main(String[] args) {
        new Main("Interpreter Pattern Sample");
    }
}