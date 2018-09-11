package org.githup.es.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import java.util.TimeZone;
public class DateUtil {
	
	public static Date SolrDateConvertDate(String solrDate) {
		Date solrDateTarget=null;
		if(StringUtils.isNotBlank(solrDate) && !"null".equals(solrDate)) {
			
			try {
				solrDateTarget = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(solrDate);
				//System.out.println(solrDateTarget.toString());
			} catch (Exception e) {
				e.printStackTrace();
				return solrDateTarget;
			}
		}
		return solrDateTarget;
	}
	
	public static void main(String[] args) {
		System.out.println(TimeZone.getDefault());
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			System.out.println(new Date(1523983035000L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
