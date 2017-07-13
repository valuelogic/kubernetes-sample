.PHONY:	build push

IMAGE = kubernetes-sample
TAG = 0.1

build:
	docker build -t mwrona/$(IMAGE):$(TAG) .

push:
	docker push mwrona/$(IMAGE):$(TAG)