package com.ticnow.security.idnow.admin.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ticnow.security.model.mobile.Device;
import com.ticnow.security.model.report.ErollmentReport;
import com.ticnow.security.model.report.TransactionReport;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import com.ticnow.security.model.admin.transactions.EnrollTransaction;
import com.ticnow.security.model.admin.transactions.TransactionAdmin;
import com.ticnow.security.model.log.AuditLog;
import com.ticnow.security.model.log.TrazabilityLog;
import com.ticnow.security.model.mobile.User;

public class GeneradorExcel {

	int numFila = 0;

	public byte[] GenerarExcel(List<TransactionReport> transactionReport) throws WriteException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			WorkbookSettings conf =  new WorkbookSettings();
			conf.setEncoding("ISO-8859-1");

			//WritableWorkbook  workbook = Workbook.createWorkbook(new File("C:\\Users\\Atianza 05\\Downloads\\Transacciones.xls"), conf);
			WritableWorkbook  workbook = Workbook.createWorkbook(baos, conf);
			WritableSheet sheet = workbook.createSheet("Reporte Exel", 0);
			WritableFont font = new WritableFont(WritableFont.COURIER, 18, WritableFont.BOLD );
			WritableCellFormat formatCell = new WritableCellFormat(font);
// create font style for header cells
			WritableFont headerCellFont = new WritableFont(WritableFont.ARIAL, 14,
					WritableFont.BOLD, true);
			//create format for header cells
			WritableCellFormat headerCellFormat = new WritableCellFormat(
					headerCellFont);
			// create header cells
			Label headerCell1 = new Label(0, 0, "Uuid Transaction", headerCellFormat);
			Label headerCell2 = new Label(1, 0, "SsnClient", headerCellFormat);
			Label headerCell3 = new Label(2, 0, "NameClient", headerCellFormat);
			Label headerCell4 = new Label(3, 0, "Channel", headerCellFormat);
			Label headerCell5 = new Label(4, 0, "TransactionName", headerCellFormat);
			Label headerCell6 = new Label(5, 0, "DateAuth", headerCellFormat);
			Label headerCell7 = new Label(6, 0, "MethodApplied", headerCellFormat);
			Label headerCell8 = new Label(7, 0, "DeviceOs", headerCellFormat);
			Label headerCell9 = new Label(8, 0, "Status", headerCellFormat);
			Label headerCell10 = new Label(9, 0, "Monto", headerCellFormat);
			Label headerCell11 = new Label(10, 0, "AttrName", headerCellFormat);
			Label headerCell12 = new Label(11, 0, "AttrValue", headerCellFormat);
			Label headerCell13 = new Label(12, 0, "Recurrent", headerCellFormat);
			Label headerCell14 = new Label(13, 0, "SubtypeTransactions", headerCellFormat);
			Label headerCell15 = new Label(14, 0, "getRiskLevel", headerCellFormat);
			Label headerCell16 = new Label(15, 0, "Monetary", headerCellFormat);
			// add header cells to sheet
			sheet.addCell(headerCell1);
			sheet.addCell(headerCell2);
			sheet.addCell(headerCell3);
			sheet.addCell(headerCell4);
			sheet.addCell(headerCell5);
			sheet.addCell(headerCell6);
			sheet.addCell(headerCell7);
			sheet.addCell(headerCell8);
			sheet.addCell(headerCell9);
			sheet.addCell(headerCell10);
			sheet.addCell(headerCell11);
			sheet.addCell(headerCell12);
			sheet.addCell(headerCell13);
			sheet.addCell(headerCell14);
			sheet.addCell(headerCell15);
			sheet.addCell(headerCell16);
			sheet.setColumnView(0, 50);
			sheet.setColumnView(1, 50);
			sheet.setColumnView(2, 50);
			sheet.setColumnView(3, 20);
			sheet.setColumnView(4, 50);
			sheet.setColumnView(5, 20);
			sheet.setColumnView(6, 50);
			sheet.setColumnView(7, 20);
			sheet.setColumnView(8, 20);
			sheet.setColumnView(9, 20);
			sheet.setColumnView(10, 20);
			sheet.setColumnView(11, 20);
			sheet.setColumnView(12, 20);
			sheet.setColumnView(13, 20);
			sheet.setColumnView(14, 50);
			int i = 0;
			int numFila = 1;
			for (TransactionReport transactionReporte : transactionReport) {
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getUuidTransaction()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getSsnClient()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getNameClient()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getChannel()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getTransactionName()).replaceAll("null", "   "), formatCell));
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date today = transactionReporte.getDateAuth();
				String Inicio = df.format(today);
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(Inicio), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getMethodApplied()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getDeviceOs()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getStatus()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getMonto()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getAttrName()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getAttrValue()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getRecurrent()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getSubtypeTransaction()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getRiskLevel()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(transactionReporte.getMonetary()).replaceAll("null", "   "), formatCell));

				numFila = numFila + 1;
				i = 0;
			}
			workbook.write();
			workbook.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos.toByteArray();

	}


	public byte[] GenerarExcelClients(List<User> users) throws RowsExceededException, WriteException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			WorkbookSettings conf =  new WorkbookSettings();
			conf.setEncoding("ISO-8859-1");

			//WritableWorkbook  workbook = Workbook.createWorkbook(new File("C:\\Users\\Atianza 05\\Downloads\\Clients.xls"), conf);

			WritableWorkbook  workbook = Workbook.createWorkbook(baos, conf);
			WritableSheet sheet = workbook.createSheet("Reporte Excel", 0);

			WritableFont font = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD );
			WritableCellFormat formatCell = new WritableCellFormat(font);


			// create font style for header cells
			WritableFont headerCellFont = new WritableFont(WritableFont.ARIAL, 14,
					WritableFont.BOLD, true);
			//create format for header cells
			WritableCellFormat headerCellFormat = new WritableCellFormat(
					headerCellFont);
			// create header cells
			Label headerCell1 = new Label(0, 0, "Enrollmentfinish", headerCellFormat);
			Label headerCell2 = new Label(1, 0, "SsnClient", headerCellFormat);
			Label headerCell3 = new Label(2, 0, "NameClient", headerCellFormat);
			Label headerCell4 = new Label(3, 0, "Surnames", headerCellFormat);
			Label headerCell5 = new Label(4, 0, "Date Inicio", headerCellFormat);
			Label headerCell6 = new Label(5, 0, "Date Final", headerCellFormat);
			Label headerCell7 = new Label(6, 0, "Status", headerCellFormat);
			Label headerCell8 = new Label(7, 0, "Institution", headerCellFormat);
			Label headerCell9 = new Label(8, 0, "LastAccessChannel", headerCellFormat);
			Label headerCell10 = new Label(9, 0, "Auth", headerCellFormat);
			// add header cells to sheet
			sheet.addCell(headerCell1);
			sheet.addCell(headerCell2);
			sheet.addCell(headerCell3);
			sheet.addCell(headerCell4);
			sheet.addCell(headerCell5);
			sheet.addCell(headerCell6);
			sheet.addCell(headerCell7);
			sheet.addCell(headerCell8);
			sheet.addCell(headerCell9);
			sheet.addCell(headerCell10);
			sheet.setColumnView(0, 50);
			sheet.setColumnView(1, 20);
			sheet.setColumnView(2, 50);
			sheet.setColumnView(3, 20);
			sheet.setColumnView(4, 50);
			sheet.setColumnView(5, 20);
			sheet.setColumnView(6, 50);
			sheet.setColumnView(7, 20);
			sheet.setColumnView(8, 20);
			sheet.setColumnView(9, 20);
			sheet.setColumnView(10, 20);
			int i = 0;
			int numFila = 1;
			for (User clients : users) {
				sheet.addCell(new jxl.write.Label(i++,numFila,   String.valueOf(clients.getEnrollmentfinish().getId()).replaceAll("null", "   "),formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(clients.getSsn()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(clients.getSurnames()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(clients.getName()).replaceAll("null", "   "), formatCell));
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date today = clients.getEnrollmentfinish().getInitialTimeEnroll();
				String Inicio = df.format(today);
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(Inicio), formatCell));
				DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
				Date today2 = clients.getEnrollmentfinish().getFinalTimeEnroll();
				String Final = df2.format(today2);
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(Final), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(clients.getStatus()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(clients.getInstitution().getName()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(clients.getLastAccessChannel()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,  String.valueOf(clients.getAuth().getName()).replaceAll("null", "   "), formatCell));
				numFila = numFila + 1;
				i = 0;
			}
			numFila = 0;
			workbook.write();
			workbook.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos.toByteArray();

	}



	public byte[] GenerarExcelTrazability(List<TrazabilityLog> trazability) throws RowsExceededException, WriteException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			WorkbookSettings conf =  new WorkbookSettings();
			conf.setEncoding("ISO-8859-1");

			//WritableWorkbook  workbook = Workbook.createWorkbook(new File("C:\\Users\\Atianza 05\\Downloads\\Trazabilidad.xls"), conf);
			WritableWorkbook  workbook = Workbook.createWorkbook(baos, conf);
			WritableSheet sheet = workbook.createSheet("Reporte Exel", 0);
			WritableFont font = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD );
			WritableCellFormat formatCell = new WritableCellFormat(font);
			// create font style for header cells
			WritableFont headerCellFont = new WritableFont(WritableFont.ARIAL, 14,
					WritableFont.BOLD, true);
			//create format for header cells
			WritableCellFormat headerCellFormat = new WritableCellFormat(
					headerCellFont);
			// create header cells
			Label headerCell1 = new Label(0, 0, "getUuidTransaction", headerCellFormat);
			Label headerCell2 = new Label(1, 0, "getInitOperationDate", headerCellFormat);
			Label headerCell3 = new Label(2, 0, "getEndOperationTime", headerCellFormat);
			Label headerCell4 = new Label(3, 0, "getSourceAdress", headerCellFormat);
			Label headerCell5 = new Label(4, 0, "getGeoLocation", headerCellFormat);
			Label headerCell6 = new Label(5, 0, "getDeviceFingerPrint", headerCellFormat);
			Label headerCell7 = new Label(6, 0, "getUuidDevice", headerCellFormat);
			Label headerCell8 = new Label(7, 0, "getTypeAction", headerCellFormat);
			Label headerCell9 = new Label(8, 0, "getUrlMethod", headerCellFormat);
			// add header cells to sheet
			sheet.addCell(headerCell1);
			sheet.addCell(headerCell2);
			sheet.addCell(headerCell3);
			sheet.addCell(headerCell4);
			sheet.addCell(headerCell5);
			sheet.addCell(headerCell6);
			sheet.addCell(headerCell7);
			sheet.addCell(headerCell8);
			sheet.addCell(headerCell9);
			sheet.setColumnView(0, 50);
			sheet.setColumnView(1, 50);
			sheet.setColumnView(2, 50);
			sheet.setColumnView(3, 20);
			sheet.setColumnView(4, 50);
			sheet.setColumnView(5, 20);
			sheet.setColumnView(6, 50);
			sheet.setColumnView(7, 20);
			sheet.setColumnView(8, 20);
			int i = 0;
			int numFila = 1;
			for (TrazabilityLog trazabilitylog : trazability) {
				sheet.addCell(new jxl.write.Label(i++,numFila,   trazabilitylog.getUuidTransaction(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(trazabilitylog.getInitOperationDate()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(trazabilitylog.getEndOperationTime()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, trazabilitylog.getSourceAdress(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, trazabilitylog.getGeoLocation(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, trazabilitylog.getDeviceFingerPrint(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, trazabilitylog.getUuidDevice(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, trazabilitylog.getTypeAction(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, trazabilitylog.getUrlMethod(), formatCell));
				numFila = numFila + 1;
				i = 0;
			}
			numFila = 0;
			workbook.write();
			workbook.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return baos.toByteArray();
	}



	public byte[] GenerarExcelAuditoria(List<AuditLog> auditLogs) throws RowsExceededException, WriteException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			WorkbookSettings conf =  new WorkbookSettings();
			conf.setEncoding("ISO-8859-1");

			//WritableWorkbook  workbook = Workbook.createWorkbook(new File("C:\\Users\\Atianza 05\\Downloads\\Auditoria.xls"), conf);
			WritableWorkbook  workbook = Workbook.createWorkbook(baos, conf);
			WritableSheet sheet = workbook.createSheet("Reporte Exel", 0);
			WritableFont font = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD );
			WritableCellFormat formatCell = new WritableCellFormat(font);

			int i = 0;
			for (AuditLog auditoriaLog : auditLogs) {
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(auditoriaLog.getId()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(auditoriaLog.getEventDate()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getSourceAddress(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getEventType(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getUuidEvent(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getUsername(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(auditoriaLog.getInternal_user_id()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getEventComponent(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getEventDescription(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getEventCriticality(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getSystemResponse(), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, auditoriaLog.getUuidTransaction(), formatCell));
				numFila = numFila + 1;
				i = 0;
			}
			numFila = 0;
			workbook.write();
			workbook.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos.toByteArray();

	}

	public byte[] GenerarExcelDevices(List<Device> getListDevicesReport) throws RowsExceededException, WriteException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			WorkbookSettings conf =  new WorkbookSettings();
			conf.setEncoding("ISO-8859-1");

			//WritableWorkbook  workbook = Workbook.createWorkbook(new File("C:\\Users\\Atianza 05\\Downloads\\Enrollment.xls"), conf);
			WritableWorkbook  workbook = Workbook.createWorkbook(baos, conf);			    WritableSheet sheet = workbook.createSheet("Reporte Exel", 0);
			WritableFont font = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD );
			WritableCellFormat formatCell = new WritableCellFormat(font);
			// create font style for header cells
			WritableFont headerCellFont = new WritableFont(WritableFont.ARIAL, 14,
					WritableFont.BOLD, true);
			//create format for header cells
			WritableCellFormat headerCellFormat = new WritableCellFormat(
					headerCellFont);
			// create header cells
			Label headerCell1 = new Label(0, 0, "User Name", headerCellFormat);
			Label headerCell2 = new Label(1, 0, "SSn User", headerCellFormat);
			Label headerCell3 = new Label(2, 0, "AppName", headerCellFormat);
			Label headerCell4 = new Label(3, 0, "DeviceFingerPrint", headerCellFormat);
			Label headerCell5 = new Label(4, 0, "reportDate ", headerCellFormat);
			Label headerCell6 = new Label(5, 0, "EnabledAuth", headerCellFormat);
			Label headerCell7 = new Label(6, 0, "EnrollmentServerKey", headerCellFormat);
			Label headerCell8 = new Label(7, 0, "Status", headerCellFormat);
			Label headerCell9 = new Label(8, 0, "OsVersion", headerCellFormat);
			Label headerCell10 = new Label(9, 0, "tSo", headerCellFormat);
			Label headerCell11 = new Label(10, 0, "Uuid", headerCellFormat);
			Label headerCell12 = new Label(11, 0, "LastAccess", headerCellFormat);
			// add header cells to sheet
			sheet.addCell(headerCell1);
			sheet.addCell(headerCell2);
			sheet.addCell(headerCell3);
			sheet.addCell(headerCell4);
			sheet.addCell(headerCell5);
			sheet.addCell(headerCell6);
			sheet.addCell(headerCell7);
			sheet.addCell(headerCell8);
			sheet.addCell(headerCell9);
			sheet.addCell(headerCell10);
			sheet.addCell(headerCell11);
			sheet.addCell(headerCell12);
			sheet.setColumnView(0, 50);
			sheet.setColumnView(1, 50);
			sheet.setColumnView(2, 50);
			sheet.setColumnView(3, 20);
			sheet.setColumnView(4, 50);
			sheet.setColumnView(5, 20);
			sheet.setColumnView(6, 50);
			sheet.setColumnView(7, 20);
			sheet.setColumnView(8, 20);
			sheet.setColumnView(9, 20);
			sheet.setColumnView(10, 70);
			sheet.setColumnView(11, 20);
			int i = 0;
			int numFila = 1;
			for (Device ListaDevices : getListDevicesReport) {
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getUser().getName()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila,     String.valueOf(ListaDevices.getUser().getSsn()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getAppName()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getDeviceFingerPrint()).replaceAll("null", "   "), formatCell));
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date today = ListaDevices.getEnrollmentDate();
				String reportDate = df.format(today);
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(reportDate), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getEnabledAuth()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getEnrollmentServerKey()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getStatus()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getOsVersion()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getSo()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getUuid()).replaceAll("null", "   "), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(ListaDevices.getUser().getLastAccess().replaceAll("null", "   ")), formatCell));
				numFila = numFila + 1;
				i = 0;
			}
			numFila = 0;
			workbook.write();
			workbook.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos.toByteArray();


	}


	public byte[] GenerarExcelEnrollment(List<ErollmentReport> enrollmentTransactions) throws RowsExceededException, WriteException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			WorkbookSettings conf =  new WorkbookSettings();
			conf.setEncoding("ISO-8859-1");

			//WritableWorkbook  workbook = Workbook.createWorkbook(new File("C:\\Users\\Atianza 05\\Downloads\\Enrollment.xls"), conf);
			WritableWorkbook  workbook = Workbook.createWorkbook(baos, conf);
			WritableSheet sheet = workbook.createSheet("Reporte Exel", 0);
			WritableFont font = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD );
			WritableCellFormat formatCell = new WritableCellFormat(font);

			// create font style for header cells
			WritableFont headerCellFont = new WritableFont(WritableFont.ARIAL, 14,
					WritableFont.BOLD, true);
			//create format for header cells
			WritableCellFormat headerCellFormat = new WritableCellFormat(
					headerCellFont);
			// create header cells
			Label headerCell1 = new Label(0, 0, "UuidEnrollment", headerCellFormat);
			Label headerCell2 = new Label(1, 0, "SsnClient", headerCellFormat);
			Label headerCell3 = new Label(2, 0, "NameClient", headerCellFormat);
			Label headerCell4 = new Label(3, 0, "EnrollmentDate", headerCellFormat);
			Label headerCell5 = new Label(4, 0, "DeviceOs", headerCellFormat);
			Label headerCell6 = new Label(5, 0, "Status", headerCellFormat);
			Label headerCell7 = new Label(6, 0, "Scoring", headerCellFormat);
			Label headerCell8 = new Label(7, 0, "Status", headerCellFormat);
			Label headerCell9 = new Label(8, 0, "Institutions", headerCellFormat);
			Label headerCell10 = new Label(9, 0, "Estado", headerCellFormat);
			Label headerCell11 = new Label(10, 0, "NombreAplicacion", headerCellFormat);
			Label headerCell12 = new Label(11, 0, "FinalScoring", headerCellFormat);
			Label headerCell13 = new Label(11, 0, "TiempoTotalEnroll", headerCellFormat);
			// add header cells to sheet
			sheet.addCell(headerCell1);
			sheet.addCell(headerCell2);
			sheet.addCell(headerCell3);
			sheet.addCell(headerCell4);
			sheet.addCell(headerCell5);
			sheet.addCell(headerCell6);
			sheet.addCell(headerCell7);
			sheet.addCell(headerCell8);
			sheet.addCell(headerCell9);
			sheet.addCell(headerCell10);
			sheet.addCell(headerCell11);
			sheet.addCell(headerCell12);
			sheet.addCell(headerCell13);
			sheet.setColumnView(0, 50);
			sheet.setColumnView(1, 50);
			sheet.setColumnView(2, 50);
			sheet.setColumnView(3, 20);
			sheet.setColumnView(4, 50);
			sheet.setColumnView(5, 20);
			sheet.setColumnView(6, 50);
			sheet.setColumnView(7, 20);
			sheet.setColumnView(8, 20);
			sheet.setColumnView(9, 20);
			sheet.setColumnView(10, 20);
			sheet.setColumnView(11, 20);
			sheet.setColumnView(12, 20);
			int i = 0;
			int numFila = 1;
			for (ErollmentReport enrollment : enrollmentTransactions) {
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getUuidEnrollment()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getSsnClient()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getNameClient()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getEnrollmentDate()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getDeviceOs()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getStatus()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getScoring()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getInstitutions()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getEstado()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getNombreAplicacion()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getFinalScoring()), formatCell));
				sheet.addCell(new jxl.write.Label(i++,numFila, String.valueOf(enrollment.getTiempoTotalEnroll()), formatCell));

				numFila = numFila + 1;
				i = 0;
			}
			numFila = 0;
			workbook.write();
			workbook.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos.toByteArray();


	}

}
