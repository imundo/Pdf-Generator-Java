package com.prueba.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;
import model.admin.transactions.EnrollTransaction;
import model.admin.transactions.TransactionAdmin;
import model.log.AuditLog;
import model.log.TrazabilityLog;
import model.mobile.Device;
import model.mobile.User;
import model.report.ErollmentReport;
import model.report.TransactionReport;

public class GeneradorCSV {

	public byte[] generarArchivoCSV(List<TransactionReport> transactionReport) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Charset charset = Charset.forName("UTF-8"); // ISO-8859-1
		CsvWriter csvwriter = new CsvWriter(baos, ',', charset);
		//CsvWriter csvwriter = new CsvWriter("C:\\Users\\Atianza 05\\Downloads\\Transacciones.csv");
		String [] valores = new String[17];


		for (TransactionReport transactionReporte : transactionReport) {

			valores[0] =String.valueOf(transactionReporte.getUuidTransaction());
			valores[1] =String.valueOf(transactionReporte.getSsnClient());
			valores[2] =String.valueOf(transactionReporte.getNameClient());
			valores[3] =String.valueOf(transactionReporte.getChannel());
			valores[4] =String.valueOf(transactionReporte.getTransactionName());
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date today = transactionReporte.getDateAuth();
			String Inicio = df.format(today);
			valores[5] =String.valueOf(Inicio);
			valores[6] =String.valueOf(transactionReporte.getMethodApplied());
			valores[7] =String.valueOf(transactionReporte.getDeviceOs());
			valores[8] =String.valueOf(transactionReporte.getStatus());
			valores[9] =String.valueOf(transactionReporte.getMonto());
			valores[10] =String.valueOf(transactionReporte.getAttrName());
			valores[11] =String.valueOf(transactionReporte.getAttrValue());
			valores[12] =String.valueOf(transactionReporte.getRecurrent());
			valores[13] =String.valueOf(transactionReporte.getRecurrent());
			valores[14] =String.valueOf(transactionReporte.getSubtypeTransaction());
			valores[15] =String.valueOf(transactionReporte.getRiskLevel());
			valores[16] =String.valueOf(transactionReporte.getMonetary());

			try {
				csvwriter.writeRecord(valores);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}







		csvwriter.close();
		return baos.toByteArray();

	}



	public byte[] generarArchivoCSVClients(List<User> listClient) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Charset charset = Charset.forName("UTF-8"); // ISO-8859-1
		CsvWriter csvwriter = new CsvWriter(baos, ';', charset);
		//CsvWriter csvwriter = new CsvWriter("C:\\Users\\Downloads\\Clients.csv");
		String [] valores = new String[11];

		for (User clients : listClient) {
			valores[0] = String.valueOf(clients.getEnrollmentfinish().getId());
			valores[1] = String.valueOf(clients.getSsn());
			valores[2] = String.valueOf(clients.getSurnames());
			valores[3] = String.valueOf(clients.getName());
			valores[4] = String.valueOf(clients.getEnrollmentDate());
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date today = clients.getEnrollmentfinish().getInitialTimeEnroll();
			String Inicio = df.format(today);
			valores[5] =  String.valueOf(Inicio);
			DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
			Date today2 = clients.getEnrollmentfinish().getFinalTimeEnroll();
			String Final = df2.format(today2);
			valores[6] = String.valueOf(Final);
			valores[7] = String.valueOf(clients.getStatus());
			valores[8] = String.valueOf(clients.getInstitution().getName());
			valores[9] = String.valueOf(clients.getLastAccessChannel());
			valores[10] =  String.valueOf(clients.getAuth().getName());
			try {
				csvwriter.writeRecord(valores);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		csvwriter.close();
		return baos.toByteArray();
	}


	public byte[] generarArchivoCSVTrazability(List<TrazabilityLog> trazability) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Charset charset = Charset.forName("UTF-8"); // ISO-8859-1
		CsvWriter csvwriter = new CsvWriter(baos, ',', charset);
		//CsvWriter csvwriter = new CsvWriter("C:\\Users\\Atianza 05\\Downloads\\Trazability.csv");
		String [] valores = new String[9];


		for (TrazabilityLog trazabilityLog : trazability) {

			valores[0] = trazabilityLog.getUuidTransaction();
			valores[1] = String.valueOf(trazabilityLog.getInitOperationDate());
			valores[2] = String.valueOf(trazabilityLog.getEndOperationTime());
			valores[3] = trazabilityLog.getSourceAdress();
			valores[4] = trazabilityLog.getGeoLocation();
			valores[5] = trazabilityLog.getDeviceFingerPrint();
			valores[6] = trazabilityLog.getUuidDevice();
			valores[7] = trazabilityLog.getTypeAction();
			valores[8] = trazabilityLog.getUrlMethod();


			try {
				csvwriter.writeRecord(valores);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


		csvwriter.close();
		return baos.toByteArray();
	}


	public byte[] generarArchivoCSVAuditoria(List<AuditLog> auditLogs) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Charset charset = Charset.forName("UTF-8"); // ISO-8859-1
		CsvWriter csvwriter = new CsvWriter(baos, ',', charset);


		//CsvWriter csvwriter = new CsvWriter("C:\\Users\\Atianza 05\\Downloads\\Auditoria.csv");
		String [] valores = new String[12];


		for (AuditLog auditoriaLog : auditLogs) {

			valores[0] =  String.valueOf(auditoriaLog.getId());
			valores[1] =  String.valueOf(auditoriaLog.getEventDate());
			valores[2] =  auditoriaLog.getSourceAddress();
			valores[3] =  auditoriaLog.getEventType();
			valores[4] =  auditoriaLog.getUuidEvent();
			valores[5] =  auditoriaLog.getUsername();
			valores[6] =  String.valueOf(auditoriaLog.getInternal_user_id());
			valores[7] =  auditoriaLog.getEventComponent();
			valores[8] =  auditoriaLog.getEventDescription();
			valores[9] =  auditoriaLog.getEventCriticality();
			valores[10] =  auditoriaLog.getSystemResponse();
			valores[11] =  auditoriaLog.getUuidTransaction();

			try {
				csvwriter.writeRecord(valores);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


		csvwriter.close();
		return baos.toByteArray();
	}

	public byte[] generarArchivoCSVDevices(List<Device> deviceList) {


		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Charset charset = Charset.forName("UTF-8"); // ISO-8859-1
		CsvWriter csvwriter = new CsvWriter(baos, ';', charset);
		//CsvWriter csvwriter = new CsvWriter("C:\\Users\\Downloads\\Clients.csv");
		String [] valores = new String[11];

		for (Device Dispositivo : deviceList) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date today = Dispositivo.getEnrollmentDate();
			String reportDate = df.format(today);
			valores[0] = String.valueOf(Dispositivo.getAppName());
			valores[1] = String.valueOf(Dispositivo.getDeviceFingerPrint());
			valores[2] = String.valueOf(Dispositivo.getComments());
			valores[3] = String.valueOf(Dispositivo.getEnrollmentServerKey());
			valores[4] = String.valueOf(Dispositivo.getOsVersion());
			valores[5] = String.valueOf(Dispositivo.getUser().getName());
			valores[6] = String.valueOf(Dispositivo.getUuid());
			valores[7] = String.valueOf(Dispositivo.getUser().getSsn());
			valores[8] = String.valueOf(Dispositivo.getUser().getLastAccess());
			valores[9] = String.valueOf(Dispositivo.getStatus());
			valores[10] = String.valueOf(reportDate);

			try {
				csvwriter.writeRecord(valores);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		csvwriter.close();
		return baos.toByteArray();
	}
	public byte[] generarArchivoCSVEnrollment(List<ErollmentReport> enrollmentTransactions) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Charset charset = Charset.forName("UTF-8"); // ISO-8859-1
		CsvWriter csvwriter = new CsvWriter(baos, ',', charset);
		//CsvWriter csvwriter = new CsvWriter("C:\\Users\\Downloads\\Enrollment.csv");
		String [] valores = new String[12];


		for (ErollmentReport enrollment : enrollmentTransactions) {

			valores[0] = enrollment.getUuidEnrollment();
			valores[1] = enrollment.getSsnClient();
			valores[2] = enrollment.getNameClient();
			valores[3] = enrollment.getEnrollmentDate();
			valores[4] = enrollment.getDeviceOs();
			valores[5] = enrollment.getStatus();
			valores[6] = enrollment.getScoring();
			valores[7] = enrollment.getInstitutions();
			valores[8] = enrollment.getEstado();
			valores[9] = enrollment.getNombreAplicacion();
			valores[10] = enrollment.getFinalScoring();
			valores[11] = enrollment.getTiempoTotalEnroll();

			try {
				csvwriter.writeRecord(valores);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


		csvwriter.close();
		return baos.toByteArray();
	}


}
