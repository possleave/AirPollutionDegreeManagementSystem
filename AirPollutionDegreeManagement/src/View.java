import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View extends JFrame{
	private JTable jt;
	private JScrollPane scrollPane;
	private AirTable tablebox;
	
	public View() {
		setTitle("Air Pollution Degree Management System");
		tablebox = new AirTable();
		jt = tablebox.getTable();
		
		File Filemenu = new File(this);
		JMenuBar mb = new JMenuBar();       //메뉴바생성
		mb.add(Filemenu.getmenu());
		
		scrollPane = new JScrollPane(jt); 
		
		this.add(scrollPane, BorderLayout.CENTER);
		setJMenuBar(mb);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //종료버튼 클릭시 시스템종료
		setSize(1300,800);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {     //종료버튼 클릭 시
				int result = JOptionPane.showConfirmDialog(null, "파일을 저장하시고 종료하시겠습니까?","저장여부", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);  //시스템 종료
				} else { System.exit(0); }   //'아니오'시 바로 시스템 종료
			}
		});
		setVisible(true);
	}
	
	public AirTable getAirtable() {
		return tablebox;
	}
	
	public void refresh() {   //화면갱신 함수
		jt.updateUI();        //테이블을 갱신
	}
	
	public static void main(String[] args) {
		new View();
	}

}
