package com.tuean.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


public class PacketsX509TrustManager implements X509TrustManager{

	private static Logger logger = LoggerFactory.getLogger(PacketsX509TrustManager.class);

    private Certificate cert = null;

    public PacketsX509TrustManager() throws CertificateException, IOException {

    	// TODO   证书位置未确定
//    	String certificate_url = "";
////		if ("\\".equals(File.separator)) {
////			// is WINDOWS
//////			certificate_url = System.getProperty("catalina.home") + "\\webapps\\tuean\\WEB-INF\\classes\\server.crt";
////			certificate_url = System.getProperty("user.dir") + "\\target\\classes\\server.crt";
////			System.out.println("WINDOWS path:" + certificate_url);
////	    } else if ("/".equals(File.separator)) {
////	    	// is LINUX
////	    	certificate_url = System.getProperty("user.dir") + "/target/classes/server.crt";
////	        System.out.print(System.getProperty("user.dir"));
////	    }
//
//			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
////			File file=resolver.getResource("classpath:server.crt").getFile();
//
//			InputStream is = resolver.getResource("classpath:server.crt").getInputStream();
////            FileInputStream fis = new FileInputStream("src/main/resources/server.crt");
////            FileInputStream fis = new FileInputStream(file);
////            FileInputStream fis = new FileInputStream("D:/server.crt");
////            FileInputStream fis = new FileInputStream("src/main/resources/linux.txt");
//            BufferedInputStream bis = new BufferedInputStream(is);
//
//            CertificateFactory cf = CertificateFactory.getInstance("X.509");
//
//            while (bis.available() > 0) {
//                cert = cf.generateCertificate(bis);
////              System.out.println(cert.toString());
//            }
//            bis.close();
//			is.close();
//            //modify by libing 20161551
////            fis.close();
    }

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}  

  
}
