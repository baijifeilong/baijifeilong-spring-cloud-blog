# SpringCloud 演示

> 用于演示SpringCloud应用架构的博客项目

## 1. 模块说明

### 1.1 依赖管理(parent目录)

- `blog-parent` 根模块
- `blog-api-parent` API模块的根模块
- `blog-provider-parent` 服务模块的根模块

### 1.2 基础模块

- `blog-code-generator` 代码生成器模块，用于JOOQ代码生成
- `blog-generated-jooq` 生成的JOOQ代码
- `blog-foundation` 公用模块
- `blog-eureka` 注册中心服务器

### 1.3 业务模块

- `blog-user-api` 用户服务的Feign接口
- `blog-user-service` 用户服务
- `blog-article-api` 文章服务的Feign接口
- `blog-article-service` 文章服务

## 2. 实现的功能

- 注册中心服务器`Eureka`
- 基于`Feign`的`RPC`调用
- RPC异常转业务异常

## 3. 目录结构

```text
├── HELP.md
├── README.md
├── base
│   ├── blog-code-generator
│   │   ├── HELP.md
│   │   ├── blog-code-generator.iml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── io
│   │       │   │       └── github
│   │       │   │           └── baijifeilong
│   │       │   │               └── blog
│   │       │   │                   └── code
│   │       │   │                       └── generator
│   │       │   │                           └── BlogCodeGeneratorApplication.java
│   │       │   └── resources
│   │       │       ├── 1.sql
│   │       │       └── application.properties
│   │       └── test
│   │           └── java
│   │               └── io
│   │                   └── github
│   │                       └── baijifeilong
│   │                           └── blog
│   │                               └── code
│   │                                   └── generator
│   │                                       └── BlogCodeGeneratorApplicationTests.java
│   ├── blog-eureka
│   │   ├── HELP.md
│   │   ├── blog-eureka.iml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── io
│   │       │   │       └── github
│   │       │   │           └── baijifeilong
│   │       │   │               └── blog
│   │       │   │                   └── eureka
│   │       │   │                       └── BlogEurekaApplication.java
│   │       │   └── resources
│   │       │       └── application.properties
│   │       └── test
│   │           └── java
│   │               └── io
│   │                   └── github
│   │                       └── baijifeilong
│   │                           └── blog
│   │                               └── eureka
│   │                                   └── BlogEurekaApplicationTests.java
│   ├── blog-foundation
│   │   ├── HELP.md
│   │   ├── blog-foundation.iml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── io
│   │       │   │       └── github
│   │       │   │           └── baijifeilong
│   │       │   │               └── blog
│   │       │   │                   └── foundation
│   │       │   │                       ├── BlogFoundationApplication.java
│   │       │   │                       ├── BlogFoundatonAutoConfiguration.java
│   │       │   │                       ├── constant
│   │       │   │                       │   └── ExceptionConstants.java
│   │       │   │                       ├── exception
│   │       │   │                       │   └── RpcException.java
│   │       │   │                       └── feign
│   │       │   │                           └── ArticleErrorDecoder.java
│   │       │   └── resources
│   │       │       ├── META-INF
│   │       │       │   └── spring.factories
│   │       │       └── blog-foundation.properties
│   │       └── test
│   │           └── java
│   │               └── io
│   │                   └── github
│   │                       └── baijifeilong
│   │                           └── blog
│   │                               └── foundation
│   │                                   └── BlogFoundationApplicationTests.java
│   └── blog-generated-jooq
│       ├── HELP.md
│       ├── blog-generated-jooq.iml
│       ├── mvnw
│       ├── mvnw.cmd
│       ├── pom.xml
│       └── src
│           ├── main
│           │   ├── java
│           │   │   └── io
│           │   │       └── github
│           │   │           └── baijifeilong
│           │   │               └── blog
│           │   │                   └── generated
│           │   │                       └── jooq
│           │   │                           ├── DefaultCatalog.java
│           │   │                           ├── blog
│           │   │                           │   ├── Blog.java
│           │   │                           │   ├── Indexes.java
│           │   │                           │   ├── Keys.java
│           │   │                           │   ├── Tables.java
│           │   │                           │   └── tables
│           │   │                           │       ├── Article.java
│           │   │                           │       ├── User.java
│           │   │                           │       └── records
│           │   │                           │           ├── ArticleRecord.java
│           │   │                           │           └── UserRecord.java
│           │   │                           └── thatcher
│           │   │                               ├── Indexes.java
│           │   │                               ├── Keys.java
│           │   │                               ├── Tables.java
│           │   │                               ├── Thatcher.java
│           │   │                               └── tables
│           │   │                                   ├── Article.java
│           │   │                                   ├── GreatUser.java
│           │   │                                   ├── User.java
│           │   │                                   └── records
│           │   │                                       ├── ArticleRecord.java
│           │   │                                       ├── GreatUserRecord.java
│           │   │                                       └── UserRecord.java
│           │   └── resources
│           │       └── application.properties
│           └── test
│               └── java
│                   └── io
│                       └── github
│                           └── baijifeilong
│                               └── blog
│                                   └── generated
│                                       └── jooq
│                                           └── BlogGeneratedJooqApplicationTests.java
├── business
│   ├── blog-article-api
│   │   ├── HELP.md
│   │   ├── blog-article-api.iml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── io
│   │       │   │       └── github
│   │       │   │           └── baijifeilong
│   │       │   │               └── blog
│   │       │   │                   └── article
│   │       │   │                       └── api
│   │       │   │                           ├── ArticleApi.java
│   │       │   │                           ├── BlogArticleApiApplication.java
│   │       │   │                           └── domain
│   │       │   │                               └── Article.java
│   │       │   └── resources
│   │       │       └── application.properties
│   │       └── test
│   │           └── java
│   │               └── io
│   │                   └── github
│   │                       └── baijifeilong
│   │                           └── blog
│   │                               └── article
│   │                                   └── api
│   │                                       └── BlogArticleApiApplicationTests.java
│   ├── blog-article-provider
│   │   ├── HELP.md
│   │   ├── blog-article-provider.iml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── io
│   │       │   │       └── github
│   │       │   │           └── baijifeilong
│   │       │   │               └── blog
│   │       │   │                   └── article
│   │       │   │                       └── provider
│   │       │   │                           ├── BlogArticleProviderApplication.java
│   │       │   │                           ├── controller
│   │       │   │                           │   └── ArticleController.java
│   │       │   │                           └── service
│   │       │   │                               └── ArticleService.java
│   │       │   └── resources
│   │       │       └── application.properties
│   │       └── test
│   │           └── java
│   │               └── io
│   │                   └── github
│   │                       └── baijifeilong
│   │                           └── blog
│   │                               └── article
│   │                                   └── provider
│   │                                       └── BlogArticleProviderApplicationTests.java
│   ├── blog-user-api
│   │   ├── HELP.md
│   │   ├── blog-user-api.iml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   ├── pom.xml
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   │   └── io
│   │       │   │       └── github
│   │       │   │           └── baijifeilong
│   │       │   │               └── blog
│   │       │   │                   └── user
│   │       │   │                       └── api
│   │       │   │                           ├── BlogUserApiApplication.java
│   │       │   │                           ├── UserApi.java
│   │       │   │                           └── domain
│   │       │   │                               └── User.java
│   │       │   └── resources
│   │       │       └── application.properties
│   │       └── test
│   │           └── java
│   │               └── io
│   │                   └── github
│   │                       └── baijifeilong
│   │                           └── blog
│   │                               └── user
│   │                                   └── api
│   │                                       └── BlogUserApiApplicationTests.java
│   └── blog-user-provider
│       ├── HELP.md
│       ├── blog-user-provider.iml
│       ├── mvnw
│       ├── mvnw.cmd
│       ├── pom.xml
│       └── src
│           ├── main
│           │   ├── java
│           │   │   └── io
│           │   │       └── github
│           │   │           └── baijifeilong
│           │   │               └── blog
│           │   │                   └── user
│           │   │                       └── provider
│           │   │                           ├── BlogUserProviderApplication.java
│           │   │                           ├── constant
│           │   │                           │   └── UserExceptionConstants.java
│           │   │                           ├── controller
│           │   │                           │   └── UserController.java
│           │   │                           ├── exception
│           │   │                           │   ├── UserException.java
│           │   │                           │   ├── UserExistException.java
│           │   │                           │   └── UserNotExistException.java
│           │   │                           └── service
│           │   │                               └── UserService.java
│           │   └── resources
│           │       └── application.properties
│           └── test
│               └── java
│                   └── io
│                       └── github
│                           └── baijifeilong
│                               └── blog
│                                   └── user
│                                       └── provider
│                                           └── BlogUserProviderApplicationTests.java
├── mvnw
├── mvnw.cmd
├── parent
│   ├── blog-api-parent
│   │   ├── HELP.md
│   │   ├── blog-api-parent.iml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   └── pom.xml
│   ├── blog-parent
│   │   ├── HELP.md
│   │   ├── blog-parent.iml
│   │   ├── mvnw
│   │   ├── mvnw.cmd
│   │   └── pom.xml
│   └── blog-provider-parent
│       ├── HELP.md
│       ├── blog-provider-parent.iml
│       ├── mvnw
│       ├── mvnw.cmd
│       └── pom.xml
└── pom.xml
```

## LICENSE

GLP-3.0