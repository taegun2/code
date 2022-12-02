import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Mfra extends JFrame{
	int a=0;
	JPanel panel;
	
	class mt extends Thread{
		
		JLabel label;
		int interval;
		mt(int interval){
			this.interval=interval;
			label = new JLabel(a+"");
			Font font = new Font("SERIF",Font.BOLD,100);
			label.setFont(font);	
			panel.add(label);
		}
		@Override
		public void run() {
			while(true) {

				
					try {
						label.setText(a+"");
						Thread.sleep(interval);
						a=++a%10;
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
		
		panel = new JPanel();
		this.add(panel);
		new mt(1000).start();
		new mt(100).start();
		new mt(10).start();
		setVisible(true);
		
		

		
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
