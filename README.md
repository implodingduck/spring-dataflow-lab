# spring-dataflow-lab

## Prerequisites

* Kubernetes Cluster
* Helm >= 3.10.3
* Kubectl
* If azure... az cli and have ran `az aks get-credentials -g RESOURCEGROUPNAME -n AKSCLUSTERNAME`

## Setup

Install Spring Data Flow
```
helm install spring-dataflow oci://registry-1.docker.io/bitnamicharts/spring-cloud-dataflow --version 23.1.4 --set server.image.tag=2.11.0-debian-11-r7

export SERVICE_PORT=$(kubectl get --namespace default -o jsonpath="{.spec.ports[0].port}" services spring-dataflow-spring-cloud-dataflow-server)

kubectl port-forward --namespace default svc/spring-dataflow-spring-cloud-dataflow-server ${SERVICE_PORT}:${SERVICE_PORT} & echo "http://127.0.0.1:${SERVICE_PORT}/dashboard"

```

## Add Application
name: spring-dataflow-lab
type: task
spring boot version: 3.x
uri: docker:ghcr.io/implodingduck/spring-dataflow-lab:latest

## Create task
spring-dataflow-lab

## Launching a Task

```
deployer.spring-dataflow-lab.kubernetes.secret-key-refs=[{envVarName: 'DB_URL', secretName: 'jdbc-connection', dataKey: 'DB_URL'}, {envVarName: 'DB_USERNAME', secretName: 'jdbc-connection', dataKey: 'DB_USERNAME'}, {envVarName: 'DB_PASSWORD', secretName: 'jdbc-connection', dataKey: 'DB_PASSWORD'}]
deployer.spring-dataflow-lab.kubernetes.secret-refs=jdbc-connection
```

## Troubleshooting
```
kubectl exec -it spring-dataflow-mariadb-0 -- bash
mariadb -u $MARIADB_USER -p $MARIADB_DATABASE
```

---

```
DROP TABLE BOOT3_TASK_SEQ;
CREATE TABLE BOOT3_TASK_SEQ (
  ID BIGINT NOT NULL,
  UNIQUE_KEY CHAR(1) NOT NULL,
  constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
);
INSERT INTO BOOT3_TASK_SEQ VALUES (1,'0');

DROP TABLE BOOT3_BATCH_JOB_EXECUTION_SEQ;
CREATE TABLE BOOT3_BATCH_JOB_EXECUTION_SEQ (
  ID BIGINT NOT NULL,
  UNIQUE_KEY CHAR(1) NOT NULL,
  constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
);
INSERT INTO BOOT3_BATCH_JOB_EXECUTION_SEQ VALUES (1,'0');

DROP TABLE BOOT3_BATCH_STEP_EXECUTION_SEQ;
CREATE TABLE BOOT3_BATCH_STEP_EXECUTION_SEQ (
  ID BIGINT NOT NULL,
  UNIQUE_KEY CHAR(1) NOT NULL,
  constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
);
INSERT INTO BOOT3_BATCH_STEP_EXECUTION_SEQ VALUES (1,'0');

DROP TABLE BOOT3_TASK_EXECUTION_METADATA_SEQ;
CREATE TABLE BOOT3_TASK_EXECUTION_METADATA_SEQ (
  ID BIGINT NOT NULL,
  UNIQUE_KEY CHAR(1) NOT NULL,
  constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
);
INSERT INTO BOOT3_TASK_EXECUTION_METADATA_SEQ VALUES (1,'0');


DROP TABLE BOOT3_BATCH_JOB_SEQ;
CREATE TABLE BOOT3_BATCH_JOB_SEQ (
  ID BIGINT NOT NULL,
  UNIQUE_KEY CHAR(1) NOT NULL,
  constraint UNIQUE_KEY_UN unique (UNIQUE_KEY)
);
INSERT INTO BOOT3_BATCH_JOB_SEQ VALUES (1,'0');
```

---

```
mariadb -u root -p
SET GLOBAL general_log = 'ON';
tail -f /bitnami/mariadb/data/spring-dataflow-mariadb-0.log
```

## Notes
* https://github.com/bitnami/charts/tree/main/bitnami/spring-cloud-dataflow
* https://bitnami.com/stack/spring-cloud-dataflow/helm
* https://github.com/spring-projects/spring-batch/blob/main/spring-batch-samples/src/main/resources/jobs/tradeJob.xml
* https://github.com/spring-guides/gs-batch-processing




