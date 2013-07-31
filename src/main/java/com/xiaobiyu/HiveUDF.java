package com.xiaobiyu;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class HiveUDF extends UDF {
	private Text result = new Text();
	
	public Text evaluate(Text str){
		String phone = str.toString().substring(0, 3);
		result.set(phone);
		return result;
	}

}
