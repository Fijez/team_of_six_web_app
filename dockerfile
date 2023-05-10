# back
# устанавливаем самую лёгкую версию JVM
FROM bellsoft/liberica-openjdk-alpine:19.0.2

# указываем ярлык. Например, разработчика образа и проч. Необязательный пункт.
LABEL maintainer="aidavydenko23@gmail.com"

# указываем точку монтирования для внешних данных внутри контейнера (как мы помним, это Линукс)
VOLUME /tmp

# внешний порт, по которому наше приложение будет доступно извне
EXPOSE 8080

# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=build/libs/firstWebApp-0.0.1-SNAPSHOT.jar

# добавляем джарник в образ под именем rebounder-chain-backend.jar
ADD ${JAR_FILE} firstWebApp-0.0.1-SNAPSHOT.jar

# команда запуска джарника
ENTRYPOINT ["java","-jar","/firstWebApp-0.0.1-SNAPSHOT.jar"]