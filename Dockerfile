FROM maven:3.5.2-jdk-8-slim

COPY . /usr/local/src/mongoTest
WORKDIR /usr/local/src/mongoTest

# 更换maven源
RUN sed -Ee "s/(<mirrors>)/\1\n    <mirror>\n      <id>alimaven<\/id>\n      <mirrorOf>central<\/mirrorOf>\n      <name>aliyun maven<\/name>\n      <url>http:\/\/maven.aliyun.com\/nexus\/content\/groups\/public\/<\/url>\n    <\/mirror>/" -i /usr/share/maven/conf/settings.xml

# 安装依赖
RUN mvn clean install -Dmaven.test.skip=true

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo "Asia/Shanghai" > /etc/timezone

CMD exec java -Xms128m -Xmx128m -jar ./target/demo-0.0.1-SNAPSHOT.jar

# 容器需要开放SSH 22端口
EXPOSE 9000