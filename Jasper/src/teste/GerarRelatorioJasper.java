package teste;

import java.sql.Connection;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class GerarRelatorioJasper {
		
	public void gerar() {
			
		String arquivoXML = "C:\\Users\\leo_n\\JaspersoftWorkspace\\MyReports\\First.jrxml";
		Connection con = new TesteJasper().getConexao();
			
		try {
			JasperReport jr = JasperCompileManager.compileReport(arquivoXML);
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			
			//JasperViewer.viewReport(jp);
			JasperExportManager.exportReportToPdfFile(jp, "relatorio.pdf");
			
			con.close();
		}
		catch (SQLException e) {
			//Logger.getLogger(GerarRelatorioJasper.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("ERRO SQLExcpetion");
		}
		catch (JRException e) {
			//Logger.getLogger(GerarRelatorioJasper.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("ERRO JRException");
		}
	}
	
	public static void main(String[] args) {
		
		GerarRelatorioJasper teste = new GerarRelatorioJasper();
		teste.gerar();
		
	}
}
