#安装maven
配置好环境变量，这个不多说
#配置maven
打开maven安装目录，打开conf目录下的setting.xml文件。
配置**本地仓库位置**
``` xml
<localRepository>D:/java/maven_repo</localRepository>
```
配置好这个目录，maven就会把库什么的都下载都这个路径下，感觉maven和tomcat一样，很多东西一开始使用都是从配置xml文件开始的。

#配合eclipse使用
先明确一个概念，那就是maven软件包括2个部分，一个部分就是maven软件，也就是maven命令，另外一个部分就是maven仓库。maven软件目录中有setting.xml，如果你直接通过命令行使用maven的话，读取的就是maven软件目录中的setting.xml，如果你是通过eclipse使用meaven的话，读取的是eclipse配置的setting.xml，你都可以自由配置。
1. 先安装maven插件
2. 配置setting.xml文件，eclipse需要通过你配置的setting.xml读取仓库的位置

#maven的基本概念
groupId是项目组织唯一的标识符，实际对应JAVA的包的结构，是main目录里java的目录结构。
比如com.huang.company，就是java概念中独一无二的域名的reverse字符串
artifactId就是项目的唯一的标识符，实际对应项目的名称，就是项目根目录的名称。比如projA
那么通过这2个坐标就可以在独一无二的确定软件项目的位置了，com.huang.company,projA









