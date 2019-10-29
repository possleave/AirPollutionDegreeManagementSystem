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
		JMenuBar mb = new JMenuBar();       //�޴��ٻ���
		mb.add(Filemenu.getmenu());
		
		scrollPane = new JScrollPane(jt); 
		
		this.add(scrollPane, BorderLayout.CENTER);
		setJMenuBar(mb);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //�����ư Ŭ���� �ý�������
		setSize(1300,800);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {     //�����ư Ŭ�� ��
				int result = JOptionPane.showConfirmDialog(null, "������ �����Ͻð� �����Ͻðڽ��ϱ�?","���忩��", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);  //�ý��� ����
				} else { System.exit(0); }   //'�ƴϿ�'�� �ٷ� �ý��� ����
			}
		});
		setVisible(true);
	}
	
	public AirTable getAirtable() {
		return tablebox;
	}
	
	public void refresh() {   //ȭ�鰻�� �Լ�
		jt.updateUI();        //���̺��� ����
	}
	
	public static void main(String[] args) {
		new View();
	}

}
