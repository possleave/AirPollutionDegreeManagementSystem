import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class File implements ActionListener{
	private JMenu fileMenu;
	private JMenuItem item;
	private View view;
	private AirTable AirTable;
	private DefaultTableModel model;
	
	public File(View view) {
		fileMenu = new JMenu("����");
		this.view=view;
		AirTable = view.getAirtable();
		model = AirTable.getModel();
		
		item = new JMenuItem("csv ����");       //�޴������۵��� �����ϰ�
		item.addActionListener(this);          //���� Ŭ������ �����ʸ� �޾���
		fileMenu.add(item);
		item = new JMenuItem("csv �ҷ�����");
		item.addActionListener(this);
		fileMenu.add(item);
		item = new JMenuItem("db ����");
		item.addActionListener(this);
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);    
		item.setAccelerator(key);                   //db���� �޴������ۿ� ctrl+s ����Ű�� ����
		fileMenu.add(item);
		item = new JMenuItem("db �ҷ�����");
		item.addActionListener(this);
		fileMenu.add(item);
	}
	
	public JMenu getmenu() {      //���κ� �޴��� �������� �Լ�
		return fileMenu;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mi = (JMenuItem)(e.getSource());
		
		switch (mi.getText()) {
		/*case "csv ����":
			csvwrite cw = new csvwrite(model, stu);      //csv���� ���� Ŭ���� ��ü�� ����
			break;*/
		case "csv �ҷ�����":
			CSVRead cr = new CSVRead(model);    //csv���� �ҷ����� Ŭ���� ��ü�� ����
			view.refresh();   //���κ�� ����
			break;
		/*case "db ����":
			int result = 0;
			result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?","db ����", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {        //���� �Ͻðڽ��ϱ ���� �޼����� ��� �� '��'�� ������
				dbclear dc = new dbclear();          //���� db�� �����͸� ���� ������
				for(int row=0;row<stu.size();row++) {        //�л�����ŭ �ݺ��Ͽ� db�� ���� �л����� �������� �ִ´�
					dbinsert di = new dbinsert(model, stu, row);
				}
			}
			break;
		case "db �ҷ�����":
			dbselect ds = new dbselect(model, ex, stu);     //db�� �ҷ����� Ŭ���� ��ü ����
			v.refresh();    //���κ�� ����
			break;
		}*/
	}
	}
}

