import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Mfra extends JFrame{
	int a=-1,b=-1,c=-1;
	JLabel l1,l2,l3;
	class mt extends Thread{
		JLabel label;
		int interval = 1000;
		mt(JLabel label){
			this.label = label;
		}
		@Override
		public void run() {
			while(true) {
				//System.out.println(Thread.currentThread() + "쓰레드 실행");
				if(label == l1) {
					interval = 1000;
					a= ++a%10;
					l1.setText(a+"");
				}
				else if(label == l2) {
					interval = 100;
					b= ++b%10;
					l2.setText(b+"");
				}
				else if(label == l3) {
					interval = 10;
					c= ++c%10;
					l3.setText(c+"");
				}
				
					try {
						Thread.sleep(interval);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
		}
		
	}
	Mfra(){
		setSize(400,300);
		setLocation(670,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		l1 = new JLabel(a+"");
		l2 = new JLabel(b+"");
		l3 = new JLabel(c+"");
		Font font = new Font("SERIF",Font.BOLD,100);
		l1.setFont(font);l2.setFont(font);l3.setFont(font);	
		panel.add(l1);panel.add(l2);panel.add(l3);
		this.add(panel);
		setVisible(true);
		new mt(l1).start();
		new mt(l2).start();
		new mt(l3).start();
		
	}
}
public class p1202_1 {
	
	static void runcod() {
		while(true) {
			System.out.println(Thread.currentThread() + "쓰레드 실행");
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
	public static void main(String[] args) {
		
		Mfra f1 = new Mfra();
		
	}

}
