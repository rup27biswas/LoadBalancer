# LoadBalancer
Spring boot -LoadBalancer

Create an application to mimic a simple load balancer.
There should be an API to register backend server instances.
Each backend server must have a unique identifier and it should not be possible to register the same address
twice. The maximum number of backend server instances load balancer can have is 10.
There should be a second API of get() which when invoked should return a unique identifier of available
backend servers randomly.
