# Jersey in action

## Jersey 实战
### 1. 为什么使用jersey

* Jersey是JAX-RS的参考实现
* JAX-RS是定义了Java API for RESTful Web Service的JSR(Java Specification Requests)标准
* JAX-RS是Java EE的一部分，可以结合Java EE的其他技术简化RESTful开发

### 2. Jersey

- 核心服务器（Core Server）：通过提供JSR 311 中标准化的注释和 API 标准化，您可以用直观的方式开发 RESTful Web 服务。
- 核心客户端（Core Client）：Jersey 客户端 API 帮助您与 REST 服务轻松通信。
- 集成（Integration）：Jersey 还提供可以轻松集成 Spring、Guice、Apache Abdera 的库

### 3. Jersey开发符合RESTful的Web Application

github address: [https://github.com/qianyan/jersey-in-action](http://)

```
两个branch
  di
* master
  module-di-test
```

#### #1 构建 RESTful 应用
* 基于JAX-RS
* @Path, @Produces, @GET, @PathParam

#### #2 使用 grizzly 进行容器内集成测试
* grizzly address: [https://grizzly.java.net/](http://)
* 继承 jersey 提供的 JerseyTest
* 重写 getTestContainerFactory， 提供 TestContainer 实例
* 流式的 http 访问 `target()
                .request()
                .get(new GenericType<String>() {
                });`

#### #3 使用 hk2 DI
* hk2 介绍[ https://hk2.java.net/2.3.0/](http://)
* hk2 的 AbstractBinder
* hk2 和 jersey 集成，register binder

#### #4 使用 hk2 locator 进行 Module 集成测试
* ServiceLocator 使用
* service 层的集成测试

#### #5 题外
* h2 in-memory database


### 4. 应用所需要的依赖
#### #1 jersey
##### compile
- org.glassfish.jersey.core:jersey-server:$jerseyVersion

#### run
- org.glassfish.jersey.containers:jersey-container-servlet:$jerseyVersion

#### test
- org.glassfish.jersey.test-framework:jersey-test-framework-core:$jerseyVersion
  org.glassfish.jersey.containers:jersey-container-grizzly2-servlet:$jerseyVersion

#### #2 hk2
#### compile
- javax.inject:javax.inject:$javaInjectVersion
- org.glassfish.hk2:hk2-api:$hk2Version

#### test
- org.glassfish.hk2:hk2-locator:$hk2Version
