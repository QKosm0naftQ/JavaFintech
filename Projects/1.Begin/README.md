### https://reactnative.dev/docs/set-up-your-environment?os=linux == VScode
# Встановлення компоментів
```
sudo dnf install nodejs java-17-openjdk
```
# Яка версія java і nodejs
```
> java -version
openjdk version "21.0.8" 2025-07-15
OpenJDK Runtime Environment (Red_Hat-21.0.8.0.9-1) (build 21.0.8+9)
OpenJDK 64-Bit Server VM (Red_Hat-21.0.8.0.9-1) (build 21.0.8+9, mixed mode, sharing)
> node -v
v22.20.0
```
# Скачати Extension Pack for Java з vscode

# Скачати окремо maven для java
### Створення проекту
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
```
## Запуск та очищення  (тут різні параметри , можуть бути окремо)
```
mvn compile exec:java -Dexec.mainClass="com.mycompany.app.App" 
mvn clean compile exec:java -Dexec.mainClass="com.mycompany.app.App"
mvn clean
mvn
mvn exec:java -Dexec.mainClass="com.mycompany.app.App"

mvn compile exec:java -Dexec.mainClass="com.mycompany.app.App"
```
