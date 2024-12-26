## Для корректной работы нужно сделать несколько действий
 - Для запуска необходимо выполнить команду 
```shell
docker-compose up -d
```
 - Для нормального функционирования keycloak необходимо на локальную систему на которой запускается docker в файл "hosts" добавить строку: 127.0.0.1 keycloak - ниже приведён пример для linux
```shell
sudo sh -c "echo '127.0.0.1 keycloak' >> /etc/hosts"
```
Для windows файл расположен по адресу: C:\windows\system32\drivers\etc\hosts  
Для mac файл расположен по адресу: /private/etc/hosts  
 - Доступ к [UI](http://localhost:3000) логин и пароль: report
 - Доступ к [админке](http://localhost:8080) логин и пароль: admin
 - Для остановки и удаления docker контейнеров
```shell
docker-compose down
```