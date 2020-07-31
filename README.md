# User api 
El proyecto expone los siguientes endpoints:
* Post: http:dominio/user - crea usuario, ruta no protegida
* Get: http:dominio/user - obtiene lista de usuarios, ruta protegida (Debe autenticar para acceder al recurso)
* Post: http:dominio/authenticate - recurso para autenticar usuario, ruta no protegida
* Get: http:dominio/h2-console - recurso para ir a la consola de BD en memoria, ruta no protegida
### Pre-requisitos
* Java 8
* Gradle (recomendado)
* Git
## Comenzando 
Hacer un clone del repositorio, con el siguiente comando.
```
> git clone https://github.com/satihoyos/global-logic.git
```
### Instalando 
Compilar proyecto con gradle
* Si no tiene instalado gradle usar el embebido en el proyecto.
```
    > gradle wrapper build  #gradle embebido                        
    > gradle build #gradle instalado
```
* levantar proyecto.
```
    > cd build/libs/
    > java -jar user-api-0.0.1-SNAPSHOT.jar
```
## Endpoints
La aplicación tiene 3 usuarios  de pruebas: <br/>

user 1: jsati@prb.cl <br/>
password:hunterA22<br/>

user 2: test@prb.cl<br/>
password:hunterA22<br/>

user 3: deseable@prb.cl<br/>
password:hunterA22<br/><br/>
Ejemplo de como ejecutar los servicios expuestos por la api
### Crear Usuario
Este recurso no está protegido así que no le solicitará token.
Path: http:localhost:8080/user <br/>
Metodo: Post <br/>
Request:
```json
{
   "name":"Juan Rodriguez",
   "email":"juan@gmail.com",
   "password":"hunterA22",
   "phones":[
      {
         "number":"1234567",
         "citycode":"1",
         "contrycode":"57"
      }
   ]
}
```
La password debe tener una mayúscula, una minúscula y dos números seguidos.<br/>
Response:
```json
{
    "id": 1002,
    "created": "2020-07-31T16:40:48.459+00:00",
    "modified": "2020-07-31T16:40:48.459+00:00",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWFuQGdtYWlsLmNvbSIsImV4cCI6MTU5NjgxODQ0OCwiaWF0IjoxNTk2MjEzNjQ4fQ.tK2SCJbrE-fL9ayXfm1Dct8hoXXhnyDzZqOfJguEXGMk7e3gSKfZ-qBhAfbK8dv4LaeHTS-lbmdEc2IrqVQoYA",
    "last_login": "2020-07-31T16:40:48.459+00:00",
    "isactive": true
}
```
### Lista de Usuarios
Este recurso está protegido debe crear cabecera con token generado en autenticación.<br/>
Ejemplo de cabecera:
```
Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWFuQGdtYWlsLmNvbSIsImV4cCI6MTU5NjcyNDc0MSwiaWF0IjoxNTk2MTE5OTQxfQ.YDUOGcwmjTVX2AWVX0dYMTQwadCYdokDuIG1dfPQiRsM9c9LZLVxHuiXRKcpR1uOpEeg9YOt0GEt3MTm3WxZWg
```
Path: http:localhost:8080/user <br/>
Metodo: Get <br/>
```json
[
    {
        "id": 1001,
        "created": "2020-07-31",
        "modified": "2020-07-31",
        "username": "jsati@prb.cl",
        "phones": [],
        "last_login": "2020-07-31",
        "isactive": true
    },
    {
        "id": 1002,
        "created": "2020-07-31",
        "modified": "2020-07-31",
        "username": "juan@gmail.com",
        "phones": [
            {
                "number": "1234567",
                "citycode": "1",
                "contrycode": "57"
            }
        ],
        "active": true,
        "last_login": "2020-07-31",
        "isactive": true
    }
]
```
### Autenticación
Servicio que autentica y retorna token (jwt) de autorización. <br/>
Path: http:localhost:8080/authenticate <br/>
Metodo: Post <br/>
Request:
```json
{
   "username":"jsati@prb.cl",
   "password":"hunterA22"
}
```
response:
```json
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqc2F0aUBwcmIuY2wiLCJleHAiOjE1OTY2OTYyODQsImlhdCI6MTU5NjA5MTQ4NH0.6RzUHCRx6P2BqG2eVPBW0Bcg5abdHWpg6PDH1UzKx8RUc7Ks1PpF6XZQKuusqVxIPhT-O_Y-djP_SvSD9uQbcg"
}
```
### Consola de BD H2
JDBC URL: jdbc:h2:mem:desa <br/>
username: sa <br/>
password: --vacio-- <br/>
Path: http:localhost:8080/h2-console <br/>
Metodo: Get <br/>
