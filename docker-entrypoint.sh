#!/bin/sh

# Set default JVM options if not provided
JAVA_OPTS=${JAVA_OPTS:-"-XX:+UseContainerSupport -XX:MaxRAMPercentage=75"}

# Security optimization (use non-blocking entropy source)
SECURITY_OPTS="-Djava.security.egd=file:/dev/./urandom"

# Add Spring Boot profiles if specified
if [ -n "$SPRING_PROFILES_ACTIVE" ]; then
    SPRING_OPTS="--spring.profiles.active=$SPRING_PROFILES_ACTIVE"
fi

# Start application
exec java ${JAVA_OPTS} ${SECURITY_OPTS} -jar app.jar ${SPRING_OPTS} "$@"