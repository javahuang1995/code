cd /home/taotao/code

#pull down
git pull origin dev


cd /home/taotao/code/java/java_taotao商城/taotao-manager
mvn clean tomcat7:redeploy -DskipTests

cd /home/taotao/code/java/java_taotao商城/taotao-portal
mvn clean tomcat7:redeploy -DskipTests

cd /home/taotao/code/java/java_taotao商城/taotao-rest
mvn clean tomcat7:redeploy -DskipTests


cd /home/taotao/code/java/java_taotao商城/taotao-search
mvn clean tomcat7:redeploy -DskipTests


cd /home/taotao/code/java/java_taotao商城/taotao-sso
mvn clean tomcat7:redeploy -DskipTests






