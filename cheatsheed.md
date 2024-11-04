# Docker
- docker-compose -f docker-compose-dev.yaml --env-file .env.dev up -d
- docker-compose -f docker-compose-dev.yam down
- docker-compose up --build -d
- docker logs <container_name_or_id>
- docker exec -it <container_name_or_id> <command>
### Images
- docker save -o output_file.tar your_image_name:your_image_tag
- docker load -i output_file.tar

# Package the application using Maven or Gradle:
mvn clean package

# upload the .jar file to the server
- gzip output_file.tar
- scp target/myapp.jar user@server_ip:/path/to/deployment
- gunzip output_file.tar.gz

