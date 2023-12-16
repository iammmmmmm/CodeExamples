package http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * 向指定地址发送请求并接受返回值
 * 向部署在127.0.0.1：8868的paddleOcr hubserversing 发送推理请求并获得返回值
 *
 * @author Iammm
 * @Time 2023/12/1 12:03
 */
public class demo01 {
    static String url = "http://127.0.0.1:8868/predict/ocr_system";
    private static final Logger logger = LoggerFactory.getLogger(demo01.class);

    public static void main(String[] args) throws IOException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
// 创建HttpClient对象
        CloseableHttpClient httpclient = HttpClients.custom().setSSLContext(sslContext).build();

        // 创建HttpGet请求对象
/*
json格式：{"images":["图片的base64编码"]}
 */
        String jsonString = "{\"images\":[\"" + base64.demo01.imageToBase64("src/main/resources/jpimage.jpg") + "\"]}";
        StringEntity requestEntity = new StringEntity(jsonString, ContentType.APPLICATION_JSON);
        logger.debug(jsonString);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        logger.debug(String.valueOf(requestEntity));
        httpPost.setEntity(requestEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                logger.info(content);
            } else {
                logger.error("post fail,response code is not 200,response code is " + response.getStatusLine().getStatusCode() + "\n" + "the server say :{}", response);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }


}