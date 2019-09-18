package com.fantaknight.webapp.views;

import java.awt.Color;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.fantaknight.webapp.domain.Rilevazioni;


public class RilevazioniPdfView extends MyAbstractPdfView
{

	private String fileName = "Rilevazioni.pdf";

	public RilevazioniPdfView()
	{
		fileName = "Rilevazioni.pdf";
	}

	public RilevazioniPdfView(String NomeFile)
	{
		fileName = NomeFile;
	}
	
	@SuppressWarnings("unchecked")
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		final String Titolo = "Elenco Rilevazioni";
		 
		//Impostazione del nome del file
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
           
        List<Rilevazioni> rilevazioni = (List<Rilevazioni>) model.get("Rilevazioni");
      
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);
      
 
        //impostazione  del colore e tipo di font
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(Color.WHITE);
 
        // impostazioni dell'intestazione
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
 
        // Intestazione del documento
        cell.setPhrase(new Phrase("Data", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("IdTerminale", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Barcode", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Descrizione", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Qta", font));
        table.addCell(cell);
 
        for(Rilevazioni rilevazione : rilevazioni)
        {
            table.addCell(rilevazione.getData());
            table.addCell(rilevazione.getIdTerminale());
            table.addCell(rilevazione.getBarcode());
            table.addCell(rilevazione.getDescrizione());
            table.addCell(rilevazione.getQta());
        } 
 
        document.addTitle(Titolo);
        document.add(new Paragraph("Documento Creato il " + LocalDate.now()));
        document.setPageCount(0);
     
        document.add(table);
    } 
}

