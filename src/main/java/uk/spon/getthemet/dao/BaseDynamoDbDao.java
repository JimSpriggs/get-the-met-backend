package uk.spon.getthemet.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;

import java.net.URI;

@Component
public class BaseDynamoDbDao {

    @Autowired
    private DynamoDbClientProxy dynamoDbClientProxy;

    public DynamoDbClient getDynamoDbClient() {
        return dynamoDbClientProxy.getDynamoDbClient();
    }
}
