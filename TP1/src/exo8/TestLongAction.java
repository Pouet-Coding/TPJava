package exo8;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class TestLongAction extends JFrame {
	private static final long serialVersionUID = 1L;
	final JButton btnAction;
	final JProgressBar progressBar;
	final SwingWorker<Void, Void> sw;
	
	public TestLongAction() {
		// Construction de la fenetre de test
		btnAction = new JButton("Start");
		progressBar = new JProgressBar(0, 100);
		
		
		sw = new SwingWorker<Void, Void>() { 
			@Override
			protected Void doInBackground() throws Exception {
				new LongAction().traitementLong();
				return null;
			}
		};
		
		// Ajout du listener du bouton
		btnAction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TestLongAction.this.sw.execute();
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						TestLongAction.this.btnAction.setText("aaaaaa");
						TestLongAction.this.validate();
					}
				});
			}
		});
		
		final Container contentPane = getContentPane();
		
		contentPane.setLayout(new GridLayout(2, 1));
		contentPane.add(btnAction);
		contentPane.add(progressBar);
		setTitle("Test de LongAction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestLongAction();
	}
}
