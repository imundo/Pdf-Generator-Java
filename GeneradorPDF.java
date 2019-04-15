package com.request;


import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.admin.transactions.EnrollTransaction;
import model.admin.transactions.TransactionAdmin;
import model.log.AuditLog;
import model.log.TrazabilityLog;
import model.mobile.Device;
import model.mobile.User;
import model.report.ErollmentReport;
import model.report.TransactionReport;


public class GeneradorPDF {



	public byte[] generateFilePdf(List<TransactionReport> transactionReport) {

		// creacion del documento
		Document documento = new Document(PageSize.TABLOID.rotate(), 10f, 10f, 10f, 0f);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();


		try {

			PdfWriter writer = PdfWriter.getInstance(documento, baos);
			// encabezado o titulo Reporte.
			String encabezadoReporte = " Reporte de Transacciones     "+"\n"+"\n";

			// Fecha generacion del Reporte.
			java.util.Date date = new java.util.Date();

			// Tipo de letra para el Reporte.
			//Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);

			// Crearemos imagen con el logo que va a utilizar el PDF.
			//Image imagenLogo = Image.getInstance(("../img/logo.png"));
			//imagenLogo.setAlignment(imagenLogo.LEFT | imagenLogo.TEXTWRAP);

			//Creamos Un parrafo para el titulo
			//Paragraph titulo = new Paragraph(encabezadoReporte, fuente);

			Paragraph titulo = new Paragraph(encabezadoReporte);
			Paragraph fecha = new Paragraph(String.valueOf(date)+"\n"+"\n");

			// creamos una tabla
			PdfPTable tabla = new PdfPTable(16);
			tabla.setWidthPercentage(100);

			// creacion del documento
			//Document documento = new Document(PageSize.A4);

			// creacion de la ruta donde se generara el archivo pdf
			//String rutaAlmacenamiento = "C:\\Users\\Atianza 05\\Downloads\\Transacciones.pdf";

			// generamos el PDF y escribimos contenido.
			//PdfWriter.getInstance(documento, new FileOutputStream(rutaAlmacenamiento));

			//Generamos la celdas de cabecera.
			PdfPCell celda1 = new PdfPCell(new Paragraph("UuidTransaction", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda2 = new PdfPCell(new Paragraph("SsnClient", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda3 = new PdfPCell(new Paragraph("NameClient", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda4 = new PdfPCell(new Paragraph("Channel", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda5 = new PdfPCell(new Paragraph("TransactionName", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda6 = new PdfPCell(new Paragraph("DateAuth", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda7 = new PdfPCell(new Paragraph("MethodApplied", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda8 = new PdfPCell(new Paragraph("DeviceOs", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda9 = new PdfPCell(new Paragraph("Status", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda10 = new PdfPCell(new Paragraph("Monto", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda11 = new PdfPCell(new Paragraph("AttrName", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda12 = new PdfPCell(new Paragraph("AttrValue", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda13 = new PdfPCell(new Paragraph("Recurrent", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda14 = new PdfPCell(new Paragraph("SubtypeTransaction", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda15 = new PdfPCell(new Paragraph("getRiskLevel", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda16 = new PdfPCell(new Paragraph("Monetary", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));


			//Ensamblamos el Documento
			documento.open();
			//		 documento.add(imagenLogo);
			documento.addTitle(encabezadoReporte);
			documento.add(fecha);
			tabla.addCell(celda1);
			tabla.addCell(celda2);
			tabla.addCell(celda3);
			tabla.addCell(celda4);
			tabla.addCell(celda5);
			tabla.addCell(celda6);
			tabla.addCell(celda7);
			tabla.addCell(celda8);
			tabla.addCell(celda9);
			tabla.addCell(celda10);
			tabla.addCell(celda11);
			tabla.addCell(celda12);
			tabla.addCell(celda13);
			tabla.addCell(celda14);
			tabla.addCell(celda15);
			tabla.addCell(celda16);
			for (TransactionReport transactionReporte : transactionReport) {
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getUuidTransaction()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getSsnClient()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getNameClient()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getChannel()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getTransactionName()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date today = transactionReporte.getDateAuth();
				String Inicio = df.format(today);
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Inicio), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getMethodApplied()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getDeviceOs()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getStatus()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getMonto()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getAttrName()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getAttrValue()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getRecurrent()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getSubtypeTransaction()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getRiskLevel()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(transactionReporte.getMonetary()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
//				 tabla.addCell(new PdfPCell(new Paragraph("\n"+"\n", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE))));

			}

			documento.add(tabla);
			documento.close();




		}catch(Exception e) {

		}

		return baos.toByteArray();

	}




	public byte[] generateFilePdfClients(List<User> users) {


		// creacion del documento
		Document documento = new Document(PageSize.TABLOID.rotate(), 10f, 10f, 10f, 0f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			PdfWriter writer = PdfWriter.getInstance(documento, baos);

			// encabezado o titulo Reporte.
			String encabezadoReporte = " Reporte de Clientes     "+"\n"+"\n";

			// Fecha generacion del Reporte.
			java.util.Date date = new java.util.Date();

			// Tipo de letra para el Reporte.

			//Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);
			// fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);

			// Crearemos imagen con el logo que va a utilizar el PDF.
			//Image imagenLogo = Image.getInstance(("../img/logo.png"));
			//imagenLogo.setAlignment(imagenLogo.LEFT | imagenLogo.TEXTWRAP);

			//Creamos Un parrafo para el titulo
			//Paragraph titulo = new Paragraph(encabezadoReporte, fuente);
			Paragraph titulo = new Paragraph(encabezadoReporte);
			Paragraph fecha = new Paragraph(String.valueOf(date)+"\n"+"\n");

			// creamos una tabla
			PdfPTable tabla = new PdfPTable(11);
			tabla.setWidthPercentage(100);

			// creacion del documento
			//Document documento = new Document(PageSize.A4);

			// creacion de la ruta donde se generara el archivo pdf
			//String rutaAlmacenamiento = "C:\\Users\\Atianza 05\\Downloads\\Clients.pdf";

			// generamos el PDF y escribimos contenido.
			//PdfWriter.getInstance(documento, new FileOutputStream(rutaAlmacenamiento));

			//Generamos la celdas de cabecera.
			PdfPCell celda1 = new PdfPCell(new Paragraph("Enrollmentfinish", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda2 = new PdfPCell(new Paragraph("Ssn", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda3 = new PdfPCell(new Paragraph("Surnames", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda4 = new PdfPCell(new Paragraph("Name", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda5 = new PdfPCell(new Paragraph("EnrollmentDate", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda6 = new PdfPCell(new Paragraph("InitialTimeEnroll", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda7 = new PdfPCell(new Paragraph("FinalTimeEnroll", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda8 = new PdfPCell(new Paragraph("Status", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda9 = new PdfPCell(new Paragraph("Institution Name", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda10 = new PdfPCell(new Paragraph("Last Access Channel", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda11 = new PdfPCell(new Paragraph("Auth Name", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			//Ensamblamos el Documento
			documento.open();
			//		 documento.add(imagenLogo);
			documento.addTitle(encabezadoReporte);
			documento.add(fecha);
			tabla.addCell(celda1);
			tabla.addCell(celda2);
			tabla.addCell(celda3);
			tabla.addCell(celda4);
			tabla.addCell(celda5);
			tabla.addCell(celda6);
			tabla.addCell(celda7);
			tabla.addCell(celda8);
			tabla.addCell(celda9);
			tabla.addCell(celda10);
			tabla.addCell(celda11);
			for (User clients : users) {
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getEnrollmentfinish().getId()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getSsn()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getSurnames()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph( String.valueOf(clients.getName()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getEnrollmentDate()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date today = clients.getEnrollmentfinish().getInitialTimeEnroll();
				String Inicio = df.format(today);
				tabla.addCell(new PdfPCell(new Paragraph( String.valueOf(Inicio), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
				Date today2 = clients.getEnrollmentfinish().getFinalTimeEnroll();
				String Final = df2.format(today2);
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Final), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getStatus()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getInstitution().getName()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getLastAccessChannel()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getAuth().getName()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
//				 tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(clients.getEnrollD().getDefinitionName()), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));

			}

			documento.add(tabla);
			documento.close();


		}catch(Exception e) {

		}

		return baos.toByteArray();



	}

	public byte[] generateFilePdfTrazability(List<TrazabilityLog> trazability) {

		// creacion del documento
		Document documento = new Document(PageSize.A4);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			PdfWriter writer = PdfWriter.getInstance(documento, baos);
			// encabezado o titulo Reporte.
			String encabezadoReporte = " Reporte de Tranzabilidad    "+"\n"+"\n";

			// Fecha generacion del Reporte.
			java.util.Date date = new java.util.Date();

			// Tipo de letra para el Reporte.
			//Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);

			// Crearemos imagen con el logo que va a utilizar el PDF.
			//Image imagenLogo = Image.getInstance(("../img/logo.png"));
			//imagenLogo.setAlignment(imagenLogo.LEFT | imagenLogo.TEXTWRAP);

			//Creamos Un parrafo para el titulo
			//Paragraph titulo = new Paragraph(encabezadoReporte, fuente);
			Paragraph titulo = new Paragraph(encabezadoReporte);
			Paragraph fecha = new Paragraph(String.valueOf(date)+"\n"+"\n");

			// creamos una tabla
			PdfPTable tabla = new PdfPTable(10);
			tabla.setWidthPercentage(100);

			//Generamos la celdas de cabecera.
			PdfPCell celda1 = new PdfPCell(new Paragraph("uuid Transaction", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda2 = new PdfPCell(new Paragraph("init OperationDate", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda3 = new PdfPCell(new Paragraph("end OperationTime", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda4 = new PdfPCell(new Paragraph("source Adress", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda5 = new PdfPCell(new Paragraph("geo Location", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda6 = new PdfPCell(new Paragraph("user Agent", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda7 = new PdfPCell(new Paragraph("device Finger Print", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda8 = new PdfPCell(new Paragraph("uuid Device", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda9 = new PdfPCell(new Paragraph("type Action", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda10 = new PdfPCell(new Paragraph("url Method", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));


			//Ensamblamos el Documento
			documento.open();
			//		 documento.add(imagenLogo);
			documento.addTitle(encabezadoReporte);
			documento.add(fecha);
			tabla.addCell(celda1);
			tabla.addCell(celda2);
			tabla.addCell(celda3);
			tabla.addCell(celda4);
			tabla.addCell(celda5);
			tabla.addCell(celda6);
			tabla.addCell(celda7);
			tabla.addCell(celda8);
			tabla.addCell(celda9);
			tabla.addCell(celda10);

			for (TrazabilityLog trazabilytyLog : trazability) {
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getUuidTransaction()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getInitOperationDate()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getEndOperationTime()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getSourceAdress()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getGeoLocation()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getUserAgent()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getDeviceFingerPrint()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getUuidDevice()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getTypeAction()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(trazabilytyLog.getUrlMethod()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));


			}

			documento.add(tabla);
			documento.close();


		}catch(Exception e) {

		}

		return baos.toByteArray();

	}



	public byte[] generateFilePdfAuditoria(List<AuditLog> auditLogs ) {

		// creacion del documento
		Document documento = new Document(PageSize.A4);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			PdfWriter writer = PdfWriter.getInstance(documento, baos);
			// encabezado o titulo Reporte.
			String encabezadoReporte = " Reporte de  Auditoria    "+"\n"+"\n";

			// Fecha generacion del Reporte.
			java.util.Date date = new java.util.Date();

			// Tipo de letra para el Reporte.
			//Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);

			// Crearemos imagen con el logo que va a utilizar el PDF.
			//Image imagenLogo = Image.getInstance(("../img/logo.png"));
			//imagenLogo.setAlignment(imagenLogo.LEFT | imagenLogo.TEXTWRAP);

			//Creamos Un parrafo para el titulo
			//Paragraph titulo = new Paragraph(encabezadoReporte, fuente);
			Paragraph titulo = new Paragraph(encabezadoReporte);
			Paragraph fecha = new Paragraph(String.valueOf(date)+"\n"+"\n");

			// creamos una tabla
			PdfPTable tabla = new PdfPTable(12);
			tabla.setWidthPercentage(100);


			//Generamos la celdas de cabecera.
			PdfPCell celda1 = new PdfPCell(new Paragraph("Id", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda2 = new PdfPCell(new Paragraph("Event Date", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda3 = new PdfPCell(new Paragraph("Source Address", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda4 = new PdfPCell(new Paragraph("Event Type", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda5 = new PdfPCell(new Paragraph("Uuid Event", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda6 = new PdfPCell(new Paragraph("User name", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda7 = new PdfPCell(new Paragraph("Internal_user_id", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda8 = new PdfPCell(new Paragraph("Event Component", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda9 = new PdfPCell(new Paragraph("Event Description", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda10 = new PdfPCell(new Paragraph("Event Criticality", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda11 = new PdfPCell(new Paragraph("System Response", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda12 = new PdfPCell(new Paragraph("Uuid Transaction", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));


			//Ensamblamos el Documento
			documento.open();
			//		 documento.add(imagenLogo);
			documento.addTitle(encabezadoReporte);
			documento.add(fecha);
			tabla.addCell(celda1);
			tabla.addCell(celda2);
			tabla.addCell(celda3);
			tabla.addCell(celda4);
			tabla.addCell(celda5);
			tabla.addCell(celda6);
			tabla.addCell(celda7);
			tabla.addCell(celda8);
			tabla.addCell(celda9);
			tabla.addCell(celda10);
			tabla.addCell(celda11);
			tabla.addCell(celda12);


			for (AuditLog audit : auditLogs) {
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getId()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getEventDate()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getSourceAddress()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getEventType()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getUuidEvent()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getUsername()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getInternal_user_id()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getEventComponent().replaceAll("null", "   ")), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getEventDescription()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getEventCriticality()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getSystemResponse()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(audit.getUuidTransaction()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));

			}

			documento.add(tabla);
			documento.close();


		}catch(Exception e) {

		}

		return baos.toByteArray();

	}

	public byte[] generateFilePdfDevices(List<Device> devices) {


		// creacion del documento
		Document documento = new Document(PageSize.TABLOID.rotate(), 10f, 10f, 10f, 0f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			PdfWriter writer = PdfWriter.getInstance(documento, baos);

			// encabezado o titulo Reporte.
			String encabezadoReporte = " Reporte de Clientes     " + "\n" + "\n";

			// Fecha generacion del Reporte.
			java.util.Date date = new java.util.Date();

			// Tipo de letra para el Reporte.

			//Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);
			// fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);

			// Crearemos imagen con el logo que va a utilizar el PDF.
			//Image imagenLogo = Image.getInstance(("../img/logo.png"));
			//imagenLogo.setAlignment(imagenLogo.LEFT | imagenLogo.TEXTWRAP);

			//Creamos Un parrafo para el titulo
			//Paragraph titulo = new Paragraph(encabezadoReporte, fuente);
			Paragraph titulo = new Paragraph(encabezadoReporte);
			Paragraph fecha = new Paragraph(String.valueOf(date) + "\n" + "\n");

			// creamos una tabla
			PdfPTable tabla = new PdfPTable(11);
			tabla.setWidthPercentage(100);

			// creacion del documento
		
			// generamos el PDF y escribimos contenido.
			//PdfWriter.getInstance(documento, new FileOutputStream(rutaAlmacenamiento));

			//Generamos la celdas de cabecera.
			PdfPCell celda1 = new PdfPCell(new Paragraph("App Name", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre y Apellido", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda3 = new PdfPCell(new Paragraph("Ssn", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda4 = new PdfPCell(new Paragraph("Ultimo enrolamiento ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda5 = new PdfPCell(new Paragraph("Finger Print ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda6 = new PdfPCell(new Paragraph("OsVersion", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda7 = new PdfPCell(new Paragraph("getEnrollmentServerKey", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda8 = new PdfPCell(new Paragraph("Status", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda9 = new PdfPCell(new Paragraph("So", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda10 = new PdfPCell(new Paragraph("Uuid", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda11 = new PdfPCell(new Paragraph("Enrollment fecha", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));

			//Ensamblamos el Documento
			documento.open();
			//		 documento.add(imagenLogo);
			documento.addTitle(encabezadoReporte);
			documento.add(fecha);
			tabla.addCell(celda1);
			tabla.addCell(celda2);
			tabla.addCell(celda3);
			tabla.addCell(celda4);
			tabla.addCell(celda5);
			tabla.addCell(celda6);
			tabla.addCell(celda7);
			tabla.addCell(celda8);
			tabla.addCell(celda9);
			tabla.addCell(celda10);
			tabla.addCell(celda11);
			for (Device Dispositivo : devices) {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date today = Dispositivo.getEnrollmentDate();
				String reportDate = df.format(today);
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getAppName()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getUser().getName()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getUser().getSsn()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getUser().getLastAccess()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getDeviceFingerPrint()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getOsVersion()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getEnrollmentServerKey()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getStatus()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getSo()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(Dispositivo.getUuid()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(reportDate).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));


			}

			documento.add(tabla);
			documento.close();


		}catch(Exception e) {

		}

		return baos.toByteArray();



	}
	public byte[] generateFilePdfEnrollment(List<ErollmentReport> enrollmentTransactions) {

		// creacion del documento
		Document documento = new Document(PageSize.TABLOID.rotate(), 10f, 10f, 10f, 0f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			PdfWriter writer = PdfWriter.getInstance(documento, baos);

			// encabezado o titulo Reporte.
			String encabezadoReporte = " Reporte de Enrolamiento    "+"\n"+"\n";

			// Fecha generacion del Reporte.
			java.util.Date date = new java.util.Date();

			// Tipo de letra para el Reporte.
			//Font fuente = new Font(Font.getFamily("ARIAL"),12, Font.BOLD);

			// Crearemos imagen con el logo que va a utilizar el PDF.
			//Image imagenLogo = Image.getInstance(("../img/logo.png"));
			//imagenLogo.setAlignment(imagenLogo.LEFT | imagenLogo.TEXTWRAP);

			//Creamos Un parrafo para el titulo
			//Paragraph titulo = new Paragraph(encabezadoReporte, fuente);
			Paragraph titulo = new Paragraph(encabezadoReporte);
			Paragraph fecha = new Paragraph(String.valueOf(date)+"\n"+"\n");

			// creamos una tabla
			PdfPTable tabla = new PdfPTable(12);
			tabla.setWidthPercentage(100);

			
			//PdfWriter.getInstance(documento, new FileOutputStream(rutaAlmacenamiento));

			//Generamos la celdas de cabecera.
			PdfPCell celda1 = new PdfPCell(new Paragraph("uuid Enrollment", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda2 = new PdfPCell(new Paragraph("ssn Client", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda3 = new PdfPCell(new Paragraph("Name Client", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda4 = new PdfPCell(new Paragraph("Enrollment Date", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda5 = new PdfPCell(new Paragraph("Device Os", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda6 = new PdfPCell(new Paragraph("Status", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda7 = new PdfPCell(new Paragraph("Scoring", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda8 = new PdfPCell(new Paragraph("Institutions", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda9 = new PdfPCell(new Paragraph("States", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda10 = new PdfPCell(new Paragraph("Name Aplication", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda11 = new PdfPCell(new Paragraph("Final Scoring", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));
			PdfPCell celda12 = new PdfPCell(new Paragraph("Total Time Enroll", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE)));


			//Ensamblamos el Documento
			documento.open();
			//		 documento.add(imagenLogo);
			documento.addTitle(encabezadoReporte);
			documento.add(fecha);
			tabla.addCell(celda1);
			tabla.addCell(celda2);
			tabla.addCell(celda3);
			tabla.addCell(celda4);
			tabla.addCell(celda5);
			tabla.addCell(celda6);
			tabla.addCell(celda7);
			tabla.addCell(celda8);
			tabla.addCell(celda9);
			tabla.addCell(celda10);
			tabla.addCell(celda11);
			tabla.addCell(celda12);



			for (ErollmentReport enrollAdmin : enrollmentTransactions) {
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getUuidEnrollment()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getSsnClient()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getNameClient()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getEnrollmentDate()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getDeviceOs()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getStatus()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getScoring()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getInstitutions()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getEstado()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getNombreAplicacion()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getFinalScoring()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				tabla.addCell(new PdfPCell(new Paragraph(String.valueOf(enrollAdmin.getTiempoTotalEnroll()).replaceAll("null", "   "), FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));
				//tabla.addCell(new PdfPCell(new Paragraph(enrollAdmin., FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLACK))));

				// tabla.addCell(new PdfPCell(new Paragraph("\n"+"\n", FontFactory.getFont("arial",10,Font.BOLD, BaseColor.BLUE))));

			}

			documento.add(tabla);
			documento.close();


		}catch(Exception e) {

		}

		return baos.toByteArray();

	}
}




