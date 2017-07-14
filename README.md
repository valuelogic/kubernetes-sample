# kubernetes-sample

Sample service for Kubernetes created for presentation.

## Build

1) Build project

```
mvn clean build
```

or

```
mvn clean istall
```

2) Build and push docker image

```
mvn clean package docker:build -DpushImage -DpushImageTags -DdockerImageTags=<VERSION>
```

## Local development

1) Run locally

```
./run.sh
```

## DevOps with Kubernetes

Service is prepared to be deployed in Kubernetes.


## Other samples

##### Pod

1) Creating pod manually:

```
kubectl create -f others/SamplePod.yaml
```

2) Checking output:

a) Log in to nginx-container

```
kubectl exec -it sample-pod -c nginx-container -- /bin/bash
```

b) Install curl

```
apt-get update
apt-get install curl
apt-get install less
```

c) Check output of `debian-container`

```
curl localhost
less /usr/share/nginx/html/index.html
```

d) Check logs

```
kubectl logs sample-pod -c nginx-container
```