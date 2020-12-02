package net.devtech.AOC2020;


import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Optional;
import java.util.Vector;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;
import net.devtech.AOC2020.util.Problems;

@SuppressWarnings ("SuspiciousMethodCalls")
public class Main extends JPanel {
	private static final Vector<String> PARTS = new Vector<>(Arrays.asList("Part 1", "Part 2"));
	private static final Vector<String> DAYS = new Vector<>();

	private static final JFrame FRAME = new JFrame("Elapsed Time: <none>");

	public static void main(String[] args) {}
	static {
		for (int i = 1; i <= 25; i++) {
			DAYS.add("Day " + i);
		}

		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.getContentPane().add(new Main());
		FRAME.pack();
		FRAME.setVisible(true);
	}

	private final JComboBox<String> day = new JComboBox<>(DAYS);
	private final JComboBox<String> part = new JComboBox<>(PARTS);
	private final JTextArea input = new JTextArea();
	private final JTextArea output = new JTextArea();

	public Main() {
		JLabel dayPartLabel = new JLabel("Day and Part");

		this.day.setToolTipText("the advent day");
		this.part.setToolTipText("the part");

		JLabel inputLabel = new JLabel("Input");

		this.input.setBorder(BorderFactory.createEtchedBorder());

		JLabel outputLabel = new JLabel("Output");

		this.output.setBorder(BorderFactory.createEtchedBorder());

		JButton button = new JButton("JIT");

		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(null);

		this.add(button);
		this.add(dayPartLabel);
		this.add(this.day);
		this.add(this.part);
		this.add(inputLabel);
		this.add(this.input);
		this.add(outputLabel);
		this.add(this.output);

		Consumer<Object> runnable = e -> {
			String input = this.getInput();
			if(input.isEmpty()) return;
			this.getProblem().ifPresent(p ->  {
				Clock clock = new Clock();
				try {
					String solution = p.solve(clock, input);
					this.output.setText(solution);
				} catch (IllegalStateException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				} catch (Throwable ignored) {}

				FRAME.setTitle("Elapsed Time:" + clock.getElapsed()/1_000_000d + "ms");
			});
		};

		Consumer<Object> jit = e -> {
			String input = this.getInput();
			if(input.isEmpty()) return;

			this.getProblem().ifPresent(p -> {
				Clock clock = new Clock();
				// warmup..
				button.setText("Warming up...");
				for (int i = 0; i < 100_000; i++) {
					p.solve(clock, input);
				}

				clock.reset();
				button.setText("Testing...");
				for (int i = 0; i < 10_000; i++) {
					p.solve(clock, input);
				}

				button.setText("JIT");

				// just to output the number in output
				runnable.accept(e);

				FRAME.setTitle("Average Time: " + clock.getElapsed() / (10_000d * 1_000_000) + "ms");
			});
		};

		this.day.addActionListener(runnable::accept);
		this.part.addActionListener(runnable::accept);
		this.input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				runnable.accept(e);
			}
		});
		button.addActionListener(jit::accept);


		dayPartLabel.setBounds(100, 20, 300, 25);
		this.day.setBounds(100, 45, 300, 25);
		this.part.setBounds(100, 70, 300, 25);
		inputLabel.setBounds(100, 95, 300, 25);
		this.input.setBounds(100, 120, 300, 165);
		outputLabel.setBounds(100, 290, 300, 25);
		this.output.setBounds(100, 315, 300, 75);
		button.setBounds(100, 400, 300, 25);
	}

	private Optional<Problem> getProblem() {
		Problem problem = Problems.get(this.getDay(), this.getPart());
		if(problem == null) {
			JOptionPane.showMessageDialog(null, "That day hasn't been solved yet");
			return Optional.empty();
		}
		return Optional.of(problem);
	}

	private int getDay() {
		return DAYS.indexOf(this.day.getSelectedItem())+1;
	}

	private int getPart() {
		return PARTS.indexOf(this.part.getSelectedItem())+1;
	}

	private String getInput() {
		return this.input.getText();
	}
}