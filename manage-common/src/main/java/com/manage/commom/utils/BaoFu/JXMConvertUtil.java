/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.manage.commom.utils.BaoFu;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import java.util.HashMap;
import java.util.Iterator;

public class JXMConvertUtil{	
	
	public static String XmlConvertJson(String XMLString){
		XMLSerializer xmlSerializer = new XMLSerializer();  
	    String xmltojson = xmlSerializer.read(XMLString).toString();
		return xmltojson;
	}
	
	@SuppressWarnings("rawtypes")
	public static HashMap<String, String> JsonConvertHashMap(Object object)
	   {  
	       HashMap<String, String> RMap = new HashMap<String, String>();
	       // 灏唈son瀛楃涓茶浆鎹㈡垚jsonObject  
	       JSONObject jsonObject = JSONObject.fromObject(object);  
	       Iterator it = jsonObject.keys();
	       // 閬嶅巻jsonObject鏁版嵁锛屾坊鍔犲埌Map瀵硅薄  
	       while (it.hasNext()){  
	           String key = String.valueOf(it.next());
	           String value = (String) jsonObject.get(key);
	           RMap.put(key, value);  
	       }  
	       return RMap;
	   }  


}