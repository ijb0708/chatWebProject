FROM nginx:stable-alpine3.17

WORKDIR /usr/share/nginx/html

COPY dist .

EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]