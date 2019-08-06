package pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreation {

	Document doc;

	public void openPdf(String tid) throws Exception{

		String fileName = "C:/Users/PCDUARTE01/Desktop/tests/TEST-" + tid + ".pdf";

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

	public void createPDF(String tid, String name, String description, Boolean result) throws Exception {
		openPdf(tid);
		addMetaData("LMMD", "Test Automation Results","");
		addParagraph("TEST ID : " + tid);
		addParagraph("TEST NAME : " + name);
		addParagraph("TEST DESCRIPTION : " + description);
		addParagraph("TEST RESULT : " + result);
		
		Image img = Image.getInstance("C:/Users/PCDUARTE01/Desktop/tests/" + tid + ".png ");
		img.scaleToFit(500, 500);
		doc.add(img);
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
