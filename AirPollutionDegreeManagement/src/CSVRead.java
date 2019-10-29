import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

public class CSVRead {
   private DefaultTableModel model;
   private AirPollution AirPollution;
   private BufferedReader br = null;

   class FileTypeFilter extends FileFilter { // ���Ϻҷ������ csv���Ϻҷ����⸦ ������ֱ� ���� Ŭ����
      private final String extension;
      private final String description;

      public FileTypeFilter(String extension, String description) {
         this.extension = extension;
         this.description = description;
      }

      @Override
      public boolean accept(File f) {
         // TODO Auto-generated method stub
         if (f.isDirectory()) {
            return true;
         }

         return f.getName().endsWith(extension);
      }

      @Override
      public String getDescription() {
         // TODO Auto-generated method stub

         return description + String.format(" (*%s)", extension);
      }
   }

   public CSVRead(DefaultTableModel model) {
      this.model = model;

      JFileChooser fc = new JFileChooser(new File("c:\\")); // ���Ϻҷ����� â
      fc.setDialogTitle("Open file");
      fc.setFileFilter(new FileTypeFilter(".csv", "Csv File")); // �������͸� csv���Ϸ� �����Ѵ�
      int result = fc.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION) { // ������ �����������
         try {
            File sf = fc.getSelectedFile();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(sf.getPath()), "EUC-KR"));
            //Charset.forName("UTF-8");
            String line = "";
            while ((line = br.readLine()) != null) {
               // �������� �о�´�.
               System.out.println(line + "\n");
               String[] array = line.split(",", -1);
               //��ǥ�� �̿��� �����Ͽ� �迭�� �ִ´�
               //*****-1 �ɼ��� ������ "," ���� �� ���鵵 �б� ���� �ɼ�*****
               try {
                  AirPollution = new AirPollution(
                        array[0], array[1], 
                        Double.parseDouble(array[2]), Double.parseDouble(array[3]), 
                        Double.parseDouble(array[4]), Double.parseDouble(array[5]), 
                        Double.parseDouble(array[6]), Double.parseDouble(array[7]));
               } catch (NumberFormatException e) {
                  System.out.println("�����κκ��������մϴ�\n");
               } catch (NullPointerException e) {
                  System.out.println("NullPointerException\n");
               } catch(ArrayIndexOutOfBoundsException e) {
                  System.out.println("�ε�������\n");
               }

               // System.out.println(AirPollution);
               Vector<String> row = new Vector<>();
               for (int i = 0; i < 8; i++) { // ���̺� �־��ش�
                  row.addElement(array[i]);
               }
               model.addRow(row);
            }
         } catch (FileNotFoundException exception) { // ������ �߰����� ������ ���� ����ó��
            exception.printStackTrace();
         } catch (IOException exception2) { // ��������¿� ���� ����ó��
            exception2.printStackTrace();
         } finally {
            try {
               if (br != null) { // ����� ��ģ bufferedreader�� �ݾ��ش�.
                  br.close();
               }
            } catch (IOException exception2) {
               exception2.printStackTrace();
            }
         }
      }
   }
}