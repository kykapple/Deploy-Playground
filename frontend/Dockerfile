FROM nginx

RUN mkdir /build

COPY ./build /build

RUN rm /etc/nginx/conf.d/default.conf

COPY ./nginx.conf /etc/nginx/conf.d

CMD ["nginx", "-g", "daemon off;"]
