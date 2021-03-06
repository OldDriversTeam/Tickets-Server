
# 电影订票系统后端[![Build Status](https://travis-ci.org/OldDriversTeam/Tickets-Server.svg?branch=master)](https://travis-ci.org/OldDriversTeam/Tickets-Server)

采用Spring MVC框架 （ Spring + Hibernate + MySQL）实现RESTful接口


## 安装

- MySQL

	- [个人安装使用教程](http://www.hshhuan.xyz/archives/win10-install-mysql-5-7-zip/)

	- 设置`root`用户密码为`123456`


- Maven

	- [官方安装教程](http://maven.apache.org/install.html)

## 部署

```sh
$ mvn clean compile tomcat7:run
```

## 访问

- Web root 根目录
```
http://localhost:8080
```
- Web API
见[Tickets-Documentation/API-Description](https://github.com/OldDriversTeam/Tickets-Documentation/blob/master/API-description.mdown)

## 测试工具

- 浏览器
- curl
	- [官方下载](http://www.paehl.com/open_source/?CURL_7.53.1)
	- [官方使用教程](https://curl.haxx.se/docs/manual.html)



## 单元测试（持续集成测试）

```sh
$ mvn test
```

### 许可

见 [License](./LICENSE.md)
