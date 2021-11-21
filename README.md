# LoadBalancer
Spring boot -LoadBalancer
Create an application to mimic a simple load balancer.
There should be an API to register backend server instances.
Each backend server must have a unique identifier and it should not be possible to register the same address
twice. The maximum number of backend server instances load balancer can have is 10.
There should be a second API of get() which when invoked should return a unique identifier of available
backend servers randomly.

**Below are the payload details:**

**1.API to check availability**
URL: http://localhost:9090/hello
Method : GET

**2.API to register new server instance**

URL:http://localhost:9090/registerInstance
Method : POST
ContentType : application/JSON
Body:
{
	"ipAddress": "122.21.21.13",
	"port": 8080
}

**2.API to get server instance**

URL:http://localhost:9090/getInstance
Method : GET
ContentType : application/JSON

