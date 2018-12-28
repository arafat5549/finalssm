package pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.*;

public class PDFDemo {

    public static String getFiles(String outPath, String fileName, String filePath, int num) {
        try {
            File file = new File(filePath);
            InputStream in = new FileInputStream(file);
            // 获取文件后缀名，将其作为文件类型
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1,fileName.length()).toLowerCase();
            if (fileType != null && !fileType.equals("")) {
                if (fileType.equals("pdf")) {
                    // 获取pdf文档
                    PDFParser parser = new PDFParser(in);
                    parser.parse();
                    PDDocument pdDocument = parser.getPDDocument();
                    PDFTextStripper stripper = new PDFTextStripper();
                    //设置是否排序
                    stripper.setSortByPosition(true);
                    //设置起始页
                    stripper.setStartPage(num);
                    //设置结束页
                    stripper.setEndPage(num);
                    String content = stripper.getText(pdDocument);
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(outPath));
                    document.open();
                    BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
                    Font fontChinese = new Font(bfChinese, 12, Font.NORMAL, BaseColor.BLACK);
                    //建段落
                    Paragraph paragraph = new Paragraph();
                    paragraph.setFont(fontChinese);
//                    paragraph.add(paragraph); //加这一句 会报错  递归太深 报栈错误
                    paragraph.add(content);
                    //设置段落对齐方式
                    paragraph.setAlignment(Element.ALIGN_LEFT);
                    //设置缩进
                    paragraph.setIndentationLeft(100f);
                    //注意增加段落时会自动换行
                    document.add(paragraph);
                    document.close();
                    // 关闭文档
                    pdDocument.close();
                    return outPath;
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/arafat/Documents/test.pdf";
        //getFiles("/Users/arafat/Documents/outpdf","test.pdf","/Users/arafat/Documents/test.pdf",0);
        FileInputStream in = new FileInputStream(new File(fileName));
        int xx = in.read();
        while(xx!=-1){
            System.out.print((char)xx);
            xx = in.read();
        }
    }
}
