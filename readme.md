# 电影订票系统后端

采用Spring MVC框架 （ Spring4 + ThymeLeaf + Hibernate ）

## 安装

- MySQL

[个人安装使用教程](http://http://www.hshhuan.xyz/topics/mysql/)

设置`root`用户密码为`123456`


- Maven

[官方安装教程](http://maven.apache.org/install.html)

## 部署

	```sh
	$ mvn clean compile tomcat7:run
	```

## 访问

- 浏览器访问[http://localhost:8080](http://localhost:8080)

- 使用curl工具
	- [官方下载](http://www.paehl.com/open_source/?CURL_7.53.1)
	- [官方使用教程](https://curl.haxx.se/docs/manual.html)

更多API见[API-Description]()

## 单元测试

	```sh
	$ mvn test
	```

### 许可

见 [License](./LICENSE)