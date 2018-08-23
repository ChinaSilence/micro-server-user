FROM registry.cn-hangzhou.aliyuncs.com/micro-java/openjdk:8-jre-alpine

ENV TZ="Asia/Shanghai" JVM_PARAMS="" APP_CONFIG_URL="" APP_ENV="" APP_NAME="" APP_LABEL=""

ADD target/*.jar /server.jar

CMD java $JVM_PARAMS -Djava.security.egd=file:/dev/./urandom -jar /server.jar \
    --spring.cloud.config.uri=$APP_CONFIG_URL \
    --spring.cloud.config.profile=$APP_ENV \
    --spring.application.name=$APP_NAME \
    --spring.cloud.config.label=$APP_LABEL