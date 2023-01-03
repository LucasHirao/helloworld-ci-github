FROM bellsoft/liberica-runtime-container:jre
WORKDIR /applications
COPY ./target/helloworld-ci-github-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT [ "java", "-jar", "application.jar" ]