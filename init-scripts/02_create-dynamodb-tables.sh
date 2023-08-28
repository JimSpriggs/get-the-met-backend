#!/bin/bash

echo "########### Creating metroling_station table with global secondary index ###########"
aws   $AWS_ENDPOINT dynamodb create-table \
         --table-name metrolink_station \
         --attribute-definitions \
           AttributeName=id,AttributeType=S \
           AttributeName=name,AttributeType=S \
        --key-schema AttributeName=id,KeyType=HASH AttributeName=name,KeyType=RANGE \
        --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
        --global-secondary-indexes \
                  "[
                      {
                          \"IndexName\": \"name\",
                          \"KeySchema\": [{\"AttributeName\":\"name\",\"KeyType\":\"HASH\"}],
                          \"Projection\":{
                              \"ProjectionType\":\"ALL\"
                          },
                          \"ProvisionedThroughput\": {
                              \"ReadCapacityUnits\": 5,
                              \"WriteCapacityUnits\": 5
                          }
                      }
                  ]"

echo "########### Describing a table ###########"
aws   $AWS_ENDPOINT dynamodb describe-table --table-name metrolink_station --output table

echo "########### Inserting test data into a table ###########"
aws   $AWS_ENDPOINT dynamodb put-item --table-name metrolink_station --item "{\"id\":{\"S\":\"c3d9493c-29f6-4d95-958c-1dcbd9c67592\"},\"name\":{\"S\":\"Prestwich\"},\"pids\":{\"L\":[{\"S\":\"PRS-TPTD01\"},{\"S\":\"PRS-TPTS01\"}]}}"
aws   $AWS_ENDPOINT dynamodb put-item --table-name metrolink_station --item "{\"id\":{\"S\":\"7906a302-3227-46d1-a47e-eea36948ed9a\"},\"name\":{\"S\":\"St Peter's Square\"},\"pids\":{\"L\":[{\"S\":\"SPS-PID01\"},{\"S\":\"SPS-PID02\"},{\"S\":\"SPS-PID03\"},{\"S\":\"SPS-PID04\"},{\"S\":\"SPS-PID05\"},{\"S\":\"SPS-PID06\"}]}}"

echo "########### Selecting all data from a table ###########"
aws   $AWS_ENDPOINT dynamodb scan --table-name metrolink_station

echo "########### Creating metrolink_pid table with global secondary index ###########"
aws   $AWS_ENDPOINT dynamodb create-table \
         --table-name metrolink_pid \
         --attribute-definitions \
           AttributeName=id,AttributeType=S \
           AttributeName=s_id,AttributeType=S \
        --key-schema AttributeName=id,KeyType=HASH \
        --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
        --global-secondary-indexes \
                  "[
                      {
                          \"IndexName\": \"name\",
                          \"KeySchema\": [{\"AttributeName\":\"name\",\"KeyType\":\"HASH\"}],
                          \"Projection\":{
                              \"ProjectionType\":\"ALL\"
                          },
                          \"ProvisionedThroughput\": {
                              \"ReadCapacityUnits\": 5,
                              \"WriteCapacityUnits\": 5
                          }
                      }
                  ]"

echo "########### Describing a table ###########"
aws   $AWS_ENDPOINT dynamodb describe-table --table-name metrolink_pid --output table

echo "########### Inserting test data into a table ###########"
aws   $AWS_ENDPOINT dynamodb put-item --table-name metrolink_pid --item "{\"id\":{\"S\":\"PRS-TPTD01\"},\"fwd\":{\"L\":[{\"S\":\"PRS-TPTD01\"},{\"S\":\"PRS-TPTS01\"}]}}"
aws   $AWS_ENDPOINT dynamodb put-item --table-name metrolink_pid --item "{\"id\":{\"S\":\"7906a302-3227-46d1-a47e-eea36948ed9a\"},\"name\":{\"S\":\"St Peter's Square\"},\"pids\":{\"L\":[{\"S\":\"SPS-PID01\"},{\"S\":\"SPS-PID02\"},{\"S\":\"SPS-PID03\"},{\"S\":\"SPS-PID04\"},{\"S\":\"SPS-PID05\"},{\"S\":\"SPS-PID06\"}]}}"

echo "########### Selecting all data from a table ###########"
aws   $AWS_ENDPOINT dynamodb scan --table-name metrolink_station