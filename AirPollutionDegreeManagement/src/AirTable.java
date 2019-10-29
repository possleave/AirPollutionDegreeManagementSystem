import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AirTable implements MouseListener{
	private Vector<String> col = new Vector<>();
	private JTable jt;
	private DefaultTableModel model;      //값들을 넣을 테이블 모델
	private int row = -1;   //선택된 행의 초기 index값을 - 1로 생성
	public AirTable() {
		col.addElement("측정일시");          //열을 추가한다
		col.addElement("측정소명");
		col.addElement("이산화질소농도");
		col.addElement("오존농도");
		col.addElement("이산화탄소농도");
		col.addElement("아황산가스");
		col.addElement("미세먼지");
		col.addElement("초미세먼지");
	
		model = new DefaultTableModel(col,0 ) {      //열벡터를 가지고 테이블 모델을 생성
			public boolean isCellEditable(int row,int column) {  //클릭으로 셀의 내용을 변경할 수있는것을 막는다
				return false;
			}		
		};
		
		jt = new JTable(model);
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //테이블의 행이 한 행만 선택되게 한다
		jt.addMouseListener(this);        //클릭하여 행을 선택하고 index를 가져오기 위하여 마우스리스너를 달아줌
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);           //직접 열의 크기를 조절할 수있게 세팅하여
		jt.getColumnModel().getColumn(0).setPreferredWidth(20); //작은값이 들어가는 열의 크기를 조절하고
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);  //나머지는 창크기에 맞게 크기를 배치
	}
	
	public JTable getTable() {       //메인뷰어에 테이블을 전달해줄 함수
		return jt;
	}
	public int getIndex() {    //선택된 행의 index getter
		return row;
	}
	public DefaultTableModel getModel(){   //테이블 모델 getter
		return model;
	}
	@Override
	public void mouseClicked(MouseEvent event) {       //마우스 클릭시
		row = jt.getSelectedRow();                     //해당 행의 index를 set
	}

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}

