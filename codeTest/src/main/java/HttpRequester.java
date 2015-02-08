
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;

/**
 * *************************************************************************************
 * 请求发送工具类 默认编码UTF-8
 *
 * @author yujialin
 */
public class HttpRequester {

    private final static Logger logger = LoggerFactory.getLogger(HttpRequester.class);

    /**
     * 使用连接池方式HttpClient
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String post(String url) throws Exception {
        return post(url, null, HTTP.UTF_8);
    }

    /**
     * 使用连接池方式HttpClient
     *
     * @param url
     * @param paramMap
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> paramMap) throws Exception {
        return post(url, paramMap, HTTP.UTF_8);
    }

    /**
     * 使用连接池方式HttpClient
     *
     * @param url
     * @param paramMap
     * @param charset
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> paramMap, String charset) throws Exception {
        String returnMsg = "";
        InputStream in = null;
        try {
            HttpClient httpClient = HttpConnectionManager.getHttpClient();
            HttpPost httpPost = createHttpPost(url, paramMap, charset);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                in = httpEntity.getContent();
                returnMsg = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
            }
            logger.info("HttpClient Recv:" + returnMsg);
            httpPost.abort();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("HttpClient:" + errorException(e));
                }
            }
        }
        return returnMsg;
    }

    /**
     * 自定义的HttpClient
     *
     * @param url
     * @param connectTimeout
     * @param readTimeout
     * @return
     * @throws Exception
     */
    public static String post(String url, int connectTimeout, int readTimeout) throws Exception {
        return post(url, null, HTTP.UTF_8, connectTimeout, readTimeout);
    }

    /**
     * 自定义的HttpClient
     *
     * @param url
     * @param paramMap
     * @param connectTimeout
     * @param readTimeout
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> paramMap, int connectTimeout, int readTimeout)
            throws Exception {
        return post(url, paramMap, HTTP.UTF_8, connectTimeout, readTimeout);
    }

    /**
     * *****************************************
     * 自定义的HttpClient
     *
     * @param url
     * @param paramMap
     * @param charset
     * @param connectTimeout
     * @param readTimeout
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> paramMap, String charset, int connectTimeout,
                              int readTimeout) throws Exception {
        String returnMsg = "";
        HttpClient httpClient = null;
        try {
            httpClient = HttpConnectionManager.getHttpClient(connectTimeout, readTimeout);
            HttpPost httpPost = createHttpPost(url, paramMap, charset);
            httpPost.setHeader("Connection", "close");
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                returnMsg = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
            }
            logger.info("HttpClient Recv:" + returnMsg);
            httpPost.abort();
        } finally {
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return returnMsg;
    }

    /**
     * 函数功能：POST XML数据
     *
     * @param url
     * @param str
     * @return
     * @throws Exception
     * @author Miner 2012-5-18 下午02:09:19
     */
    public static String postXML(String url, String str) throws Exception {
        return post(url, str, "application/xml", HTTP.UTF_8);
    }
    /**
     * 函数功能：POST XML数据
     *
     * @param url
     * @param str
     * @return
     * @throws Exception
     * @author Miner 2012-5-18 下午02:09:19
     */
    public static String postXMLGBK(String url, String str) throws Exception {
        return post(url, str, "application/xml", "GBK");
    }

    /**
     * 函数功能：POST JSON数据
     *
     * @param url
     * @param str
     * @return
     * @throws Exception
     * @author Miner 2012-5-18 下午02:09:00
     */
    public static String postJSON(String url, String str) throws Exception {
        return post(url, str, "application/json", HTTP.UTF_8);
    }

    /**
     * 函数功能：以字节流的方式传递数据
     *
     * @param url
     * @param str
     * @param mineType
     * @param charset
     * @return
     * @throws Exception
     * @author Miner 2012-5-18 下午02:08:24
     */
    public static String post(String url, String str, String mineType, String charset) throws Exception {
        String returnMsg = "";
        InputStream in = null;
        try {
            HttpClient httpClient = HttpConnectionManager.getHttpClient();
            HttpPost httpPost = createHttpPost(url, str, mineType, charset);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                in = httpEntity.getContent();
                returnMsg = EntityUtils.toString(httpEntity, charset);
                EntityUtils.consume(httpEntity);
            }
            logger.info("HttpClient Recv:" + returnMsg);
            httpPost.abort();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("HttpClient:" + errorException(e));
                }
            }
        }
        return returnMsg;
    }

    /**
     * 创建HTTPPOST，并塞入参数
     *
     * @param url
     * @param paramMap
     * @param charset
     * @return
     * @throws Exception
     */
    private static HttpPost createHttpPost(String url, Map<String, String> paramMap, String charset) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (paramMap != null) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();// 用于存放请求参数
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, charset));
        }
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
        httpPost.addHeader("Accept-Language", "zh-cn");
        logger.info("HttpClient Post:" + EntityUtils.toString(httpPost.getEntity()));
        return httpPost;
    }

    /**
     * 函数功能：创建以字节流传递数据的POST对象
     *
     * @param url
     * @param str
     * @param mineType
     * @param charset
     * @return
     * @throws Exception
     * @author Miner 2012-5-18 下午02:07:24
     */
    private static HttpPost createHttpPost(String url, String str, String mineType, String charset) throws Exception {
        HttpPost httpPost = new HttpPost(url);

        if (!StringUtils.isBlank(str)) {
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(str.getBytes(charset));
            httpPost.setEntity(byteArrayEntity);
        }
        httpPost.addHeader("Content-Type", mineType + ";charset=" + charset);
        httpPost.addHeader("Accept-Language", "zh-cn");
        //logger.info("HttpClient Post:" + EntityUtils.toString(httpPost.getEntity()));
        return httpPost;
    }

    /**
     * HttpClient直接连接接口，包含上传文件
     *
     * @param url        接口的URL
     * @param requestMap 字符串的请求参数
     * @param file       上传的文件
     * @param coding     编码
     * @return
     * @throws Exception
     */
    public static String postFile(String url, HashMap<String, String> requestMap, File file, String coding)
            throws Exception {
        String returnMsg = "";
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(URLEncoder.encode(url, "UTF-8"));
            // 对请求的表单域进行填充
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("file", new FileBody(file));
            // 先迭代HashMap
            Iterator<String> it = requestMap.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                reqEntity.addPart(key, new StringBody(requestMap.get(key), Charset.forName(coding)));
            }
            httpPost.setEntity(reqEntity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                returnMsg = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
            }
            httpPost.abort();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return returnMsg;
    }

    public static String get(String url) throws Exception {
        String returnMsg = "";
        InputStream in = null;
        try {
            logger.info("HttpClient Get:" + url);
            // url = EncodingUtils.getString(url.getBytes(), charset);
            HttpClient httpClient = HttpConnectionManager.getHttpClient();
            HttpGet httpGet = new HttpGet();
            httpGet.setURI(new URI(url));
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            if (httpEntity != null) {
                in = httpEntity.getContent();
                returnMsg = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
            }
            logger.info("HttpClient Recv:" + returnMsg);
            httpGet.abort();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("HttpClient:" + errorException(e));
                }
            }
        }
        return returnMsg;
    }

    // 得到Exception的详细信息
    public static String errorException(Exception e) {
        StackTraceElement[] ste = e.getStackTrace();
        if (ste == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(e.getMessage() + "\n ");
        for (int i = 0; i < ste.length; i++) {
            sb.append(ste[i].toString() + "\n ");
        }
        return sb.toString();
    }
    
    public static void main(String[] argus) {
    	try {
			System.out.println("陈发勇".getBytes().length);

    		String[] strArr = new String[]{"陈发勇"};
    	 
    		for (int i = 0;i < strArr.length; i++) {
	    		System.out.println(strArr[i]);
	    		System.out.println(StrToBinstr(strArr[i]));
	    		System.out.println();
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    	}
    }
    
    private static String StrToBinstr(String str) {
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            result +=Integer.toBinaryString(strChar[i])+ " ";
        }
        return result;
    }
    
}
