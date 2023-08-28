package uk.spon.getthemet.dao;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import uk.spon.getthemet.entity.MetrolinkStation;
import uk.spon.getthemet.entity.MetrolinkStationBuilder;
import uk.spon.getthemet.exception.MetrolinkStationNotFoundException;

import java.util.Map;
import java.util.Optional;

@Component
public class MetrolinkStationDao extends BaseDynamoDbDao {

    private static final String TABLE_NAME = "metrolink_station";
    private static final String NAME = "name";

    public MetrolinkStation getMetrolinkStationByName(String name) {
        return Optional.ofNullable(
                getDynamoDbClient().getItem(
                    GetItemRequest.builder()
                            .tableName(TABLE_NAME)
                            .key(Map.of(NAME, AttributeValue.builder().s(name).build()))
                            .build()
                )
            )
            .map(GetItemResponse::item)
            .map(this::convert)
            .orElseThrow(() -> new MetrolinkStationNotFoundException("No such Metrolink station: " + name));
    }

    private MetrolinkStation convert(final Map<String, AttributeValue> item) {
        if (item == null || item.isEmpty()) {
            return null;
        }

        return MetrolinkStationBuilder.aMetrolinkStation()
                .withName(item.get(NAME).s())
                .build();
    }
}

