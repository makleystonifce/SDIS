version: '3.9'

services:
  web:
    image: php:8.2-apache
    container_name: php_hello
    ports:
      - "8080:80"
    volumes:
      - .:/var/www/html
