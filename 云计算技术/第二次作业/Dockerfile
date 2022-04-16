# version 0.1
FROM centos:7
RUN ["yum", "install","-y","java-1.8.0-openjdk*"]
RUN ["yum", "install","-y","wget"]
WORKDIR /opt

RUN ["wget", "https://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-8/v8.5.78/bin/apache-tomcat-8.5.78.tar.gz","--no-check-certificate"]

RUN ["tar", "-zxvf", "apache-tomcat-8.5.78.tar.gz"]
RUN ["mv", "apache-tomcat-8.5.78","tomcat"]
WORKDIR /opt/tomcat/webapps

RUN ["mkdir","app"]

ENTRYPOINT ["/opt/tomcat/bin/catalina.sh", "run"]

EXPOSE 8080
