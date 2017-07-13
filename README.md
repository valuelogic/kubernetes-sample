# kubernetes-sample
Sample service for Kubernetes created for presentation


## Other samples


##### Pod

1) Creating pod manually:

```
kubectl create -f others/SamplePod.yaml
```

1) Checking output:

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