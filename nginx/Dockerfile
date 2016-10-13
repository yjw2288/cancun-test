#
# Nginx Dockerfile
#
# https://github.com/dockerfile/nginx
#

# Pull base image.
FROM yjw2288/ubuntu

# Install Nginx.
RUN \
  add-apt-repository -y ppa:nginx/stable && \
  apt-get update && \
  apt-get install -y nginx && \
  rm -rf /var/lib/apt/lists/* && \
  echo "\ndaemon off;" >> /etc/nginx/nginx.conf && \
  chown -R www-data:www-data /var/lib/nginx

# Define mountable directories.
VOLUME ["/etc/nginx/sites-enabled", "/etc/nginx/certs", "/etc/nginx/conf.d", "/var/log/nginx", "/var/www/html"]

# Define working directory.
WORKDIR /etc/nginx

COPY nginx/app.conf /etc/nginx/conf.d/app.conf

RUN rm /etc/nginx/sites-enabled/default
RUN rm /etc/nginx/sites-available/default

# Define default command.
CMD ["nginx"]

RUN mkdir /app
ADD src/main/webapp/WEB-INF/resources /app/resources

# Expose ports.
EXPOSE 80
EXPOSE 443

