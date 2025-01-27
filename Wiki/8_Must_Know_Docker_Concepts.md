 8 Must Know Docker Concepts:

Docker completely changes the game by making your app portable and consistent across environments.

1. Dockerfile
What it does: Automates image creation step by step.
Key Commands:
• docker build -t my-app . → Build an image from a Dockerfile.
• docker history <image-name> → See how the image was built.

2. Docker Image
What it does: It is the read-only blueprint for containers, packaging your app with its dependencies.
Key Commands:
• docker images → List all images.
• docker rmi <image-name> → Remove an image.
• docker inspect <image-name> → View image details.

3. Docker Container
It is a running instance of an image. 
What it does: Runs your app in isolated environments.
Key Commands:
• docker run -d -p 8080:80 nginx → Run a container in detached mode.
• docker ps → List running containers.
• docker exec -it <container-id> /bin/bash → Access the container shell.
• docker logs <container-id> → View logs from a running container.
• docker stop <container-id> → Stop a container.

4. Docker Registry
It stores and distributes Docker images (e.g., DockerHub).
What it does: Enables sharing and versioning of images.
Key Commands:
• docker login → Authenticate to a registry.
• docker push <repo/image-name> → Push an image to the registry.
• docker pull <repo/image-name> → Download an image from the registry.
• docker tag <image> <repo/image:tag> → Add a tag to an image.

5. Docker Volumes
What it does: Keeps data even if the container is deleted.
Key Commands:
• docker volume create my-data → Create a volume.
• docker volume ls → List all volumes.
• docker volume rm my-data → Remove a volume.

6. Docker Compose
It is used to define and run multi-container Docker applications using a simple YAML file.
What it does: Orchestrates services, networks, and volumes for multiple containers.
Key Commands:
• docker-compose up → Start services.
• docker-compose down → Stop and remove services.
• docker-compose logs → View logs of all services.
• docker-compose ps → See the status of containers.

7. Docker Networks
It allow containers to communicate securely.
What it does: Ensures isolated and connected environments for containers.
Key Commands:
• docker network create my-network → Create a network.
• docker run --network my-network nginx → Run a container in a network.
• docker network inspect my-network → View details of a network.
• docker network prune → Remove unused networks.

8. Docker CLI
A command-line interface for managing Docker.
What it does: Simplifies everything from building images to managing containers.
Common Commands:
• docker build -t my-app . → Build an image.
• docker run -d -p 8080:80 my-app → Run a container.
• docker ps -a → List all containers (running & stopped).
• docker stop <container-id> → Stop a container.
• docker system prune → Clean up unused images, containers, and volumes.

![image](https://github.com/user-attachments/assets/8824f2d7-1219-4fcd-83ee-07ecb4c3b683)

Source/Credit: https://www.linkedin.com/posts/akashsinnghh_8-must-know-docker-concepts-docker-completely-activity-7288773376423129088-z5LO?utm_source=share&utm_medium=member_desktop
