# What Problem Distributed Tracing Solves?

![alt text](image.png)
![alt text](image-1.png)
![alt text](image-2.png)
![alt text](image-3.png)
![alt text](image-4.png)
![alt text](image-5.png)
Note : Sleuth has been deprecated for spring boot 3.
To do distributed tracing we need to use Micrometer

# How Distributed Tracing Works

![alt text](image-6.png)
![alt text](image-7.png)


-- Add the Zipkin dependency in the services:
```
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
      <groupId>io.micrometer</groupId>
      <artifactId>micrometer-tracing-bridge-brave</artifactId>
    </dependency>
    <dependency>
      <groupId>io.zipkin.reporter2</groupId>
      <artifactId>zipkin-reporter-brave</artifactId>
    </dependency>

```
and add the zipkin property in the service : 

```
spring.zipkin.base-url=http://127.0.0.1:9411/
spring.sleuth.sampler.probability=1.0

```

- Run the zipkin jar and call the service api to see the traces in  Zipkin dashboard