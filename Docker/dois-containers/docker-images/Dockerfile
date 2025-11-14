FROM php:8.2-apache

# Instalar as extensões do MySQL
RUN docker-php-ext-install pdo pdo_mysql

# Definir o diretório de trabalho
WORKDIR /var/www/html