cd jenkins-ci-cd
docker build -t ubuntu_sshd .

docker run -itd --name=lab-server -p 4080:8080 -p 9001:9001  ubuntu_sshd /bin/bash
docker exec -it lab-server bash


docker run -itd -m 500m --link lab-server -p 8080:8080 -p 50000:50000 --name=myjenkins ubuntu_sshd /bin/bash

docker exec -it myjenkins bash






