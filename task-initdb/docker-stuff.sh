docker stop task-initdb
docker container rm task-initdb
docker build -t task-initdb .
docker run --env-file ../.env --network spring-dataflow --name task-initdb task-initdb -it /bin/bash