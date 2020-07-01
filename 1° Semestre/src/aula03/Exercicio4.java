package aula03;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exercicio4 
{
	public static void main(String[] args) 
	{
		int num1=257;
		System.out.println(String.format("%05d", num1));
		
		String num2="2350000";
		System.out.println(num2.replaceAll("(\\d{1})(\\d{3})(\\d{3})", "$1.$2.$3"));
		
		DecimalFormat df = new DecimalFormat("0.000");
		double num3 = 5.6;
		System.out.println(df.format(num3));
		
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(1);
		double num4 = 1.278;
		System.out.println(nf.format(num4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		Calendar data = Calendar.getInstance();
		data.set(2016, 06, 15);
		System.out.print(new DateFormatSymbols().getWeekdays()[data.get(Calendar.DAY_OF_WEEK)] + ", ");
		System.out.println(sdf.format(data.getTime()));
	}
}
