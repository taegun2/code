import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


class ma6 extends JFrame implements ActionListener{
	JRadioButton b1,b2,b3;
	JLabel l1,l2;
	ma6(){
		setSize(300,150);
		setTitle("20191102 이태건");
		setLocation(1000,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		l1 = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		
		b1 = new JRadioButton("small size");
		b2 = new JRadioButton("Medium size");
		b3 = new JRadioButton("LARGE size");
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		l2 = new JLabel("선택해주세요");
		
		
		
		p4.add(l2);
		
		p3.add(b1); p3.add(b2); p3.add(b3);
		p2.add(l1);
		p.add(p2); p.add(p3); p.add(p4);
		this.add(p);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			l2.setText("small 선택하셨습니다람쥐.");
		}
		else if(e.getSource() == b2) {
			l2.setText("Medium 선택하셨습니다리우스");
		}
		else if(e.getSource() == b3) {
			l2.setText("Medium 선택하셨습니다시마");
		}
	}
	
}
public class p1104_2 {

	public static void main(String[] args) {
		ma6 OP1 = new ma6();

	}

}
