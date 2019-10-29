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

   class FileTypeFilter extends FileFilter { // 파일불러오기시 csv파일불러오기를 명시해주기 위한 클래스
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

      JFileChooser fc = new JFileChooser(new File("c:\\")); // 파일불러오기 창
      fc.setDialogTitle("Open file");
      fc.setFileFilter(new FileTypeFilter(".csv", "Csv File")); // 파일필터를 csv파일로 지정한다
      int result = fc.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION) { // 파일을 선택했을경우
         try {
            File sf = fc.getSelectedFile();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(sf.getPath()), "EUC-KR"));
            //Charset.forName("UTF-8");
            String line = "";
            while ((line = br.readLine()) != null) {
               // 한줄한줄 읽어온다.
               System.out.println(line + "\n");
               String[] array = line.split(",", -1);
               //쉼표를 이용해 구분하여 배열에 넣는다
               //*****-1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션*****
               try {
                  AirPollution = new AirPollution(
                        array[0], array[1], 
                        Double.parseDouble(array[2]), Double.parseDouble(array[3]), 
                        Double.parseDouble(array[4]), Double.parseDouble(array[5]), 
                        Double.parseDouble(array[6]), Double.parseDouble(array[7]));
               } catch (NumberFormatException e) {
                  System.out.println("공백인부분이존재합니다\n");
               } catch (NullPointerException e) {
                  System.out.println("NullPointerException\n");
               } catch(ArrayIndexOutOfBoundsException e) {
                  System.out.println("인덱스에러\n");
               }

               // System.out.println(AirPollution);
               Vector<String> row = new Vector<>();
               for (int i = 0; i < 8; i++) { // 테이블에 넣어준다
                  row.addElement(array[i]);
               }
               model.addRow(row);
            }
         } catch (FileNotFoundException exception) { // 파일을 발견하지 못했을 시의 예외처리
            exception.printStackTrace();
         } catch (IOException exception2) { // 파일입출력에 관한 예외처리
            exception2.printStackTrace();
         } finally {
            try {
               if (br != null) { // 사용을 마친 bufferedreader를 닫아준다.
                  br.close();
               }
            } catch (IOException exception2) {
               exception2.printStackTrace();
            }
         }
      }
   }
}