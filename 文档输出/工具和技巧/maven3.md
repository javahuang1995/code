#maven整合SSH
##1.方法
要读官网，官网上有非常方便的依赖语句，针对maven的，还是针对gradle的，都有，还有各种帮助文档，手册，介绍，应该多看看，和公司使用的BME一样，也是人写的，多了解底层！！

##2.pom.xml
``` xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.huang.company</groupId>
	<artifactId>mavenweb</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>

	<dependencies>
		<dependency>
			<groupId>org.apache.struts</groupId>
			<artifactId>struts2-core</artifactId>
			<version>2.5.1</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>5.0.4.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.1.12.Final</version>
		</dependency>
	</dependencies>
	<build>
		<finalName>mavenweb</finalName>
		<plugins>
			<!-- 配置Tomcat插件 -->
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.2</version>
			</plugin>
		</plugins>

	</build>
</project>
```
##3.总结
哇！我好喜欢markdown,他的显示效果太舒服了！！

