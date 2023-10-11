docker stop mariadbtest
docker rm mariadbtest
docker run --name mariadbtest -e MYSQL_ROOT_PASSWORD=mypass --network spring-dataflow -p 3306:3306 -d -v $(pwd)/mariadb:/var/lib/mysql mariadb:10.11.5