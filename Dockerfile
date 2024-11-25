# Usa uma imagem base do Java com Alpine para ser leve
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho no container
WORKDIR /app

# Copia os arquivos de configuração do Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Copia o restante do projeto
COPY src ./src

# Permite executar o script mvnw
RUN chmod 777 mvnw

# Constrói o projeto e ignora testes
RUN ./mvnw package -DskipTests

# Lista o diretório target para confirmar o nome do arquivo JAR
RUN ls -l ./target

# Define o comando de execução
CMD ["java", "-jar", "target/sitebd-0.0.1-SNAPSHOT.war"]
