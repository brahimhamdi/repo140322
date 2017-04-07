#!/usr/bin/env bash
PROJECT_FOLDER=/root/procollect-java
SERVICE_SRC_FOLDER=${PROJECT_FOLDER}/batch/batch-statistic-yearly/target
ARTIFACT=batch-statistic-yearly-0.0.1-SNAPSHOT.jar
SERVICE_NAME=batch-statistic-yearly
SERVICE_INIT_FILE=/etc/init.d/${SERVICE_NAME}
SERVICE_DST_FOLDER=/var/spring-boot

mkdir -p /var/spring-boot
service ${SERVICE_NAME} stop
service ${SERVICE_NAME} status
unlink ${SERVICE_INIT_FILE}
rm  ${SERVICE_DST_FOLDER}/${ARTIFACT}
mv ${SERVICE_SRC_FOLDER}/${ARTIFACT} ${SERVICE_DST_FOLDER}/${ARTIFACT}
chmod +x ${SERVICE_DST_FOLDER}/${ARTIFACT}
ln -s ${SERVICE_DST_FOLDER}/${ARTIFACT} /etc/init.d/${SERVICE_NAME}
service ${SERVICE_NAME} start
service ${SERVICE_NAME} status