docker stop task-randomnumbers
docker container rm task-randomnumbers
docker build -t task-randomnumbers .
docker run --env-file ../.env --network spring-dataflow --name task-randomnumbers task-randomnumbers