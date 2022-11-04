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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


class ma7 extends JFrame implements ActionListener{
	JComboBox cb;
	JLabel l1,l2;
	ma7(){
		setSize(300,150);
		setTitle("20191102 이태건");
		setLocation(1000,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		l1 = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		
		cb = new JComboBox();
		cb.addItem("small");
		cb.addItem("Medium");
		cb.addItem("LARGE");
		cb.addActionListener(this);
		
		l2 = new JLabel("선택해주세요");
		p4.add(l2);
		
		p3.add(cb);
		p2.add(l1);
		p.add(p2); p.add(p3); p.add(p4);
		this.add(p);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox s = (JComboBox)e.getSource();
		if(s.getSelectedItem() == "small") {
			l2.setText("small 선택하셨습니다.");
		}
		else if(s.getSelectedItem() == "Medium") {
			l2.setText("Medium 선택하셨습니다");
		}
		else if(s.getSelectedItem() == "LARGE") {
			l2.setText("LARGE 선택하셨습니다");
		}
	}
	
}
public class p1104_3 {

	public static void main(String[] args) {
		ma7 op1 = new ma7();
	}

}
