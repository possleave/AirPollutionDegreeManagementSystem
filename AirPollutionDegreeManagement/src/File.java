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
		fileMenu = new JMenu("파일");
		this.view=view;
		AirTable = view.getAirtable();
		model = AirTable.getModel();
		
		item = new JMenuItem("csv 저장");       //메뉴아이템들을 생성하고
		item.addActionListener(this);          //현재 클래스의 리스너를 달아줌
		fileMenu.add(item);
		item = new JMenuItem("csv 불러오기");
		item.addActionListener(this);
		fileMenu.add(item);
		item = new JMenuItem("db 저장");
		item.addActionListener(this);
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);    
		item.setAccelerator(key);                   //db저장 메뉴아이템에 ctrl+s 단축키를 지정
		fileMenu.add(item);
		item = new JMenuItem("db 불러오기");
		item.addActionListener(this);
		fileMenu.add(item);
	}
	
	public JMenu getmenu() {      //메인뷰어에 메뉴를 전달해줄 함수
		return fileMenu;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem mi = (JMenuItem)(e.getSource());
		
		switch (mi.getText()) {
		/*case "csv 저장":
			csvwrite cw = new csvwrite(model, stu);      //csv파일 저장 클래스 객체를 생성
			break;*/
		case "csv 불러오기":
			CSVRead cr = new CSVRead(model);    //csv파일 불러오기 클래스 객체를 생성
			view.refresh();   //메인뷰어 갱신
			break;
		/*case "db 저장":
			int result = 0;
			result = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?","db 저장", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {        //저장 하시겠습니까를 묻는 메세지를 출력 후 '예'를 누르면
				dbclear dc = new dbclear();          //현재 db의 데이터를 전부 지운후
				for(int row=0;row<stu.size();row++) {        //학생수만큼 반복하여 db에 현재 학생들의 정보들을 넣는다
					dbinsert di = new dbinsert(model, stu, row);
				}
			}
			break;
		case "db 불러오기":
			dbselect ds = new dbselect(model, ex, stu);     //db를 불러오는 클래스 객체 생성
			v.refresh();    //메인뷰어 갱신
			break;
		}*/
	}
	}
}

