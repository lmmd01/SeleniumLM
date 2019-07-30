package pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreation {

	Document doc;

	public void openPdf() throws Exception{

		String fileName = "C:/Users/PCDUARTE01/Desktop/test-"+System.currentTimeMillis()+".pdf";

		FileOutputStream fos = new FileOutputStream(fileName);

		doc = new Document();

		PdfWriter.getInstance(doc, fos);

		doc.open();
	}

	public void addMetaData(String authorName, String title, String description){
		doc.addAuthor(authorName);
		doc.addTitle(title);
		doc.addSubject(description);
	}

	public void addParagraph(String text) throws Exception{
		doc.add(new Paragraph(text));

	}

	public void closePdf(){
		doc.close();
	}

	public void createPDF(String tid, Boolean result) throws Exception {
		openPdf();
		addMetaData("LMMD", "Test Automation Results", "Results for test: " + tid);
		addParagraph("El resultado del test: " + tid + " fue: " + result);
		closePdf();
	}


	public void helloPDF() throws Exception {
		String fileName = "C:/Users/PCDUARTE01/Desktop/test.pdf";
		FileOutputStream fos = new FileOutputStream(fileName);
		Document doc = new Document();
		PdfWriter.getInstance(doc, fos);
		doc.open();
		doc.addAuthor("authorName");
		doc.addTitle("title");
		doc.addSubject("description");
		doc.add(new Paragraph("This is paragraph"));
		doc.close();
	}

}
