# spring-dataflow-lab

## Prerequisites

* Kubernetes Cluster
* Helm
* Kubectl
* If azure... az cli and have ran `az aks get-credentials -g RESOURCEGROUPNAME -n AKSCLUSTERNAME`

## Setup

Install Spring Data Flow
```
helm repo add azure-marketplace https://marketplace.azurecr.io/helm/v1/repo

helm install my-release azure-marketplace/spring-cloud-dataflow

export SERVICE_PORT=$(kubectl get --namespace default -o jsonpath="{.spec.ports[0].port}" services spring-dataflow-spring-cloud-dataflow-server)

kubectl port-forward --namespace default svc/spring-dataflow-spring-cloud-dataflow-server ${SERVICE_PORT}:${SERVICE_PORT} & echo "http://127.0.0.1:${SERVICE_PORT}/dashboard"

```

## Launching a Task
```
deployer.spring-dataflow-lab.kubernetes.secret-key-refs=[{envVarName: 'DB_URL', secretName: 'jdbc-connection', dataKey: 'DB_URL'}, {envVarName: 'DB_USERNAME', secretName: 'jdbc-connection', dataKey: 'DB_USERNAME'}, {envVarName: 'DB_PASSWORD', secretName: 'jdbc-connection', dataKey: 'DB_PASSWORD'}]
deployer.spring-dataflow-lab.kubernetes.secret-refs=jdbc-connection
```

## Notes
* https://bitnami.com/stack/spring-cloud-dataflow/helm
* https://github.com/spring-projects/spring-batch/blob/main/spring-batch-samples/src/main/resources/jobs/tradeJob.xml
* https://github.com/spring-guides/gs-batch-processing