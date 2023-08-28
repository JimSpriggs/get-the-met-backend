package uk.spon.getthemet.dao;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;

import java.net.URI;

@Component
public class DynamoDbClientProxy {

    private final DynamoDbClient dynamoDbClient;

    public DynamoDbClientProxy() {
        final String dynamoDbEndpoint = System.getenv("DYNAMO_DB_ENDPOINT_OVERRIDE");

        DynamoDbClientBuilder builder = DynamoDbClient.builder();
        builder.httpClient(ApacheHttpClient.builder().build());
        if (dynamoDbEndpoint != null && !dynamoDbEndpoint.isEmpty()) {
            builder.endpointOverride(URI.create(dynamoDbEndpoint));
        }

        this.dynamoDbClient = builder.build();
    }

    public DynamoDbClient getDynamoDbClient() {
        return dynamoDbClient;
    }
}
