package pers.bik.es.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import pers.bik.es.common.EsMessage;

import java.io.IOException;

/**
 * 创建索引
 * @author yangkaifei
 * @date 2021/8/22 6:46 下午
 * @cersion 1.0
 */
public class Create {
    public static void main(String[] args) throws IOException {
        // 创建客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(EsMessage.ADDRESS,EsMessage.PORT,EsMessage.SCHEME)
                )
        );
        CreateIndexRequest indexRequest = new CreateIndexRequest("chat");
        CreateIndexResponse createIndexResponse = client.indices().create(indexRequest, RequestOptions.DEFAULT);
        // 响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println(String.format("响应状态 %s", acknowledged));
        // 关闭客户端
        client.close();
    }
}
