import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AirTable implements MouseListener{
	private Vector<String> col = new Vector<>();
	private JTable jt;
	private DefaultTableModel model;      //������ ���� ���̺� ��
	private int row = -1;   //���õ� ���� �ʱ� index���� - 1�� ����
	public AirTable() {
		col.addElement("�����Ͻ�");          //���� �߰��Ѵ�
		col.addElement("�����Ҹ�");
		col.addElement("�̻�ȭ���ҳ�");
		col.addElement("������");
		col.addElement("�̻�ȭź�ҳ�");
		col.addElement("��Ȳ�갡��");
		col.addElement("�̼�����");
		col.addElement("�ʹ̼�����");
	
		model = new DefaultTableModel(col,0 ) {      //�����͸� ������ ���̺� ���� ����
			public boolean isCellEditable(int row,int column) {  //Ŭ������ ���� ������ ������ ���ִ°��� ���´�
				return false;
			}		
		};
		
		jt = new JTable(model);
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //���̺��� ���� �� �ุ ���õǰ� �Ѵ�
		jt.addMouseListener(this);        //Ŭ���Ͽ� ���� �����ϰ� index�� �������� ���Ͽ� ���콺�����ʸ� �޾���
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);           //���� ���� ũ�⸦ ������ ���ְ� �����Ͽ�
		jt.getColumnModel().getColumn(0).setPreferredWidth(20); //�������� ���� ���� ũ�⸦ �����ϰ�
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);  //�������� âũ�⿡ �°� ũ�⸦ ��ġ
	}
	
	public JTable getTable() {       //���κ� ���̺��� �������� �Լ�
		return jt;
	}
	public int getIndex() {    //���õ� ���� index getter
		return row;
	}
	public DefaultTableModel getModel(){   //���̺� �� getter
		return model;
	}
	@Override
	public void mouseClicked(MouseEvent event) {       //���콺 Ŭ����
		row = jt.getSelectedRow();                     //�ش� ���� index�� set
	}

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}

