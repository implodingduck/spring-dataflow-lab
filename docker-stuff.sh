docker stop spring-dataflow-lab
docker container rm spring-dataflow-lab
docker build -t spring-dataflow-lab .
docker run --env-file .env --name spring-dataflow-lab spring-dataflow-lab