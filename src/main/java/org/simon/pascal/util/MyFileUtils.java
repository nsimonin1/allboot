package org.simon.pascal.util;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;

import com.google.common.io.ByteStreams;

public class MyFileUtils {

	 private static byte[] fileStreamToGson(String filePath) throws IOException{
	    	final ClassLoader classLoader = MyFileUtils.class.getClassLoader();    	
	    	return ByteStreams.toByteArray(classLoader.getResourceAsStream(filePath));    	 	
	 }
	  
	 public static String generateBase64Image(String filePath) throws IOException
	 {
	     return Base64.encodeBase64String(fileStreamToGson(filePath));
	 }
}
