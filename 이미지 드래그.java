import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class ma5 extends JFrame {
	int x,y;
	int d_x,d_y;
	int l_x,l_y;
	JLabel l;
	class mymouse extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			l_x = l.getX(); l_y = l.getY();
			System.out.println("Clicked");
			x = e.getX(); y = e.getY();
			l.setLocation(l.getX(),l.getY());
			d_x = x - l_x;
			d_y = y - l_y;
			
		}
			
		@Override
		public void mouseDragged(MouseEvent e) {
			l_x = l.getX(); l_y = l.getY();
			if(l_x<= e.getX() && e.getX()<= l_x+100 && l.getY()<= e.getY() && e.getY()<= l.getY()+100) {
				int dr_x = e.getX(); int dr_y = e.getY();
				int n_x = dr_x-d_x; int n_y =dr_y-d_y;
				l.setLocation(n_x,n_y);
			}
		
		}
	}
	ma5(){
		setSize(600,600);
		setTitle("20191102 이태건");
		setLocation(1000,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel(null);
		l = new JLabel();
		ImageIcon icon = new ImageIcon("C://car.png");
		l.setIcon(icon);
		l.setSize(100,100);
		x = y = 300;
		l.setLocation(x,y);
		
		mymouse my = new mymouse();
		p.addMouseListener(my);
		p.addMouseMotionListener(my);
		p.add(l);
		this.add(p);
		
		setVisible(true);
		
	}

	

}
public class p1104_1 {

	public static void main(String[] args) {
		ma5 O1 = new ma5();
	}

}
