import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame implements MouseListener{
		
	 JPanel p1;
	 
	 MouseListener listener = this;
	 MyThread[] th = new MyThread[10];
	class MyThread extends Thread{
		JLabel l1;
		int x=0,y=0,y_2 = 100; int y_increment = 2; int x_increment = 2;
		int interval;
		MyThread(int interval){
			this.interval = interval;
			l1 = new JLabel("ltg"+(Thread.activeCount()-1));
			l1.setFont(new Font ("courier",Font.BOLD,30));
			x = (int)(Math.random()*450);
			y = (int)(Math.random()*320);
			l1.setBounds(x,y,35,35);
			l1.addMouseListener(listener);
			p1.add(l1);
		}
		@Override
		public void run() {
			while(true) {
				
				
				try {
					x+=x_increment;
					y+=y_increment;
					if(x>=430) { x_increment = -1;}
					if(y>=320) {y_increment = -2;}
					if(y<=0) {y_increment = 2;}
					if(x<=0) {x_increment = 2;}
					
					l1.setBounds(x,y,70,40);
					Thread.sleep(interval);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	MyFrame() throws InterruptedException{
		setSize(500,400);
		setLocation(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1 = new JPanel();
		p1.setLayout(null);
		
		
		th[0] = new MyThread(50); th[0].start(); 
		th[1] = new MyThread(50); th[1].start(); 
		th[2] = new MyThread(50); th[2].start(); 
		this.add(p1);
		
		setVisible(true);
		th[0].join(); th[1].join(); th[2].join();
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String s =((JLabel)e.getSource()).getText();
		//System.out.println(Thread.currentThread().getName());
		System.out.println(s);
		int num =Integer.parseInt(s.charAt(3)+"");
		//System.out.println(th[num].getName());
		th[num].stop();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
public class p1209 {

	public static void main(String[] args) throws InterruptedException {
		MyFrame f1 = new MyFrame(); // join 됨. main이 멈춤
		
		// join 된 쓰레드가 모두 stop되면 다시 실행
		System.out.print("End");
	}

}
