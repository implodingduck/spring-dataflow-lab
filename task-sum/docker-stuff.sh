docker stop task-sum
docker container rm task-sum
docker build -t task-sum .
docker run --env-file ../.env --network spring-dataflow --name task-sum task-sum