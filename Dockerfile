FROM java:16
ADD DZ1.java .
RUN javac DZ1.java
CMD ["java", "DZ1"]