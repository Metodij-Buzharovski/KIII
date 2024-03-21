<br><h3 align="center"><b>Проектна задача по предметот "Континуирана интеграција и испорака"<br></h3>
<h3 align="center">Employee Management System<br></h3>
<br><br>
<h4>Вовед<br></b></h4>
Проектот "Employee Management System" вклучуваше развој на веб-апликација за управување со вработени, проследено со нејзин deployment и на нејзината база на податоци на локален Minikube Kubernetes cluster, а потоа и на Microsoft Azure cloud-based Kubernetes cluster.<br><br>

![1](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/d3c0eb47-5c6b-4ac7-81ec-cac33468fb22)
<br><br><br>
<h4><b>Развој на апликацијата</b><br></h4>
Апликацијата е развиена со помош на Spring Boot framework. Таа потоа беше докеризирана со креирање на Dockerfile во којшто беше наведено како да се изгради docker image-от.<br><br>

![2](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/33b301df-0fea-4847-a17a-46b3b26d67b3)<br><br><br>

<h4>Docker Compose</h4>
Kористејќи Docker Compose направив pull на image од DockerHub за PostgreSQL база на податоци и креирав поврзани docker контејнери за базата и за апликацијата.<br><br>

![3](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/618882cd-473a-479b-86b4-9f85bd04abcf)<br><br>
![4](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/576d4c5d-6940-4bcc-a42c-5de496dfb057)
<br><br><br>
<h4>Minikube</h4>
На мојата локална машина инсталирав Minikube со цел да создадам локален Kubernetes cluster за тестирање. Потоа направив deploy на апликацијата и postgres базата на податоци во локалниот cluster користејќи ги postgres-configmap.yml (ги поврзува апликацијата и postgres базата), postgres-credentials.yml (ги содржи корисничкото име и password за конекција до postgres базата), postgres-deployment.yml (прави deploy на postgres базата) и deployment.yml (прави deploy на апликацијата).<br><br>

![5](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/68281b50-8835-4314-9954-70e34b6137b4)
<br><br><br>
<h4>Microsoft Azure Kubernetes Cluster</h4>
Откако се уверив дека тестирањето со Minikube помина успешно, креирав Kubernetes cluster на Microsoft Azure и направив deploy на апликацијата и postgres базата на податоци.<br><br>

![6](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/1318223d-2b0d-4b92-bdec-3604c2dbbd8a)
<br><br><br>
<h4>CI/CD pipeline</h4>
Инсталирав Jenkins како docker container на мојата локална машина. Кодот од апликацијата и deployment.yml фајлот ги поставив на мојот GitHub репозиториум. Потоа напишав скрипта во Jenkins што го зема кодот од GitHub репозиториумот, креира docker image, му прави push на мојот DockerHub репозиториум и потоа го користи deployment.yml за да го повлече image-от од DockerHub и да му направи deploy на Microsoft Azure. Скриптата се извршува
секој пат кога ќе се направи commit на GitHub-от со помош на webhooks.<br><br>

![7](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/e80ce246-ba17-4a46-bba6-e0b87216e0bc)<br><br>
![8](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/04833d5c-a547-4059-b226-ffa8ed213d56)<br>
<br><br><br>
<h4>GitHub Webhook</h4>
За повикување на Jenkins скриптата се користи GitHub Webhook, но бидејќи Jenkins е инсталиран на мојата локална машина, тој не е достапен за Webhook-от. За да се разреши овој проблем инсталирав програма наречена ngrok, којашто localhost го прави достапен за останатите компјутери на Интернет.<br><br>

![9](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/beadf0fa-fbf6-4539-a098-a392d3c70c0a)<br><br>
![10](https://github.com/Metodij-Buzharovski/KIII/assets/81751906/504a4d28-e230-4650-9503-d250401b0e70)<br>
<br><br>
<h4>Заклучок</h4>
Проектот успешно направи deploy на Employee Management System апликацијата во Kubernetes cluster. Deployment-от вклучуваше креирање на docker image од апликацијата, deployment на PostgreSQL база на податоци, инсталација на локален Minikube cluster за тестирање, deployment на апликацијата и базата во Microsoft Azure, имплементација на CI/CD pipeline кој користи Jenkins и употреба на GitHub Webhooks за активирање на скриптата.





