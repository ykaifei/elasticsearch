package pers.bik.es.connect;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import pers.bik.es.common.EsMessage;

import java.io.IOException;

/**
 * 链接
 * @author yangkaifei
 * @date 2021/8/22 6:29 下午
 * @cersion 1.0
 */
public class Connect {
    public static void main(String[] args) {
        // 创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(EsMessage.ADDRESS,EsMessage.PORT,EsMessage.SCHEME)
                )
        );

        // 关闭客户端
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
